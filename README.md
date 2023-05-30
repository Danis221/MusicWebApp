# MusicWebApp

MusicWebApp is a web application developed using Java 11 and various technologies to provide a platform for music lovers. It allows users to explore, search for and listen to music tracks, and create articles and events about music.

## Technology Stack

- Java 11
- Java Servlets
- Apache Tomcat server
- FreeMarker templating engine
- PostgreSQL database
- HTML
- CSS (with Bootstrap)
- JavaScript (with jQuery)

## Concepts, Models, Patterns

- MVC (Model-View-Controller) architecture: The application follows the MVC pattern, separating the concerns of data models, user interface views, and the application logic.
- ORM (Object-Relational Mapping): The application uses ORM techniques for database processing, enabling seamless conversion between object-oriented models and relational database tables.
- DAO (Data Access Object) pattern: The application implements a DAO service layer to encapsulate the interaction with the underlying database via JDBC (Java Database Connectivity).

## Features

The MusicWebApp incorporates the following features:

- User authentication and authorization: Sessions are used to manage user authentication, allowing access to authorized features and content.
- Remember me functionality: Cookies are utilized to remember user preferences and login status for convenient access.
- Ajax requests: Asynchronous JavaScript and XML (Ajax) requests are employed to enhance the user experience by enabling dynamic content loading without page refresh.
- Data validation: Both client-side and server-side data validation mechanisms are implemented to ensure the integrity and security of user inputs.
- Password hashing: Passwords are securely hashed using industry-standard algorithms to protect user data.

## Project Structure

The project structure follows a standard Maven directory layout:

- - MusicWebApp
    - src/main
        - java/ru/itis
            - dao
            - dto
            - filter
            - handler
            - models
            - service
            - servlet
            - util
        - resources
        - webapp
            - WEB-INF
                - web.xml
            - css
            - img
            - js

    - .gitignore
    - pom.xml

- DAO layer for database operations
- DTO layer for data transfer between layers
- Filter layer for logging and security
- Handler layer for exception handling
- Models layer for defining entities
- Service layer for business logic
- Servlet layer for handling HTTP requests
- Util layer for utility classes and methods


## Usage

To use the MusicWebApp project, follow these steps:

1. Set up a Java development environment with Java 11 or a compatible version.
2. Configure an Apache Tomcat server and deploy the web application.
3. Create a PostgreSQL database and update the database configuration in the application.
4. Build and run the project using Maven or your preferred IDE.
5. Access the web application through a web browser and explore its features.

Feel free to customize and modify the project code to suit your specific requirements.
