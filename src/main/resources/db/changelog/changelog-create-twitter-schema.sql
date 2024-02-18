--liquibase formatted sql

--changeset VitaliyTaranenko:create-twitter-schema
--comment: create twitter schema
CREATE SCHEMA IF NOT EXISTS twitter;
--rollback DROP SCHEMA twitter CASCADE