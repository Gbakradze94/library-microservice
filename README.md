## Electronic Library Microservice

# Introduction
Electronic library microservice project demo, by imaginary company 
called 'Space'. Project has two sub-modules: library-service and user-service.

## How To Use

To clone and run this application, you'll need 
[Git](https://git-scm.com), 
[Maven](https://maven.apache.org/), 
[Java 17](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html),
[PostgreSQL](https://www.postgresql.org/download/)

```bash
# Clone this repository
$ git clone https://github.com/Gbakradze94/library-microservice.git


# To run locally you need to create PostgreSQL database called 'libraryservicedb' and replace 
# datasource properties in application.yml
$  Secrets are provided as plain text only for demo purposes. In production secrets will not be stored <br/>
 as plaintext and pushed to repository using yaml file.

```

## Instructions to run
1. Create database called 'libraryservicedb' manually using PostgreSQL.
2. Provide local database admin and password.
3. Run the application
4. Access Swagger documentation at: [http://localhost:8081/openapi/webjars/swagger-ui/index.html]()

### Issues:
<br/>
<span style="color:red">
1. When sending multiple POST requests with same body, entities with duplicated key are created.
Needs to be fixed. <br/>
2. Due to time constraints the user-service and Feign reactive are not ready yet.
</span>