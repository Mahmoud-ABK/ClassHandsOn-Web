# ClassHandsOn-Web
this repo is for the output of my advanced web class course in my institute 
## handon1 +handon1part2
# Spring Data Hands-on Project 

This project demonstrates the use of Spring Data for Object-Relational Mapping (ORM). It covers different approaches, starting from basic JPA and Hibernate to using Spring Data for simpler data access.

## Project Structure

The project is structured to show a progression of ORM techniques:

*   **DAO with JDBC:** (Not explicitly implemented in the hands-on but mentioned as the base layer) [1-3]
*   **DAO with JPA and Hibernate:** (Also not fully implemented, but a stepping stone) [1-3]
*   **DAO with Spring over JPA and Hibernate:** Implemented using Spring's features to manage JPA and Hibernate [1-3]
*   **DAO with Spring Data:** Demonstrates the simplified data access using Spring Data [1-3]

## Project Setup

### Prerequisites

*   **IntelliJ IDEA:** You've used IntelliJ IDEA instead of Eclipse with the Spring Tools Suite plugin. This works perfectly fine.
*   **MySQL:** You need a MySQL database server installed with an access tool (like WAMP server) I used **Maria db**.
### Main parts 
*   **ORM with Spring, JPA, and Hibernate**: Demonstrates how to set up and use JPA and Hibernate with Spring to interact with a database [1, 2].
*   **ORM with Spring Data**: Shows how to leverage Spring Data to simplify database interactions and reduce boilerplate code [1, 3].
*   **Adding Associations**: Illustrates how to model and manage relationships between entities using JPA annotations [1].

Notes
* This project was developed with IntelliJ IDEA.
* Ensure that your database connection details in `application.properties` are correct.
* The `spring.jpa.hibernate.ddl-auto=create` property in `application.properties` causes the database schema to be created automatically.

## springmvc
# Spring Web MVC Hands-on Project
This project is a hands-on exercise demonstrating the use of Spring Web MVC to build a server-side web application. It was developed using **IntelliJ IDEA** and utilizes a MySQL database.

## Project Overview

This repository contains code examples illustrating the following key concepts of Spring Web MVC:

*   **Model-View-Controller (MVC) Pattern**: Implementation of the MVC pattern using Spring Web MVC to handle web requests, process data, and render views.
*   **Front Controller (DispatcherServlet)**: Demonstrates how the DispatcherServlet intercepts all client HTTP requests and routes them to appropriate controllers.
*   **Dependency Injection**: Utilisation of Spring's dependency injection for managing application components.
*  **Data Access**: Integration of Spring Data JPA for database interaction, specifically for performing CRUD operations.
*   **View Rendering**: Implementation of JSP (JavaServer Pages) for rendering HTML views and displaying data.
*  **Handling HTTP Requests**:  Demonstrates handling HTTP requests, extracting parameters and returning appropriate responses.
*   **Basic Web Application Features:** Implements features such as displaying a list of teams, searching for teams by name, adding new teams, deleting and editing existing teams.
Notes
* This project was developed with IntelliJ IDEA.
* Ensure that your database connection details in application.properties are correct.
* The spring.jpa.hibernate.ddl-auto=create property in application.properties causes the database schema to be created automatically.
* The project uses JSTL (JavaServer Pages Standard Tag Library) for iterating over lists and displaying data on the view.
* The project uses the embedded Tomcat server provided by Spring Boot.
