# Student Admission Management System Backend

This repository contains a Spring Boot application for managing student admissions. The application provides RESTful APIs to perform various operations related to student admissions and course management.

## Features

- Launch new course
- Add student details
- View all students for a specific course
- Update course fees
- Cancel student admission

## Architecture

The application is developed in a layered manner, adhering to best practices for separation of concerns and modularity:

- **REST Controller**: Exposes REST endpoints to interact with the application.
- **Service Layer**: Implements business logic and acts as an intermediary between the controller and DAO layer.
- **DAO (Data Access Object) Layer**: Handles interaction with the database using Spring Data JPA.
- **Entities**: POJOs (Plain Old Java Objects) that represent the database entities.
- **Database**: Used for persistence of course and student data.

## Technologies Used

- **Spring Boot**: For creating the application.
