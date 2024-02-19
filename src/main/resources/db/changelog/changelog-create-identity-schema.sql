--liquibase formatted sql

--changeset VitaliyTaranenko:create-identity-schema
--comment: create identity schema

CREATE SCHEMA identity
--rollback DROP SCHEMA identity




--changeset VitaliyTaranenko:create-user_accounts-table
--comment: createuser_accounts table

CREATE TABLE identity.user_accounts
(
    id       serial PRIMARY KEY,
    username VARCHAR(255) unique NOT NULL,
    password VARCHAR(255)        NOT NULL
)
--rollback DROP TABLE identity.user_account



--changeset VitaliyTaranenko:create-user_roles-table
--comment: create user_roles table
CREATE TABLE identity.user_roles
(
    id        serial PRIMARY KEY,
    authority VARCHAR(255) NOT NULL
)
--rollback DROP TABLE identity.user_roles



--changeset VitaliyTaranenko:create-user_account_roles-table
--comment: create user_accounts_roles table
CREATE TABLE identity.user_accounts_roles
(
    user_account_id INTEGER not null,
    user_role_id    INTEGER not null
)
--rollback DROP TABLE identity.user_account_roles



--changeset VitataliyTaranenko:add-user_accounts_roles-table-constraints
--comment add user_account_roles table constraints

ALTER TABLE identity.user_accounts_roles
    ADD CONSTRAINT user_account_roles_user_account_id_fkey
        FOREIGN KEY (user_account_id) REFERENCES identity.user_accounts (id);
ALTER TABLE identity.user_accounts_roles
    ADD CONSTRAINT user_account_roles_user_role_id_fkey
        FOREIGN KEY (user_role_id) REFERENCES identity.user_roles (id);
ALTER TABLE identity.user_accounts_roles
    ADD CONSTRAINT user_account_roles_user_account_id_user_role_id_key
        UNIQUE (user_account_id, user_role_id)
--ROLlBACK ALTER TABLE identity.user_accounts_roles DROP CONSTRAINT user_account_roles_user_account_id_fkey
--ROLlBACK ALTER TABLE identity.user_accounts_roles DROP CONSTRAINT user_account_roles_user_role_id_fkey
--ROLlBACK ALTER TABLE identity.user_accounts_roles DROP CONSTRAINT user_account_roles_user_account_id_user_role_id_key

--changeset VitaliyTaranenko:add-data-to-user_account-roles-table
--comment add data to user_accounts_roles table
INSERT INTO identity.user_roles (authority)
VALUES ('ROLE_USER'),
       ('ROLE_ADMIN');
--rollback TRUNCATE TABLE identity.user_roles