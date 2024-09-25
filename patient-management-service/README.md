# Patient Management Service

## Overview
The Patient Management Service handles patient records, including creation, retrieval, update, and deletion of patient data.

## Technologies
- Spring Boot
- Spring Data JPA
- PostgreSQL

## Getting Started

### Prerequisites
- Java 11+
- Maven
- PostgreSQL

### Setup

1. Clone the repository:
    ```sh
    git clone <repository-url>
    cd patient-management-service
    ```

2. Configure PostgreSQL:
    - Create a database named `patient_db`.
    - Update the `application.properties` file with your database credentials.

3. Run the application:
    ```sh
    mvn spring-boot:run
    ```

4. Access the API:
    - Base URL: `http://localhost:8080`
    - Endpoints:
        - `POST /patients` - Create a new patient
        - `GET /patients/{id}` - Retrieve patient by ID
        - `PUT /patients/{id}` - Update patient by ID
        - `DELETE /patients/{id}` - Delete patient by ID

## Running Tests
```sh
mvn test
