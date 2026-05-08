# todoList

Java/Spring Boot learning project for a notes web application.

This repository is part of my backend learning path. It is not a commercial project. I keep it public because it shows my practice with Spring Boot, CRUD workflows, persistence, migrations, server-rendered UI, and basic authentication.

## What It Does

- User registration and login
- Notes list page
- Create, edit, and delete notes
- Server-rendered pages with Thymeleaf
- PostgreSQL persistence with Spring Data JPA
- Database migrations with Flyway
- Basic Spring Security configuration

## Tech Stack

- Java 17
- Spring Boot 3
- Spring MVC
- Spring Security
- Spring Data JPA
- Thymeleaf
- PostgreSQL
- Flyway
- Gradle

## Main Routes

- `GET /registration` - registration form
- `GET /login` - login form
- `GET /note/list` - notes list
- `GET /note/add` - add note form
- `POST /note/add` - create note
- `GET /note/edit?id={id}` - edit note form
- `POST /note/edit` - save note
- `POST /note/delete` - delete note

## Local Setup

Create a local PostgreSQL database, then copy `src/main/resources/application.example.properties` to `src/main/resources/application.properties` and adjust credentials.

Example:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/todolist
spring.datasource.username=postgres
spring.datasource.password=postgres
spring.jpa.hibernate.ddl-auto=validate
spring.jpa.show-sql=true
spring.flyway.enabled=true
```

Run:

```bash
./gradlew bootRun
```

## Status

Learning project. The next useful improvements would be a cleaner README with screenshots, test coverage, validation, and a Docker Compose setup for PostgreSQL.
