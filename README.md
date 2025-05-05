# Link Shortener

A URL shortening application built with Java, Spring Boot, Maven, and PostgreSQL. It provides both a responsive web UI and a REST API for shortening URLs, redirecting users, and viewing link statistics.

## Table of Contents

- [Overview](#overview)
- [Features](#features)
- [Architecture](#architecture)
- [Technology Stack](#technology-stack)
- [Setup and Installation](#setup-and-installation)
- [Usage](#usage)
  - [Web Interface](#web-interface)
  - [REST API](#rest-api)
- [Building and Running](#building-and-running)
- [Project Structure](#project-structure)
- [Swagger Documentation](#swagger-documentation)
- [License](#license)

## Overview

This application allows users to shorten long URLs into small shareable codes. It performs redirection to the original URL when the short code is accessed and maintains usage statistics.

## Features

- Shorten long URLs into a unique 6-character code.
- Redirect to the original URL on accessing the short code.
- Track usage statistics (creation date, last update, and use count).
- Responsive web interface built with Freemarker and Bootstrap.
- Complete REST API support with JSON responses.
- Global exception handling with custom error pages and API error messages.

## Architecture

- **Model**: Contains the `Url` entity, along with DTOs such as `UrlRequestDTO`, `UrlResponseDTO`, and `StatisticsDTO`.
- **Repository**: Uses Spring Data JPA with the `UrlRepository` for basic CRUD operations.
- **Service**: The `UrlShortenerService` contains business logic for URL creation, retrieval, update, and deletion.
- **Controllers**:
  - `WebController` provides the user interface views using Freemarker templates.
  - `ApiController` exposes REST endpoints.
- **Utils**: Contains utility methods like `UtilityClass` for Base62 encoding.
- **Exception Handling**: A global handler (`GlobalExceptionHandler`) manages custom exceptions like `UrlNotFoundException`.
- **Templates**: Freemarker templates in `src/main/resources/templates` render the web pages.

## Technology Stack

- **Languages**: Java, JavaScript
- **Frameworks**: Spring Boot, Spring Data JPA
- **Template Engine**: Freemarker
- **Database**: PostgreSQL
- **Build Tool**: Maven
- **UI**: Bootstrap
- **Documentation**: Swagger (Springdoc OpenAPI)

## Setup and Installation

1. **Prerequisites:**
   - Java 24
   - Maven
   - PostgreSQL


2. **Clone the Repository:**
```bash
git clone git@github.com:HamdaouiAbdelhake/LinkShortener.git
cd LinkShortener
```

3. **Configure the Database:**  
   Update the PostgreSQL connection properties in `src/main/resources/application.properties` if needed.

4. **Install Dependencies:**
```bash
mvn clean install
```

## Usage

### Web Interface

- **Home Page:**  
  Visit [http://localhost:8080](http://localhost:8080) to access the URL shortening form.
  
- **Redirect:**  
  Access a shortened URL via [http://localhost:8080/{code}](http://localhost:8080/{code}).

- **Statistics Page:**  
  Use [http://localhost:8080/{code}/stats](http://localhost:8080/{code}/stats) or check stats via the provided form.

### REST API

The application exposes endpoints under `/api`:

- **GET /api/shorten/{code}**  
  Retrieve the original URL and update use count.

- **GET /api/shorten/{code}/stats**  
  Retrieve statistics for a given short code.

- **POST /api/shorten**  
  Create a new shortened URL (accepts a JSON body with the long URL).

- **PUT /api/shorten/{code}**  
  Update the long URL corresponding to a short code.

- **DELETE /{code}**  
  Delete the URL record associated with the short code.

## Building and Running

Run the application using Maven:
```bash
mvn spring-boot:run
```

The server will start at [http://localhost:8080](http://localhost:8080).


## Swagger API Documentation

Swagger UI is available at [http://localhost:8080/api-docs](http://localhost:8080/api-docs) for interactive API documentation and testing.

## License

This project is licensed under the GNU Lesser General Public License (LGPL) version 3.  
For details, see the [LICENSE.md](./LICENSE.md) file.
```