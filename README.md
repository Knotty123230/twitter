<!DOCTYPE html>
<html lang="en">

<body>

<h1>Twitter Project README</h1>

<h2>Project Description</h2>
<p>This project is developed using Spring Boot and is designed to create a simple social network similar to Twitter. It allows users to create, view, and manage tweets.</p>

<h2>Technology Stack</h2>
<ul>
    <li>Java 17</li>
    <li>Spring Boot 3.2.2</li>
    <li>Spring Data JPA</li>
    <li>Spring Security OAuth2 Resource Server</li>
    <li>Liquibase for database management</li>
    <li>PostgreSQL as the primary database management system</li>
    <li>Lombok to minimize boilerplate code</li>
    <li>SpringDoc for API documentation with OpenAPI 3</li>
    <li>SonarQube for code quality analysis</li>
    <li>JaCoCo for test coverage analysis</li>
    <li>Testcontainers for integration testing using Docker containers</li>
</ul>

<h2>Project Setup</h2>
<h3>Prerequisites</h3>
<p>To work on this project, you will need:</p>
<ul>
    <li>JDK 17</li>
    <li>Docker (for Testcontainers and, optionally, PostgreSQL)</li>
    <li>IntelliJ IDEA or any other IDE that supports Lombok and Spring Boot</li>
</ul>

<h3>Installation</h3>
<ol>
    <li>Clone the project repository.</li>
    <li>Open the project in your IDE.</li>
    <li>Ensure the Lombok plugin is installed and activated in your IDE.</li>
    <li>Start Docker if you plan to use Testcontainers or a local PostgreSQL instance in a container.</li>
    <li>Configure the database connection by specifying properties in the <code>application.properties</code> or <code>application.yml</code> file.</li>
</ol>

<h3>Running the Project</h3>
<p>Use the Spring Boot command to run the project:</p>
<code>./gradlew bootRun</code>

<h3>Testing</h3>
<p>To run the tests, use the following command:</p>
<code>./gradlew test</code>

<h3>SonarQube Analysis</h3>
<p>Before running the SonarQube analysis, make sure the SonarQube server is running. You can use the following settings for code analysis:</p>
<code>./gradlew sonarqube \
    -Dsonar.projectKey=twitter_project \
    -Dsonar.host.url=http://localhost:9000 \
    -Dsonar.login=sqp_be385413c59387daf03566fb7eef22fc5500b428</code>

<h3>Working with the API</h3>
<p>After starting the project, you can use Swagger UI to view and test the API at the following address:</p>
<code>http://localhost:8080/swagger-ui/index.html</code>

</body>
</html>
