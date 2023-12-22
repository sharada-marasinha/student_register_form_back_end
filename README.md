# Student Register Form Back End

This Spring Boot application serves as the back end for a student registration form system. It handles the storage and retrieval of student information in a database.

## Technologies Used

- **Spring Boot:** A Java-based framework for building stand-alone, production-grade Spring-based Applications.
- **Spring Data JPA:** Provides support for the Java Persistence API (JPA) and helps simplify data access layer development.
- **MySQL (or your preferred database):** The application is configured to interact with a MySQL database for storing student information.

## Features

- **Student Registration:** Accepts and stores student details, including name, email, and other relevant information.
- **Data Validation:** Implements validation checks to ensure the correctness of student data.
- **RESTful API:** Exposes RESTful endpoints for creating, retrieving, updating, and deleting student records.

## Getting Started

To run this application locally, follow these steps:

## Swagger Url

   ```bash
   http://localhost:8080/swagger-ui/index.html#
   ```

1. Clone the repository:

    ```bash
    https://github.com/sharada-marasinha/Student_Register_Form_Back_End.git
    ```

2. Configure the database:

    - Update the `application.properties` file with your MySQL database configuration.

3. Run the application:

    ```bash
    ./mvnw spring-boot:run
    ```

4. Access the API:

    The API will be available at `http://localhost:8080/api/students`. You can use tools like Postman or cURL to interact with the API.

## API Endpoints

- `GET /api/students`: Retrieve all students.
- `GET /api/students/{id}`: Retrieve a specific student by ID.
- `POST /api/students`: Create a new student.
- `PUT /api/students/{id}`: Update an existing student by ID.
- `DELETE /api/students/{id}`: Delete a student by ID.

## Contributing

If you'd like to contribute to the project, please follow the [contribution guidelines](CONTRIBUTING.md).

## License

This project is licensed under the [MIT License](LICENSE.md).
