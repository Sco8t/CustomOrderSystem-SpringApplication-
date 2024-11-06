# Project Title

*****NOTE: Its a custom made project, not a tutorial based online project )*****

This project is a Spring Boot application that follows the MVC architecture and connects to an SQL database. It includes various functionalities such as managing drivers, orders, and staff, along with user authentication and role-based access.

## Table of Contents

- [Project Title](#project-title)
- [Table of Contents](#table-of-contents)
- [Project Structure](#project-structure)
- [Setup and Installation](#setup-and-installation)
- Usage
- Features
- [Technologies Used](#technologies-used)
- Contributing
- License

## Project Structure

```
├── .gitignore
├── .mvn/
│   ├── wrapper/
│   │   ├── maven-wrapper.jar
│   │   └── maven-wrapper.properties
├── mvnw
├── mvnw.cmd
├── pom.xml
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── comp31/
│   │   │       ├── a2/
│   │   │       │   ├── controllers/
│   │   │       │   │   └── MainController.java
│   │   │       │   ├── model/
│   │   │       │   │   ├── entities/
│   │   │       │   │   └── repositories/
│   │   │       │   └── services/
│   │   ├── resources/
│   │   │   ├── application.properties
│   │   │   ├── data.sql.txt
│   │   │   ├── schema.sql.txt
│   │   │   ├── static/
│   │   │   └── templates/
│   └── test/
│       ├── java/
│       │   └── comp31/
│       │       └── a2/
│       │           └── A2ApplicationTests.java
└── target/
```

## Setup and Installation

1. **Clone the repository:**
   ```sh
   git clone <repository-url>
   cd <repository-directory>
   ```

2. **Build the project:**
   ```sh
   ./mvnw clean install
   ```

3. **Run the application:**
   ```sh
   ./mvnw spring-boot:run
   ```

## Usage

1. **Access the application:**
   Open your web browser and navigate to `http://localhost:8080`.

2. **Login:**
   Use the provided credentials to log in as an admin or driver.

3. **Manage Orders and Drivers:**
   Use the navigation bar to access different functionalities such as adding orders, assigning orders, deleting orders, and resetting passwords.

## Features

- **MVC Architecture:**
  The project follows the Model-View-Controller architecture to separate concerns and improve maintainability.

- **SQL Database Integration:**
  The application connects to an SQL database to manage data persistence.

- **User Authentication:**
  Users can log in as admins or drivers with role-based access control.

- **Order Management:**
  Admins can add, assign, and delete orders.

- **Driver Management:**
  Admins can manage driver information and reset passwords.

## Technologies Used

- **Spring Boot:** Framework for building Java-based web applications.
- **Thymeleaf:** Template engine for rendering HTML views.
- **Spring Data JPA:** Abstraction over JPA to interact with the database.
- **H2 Database:** In-memory database for development and testing.
- **Lombok:** Library to reduce boilerplate code.

## Contributing

Contributions are welcome! Please fork the repository and create a pull request with your changes.

## License

This project is licensed under the MIT License. See the LICENSE file for details.
