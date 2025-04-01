# Spring Task Manager

A simple REST API for managing tasks, built with Java 17 and Spring Boot 3.

---

## 🧰 Tech Stack

- Java 17
- Spring Boot 3
- Spring Web
- Spring Data JPA
- H2 Database
- Maven

---

## 📚 Features

- Create tasks
- List all tasks
- Get task by ID
- Update tasks
- Delete tasks

---

## 🚀 Running the project

### Requirements:
- Java 17+
- Maven

### Commands:

```bash
git clone https://github.com/your-username/spring-taskmanager.git
cd spring-taskmanager
mvn clean install
mvn spring-boot:run


🔗 Endpoints
Base URL: http://localhost:8080

GET	/tasks	List all tasks
GET	/tasks/{id}	Get task by ID
POST	/tasks	Create new task
PUT	/tasks/{id}	Update task
DELETE	/tasks/{id}	Delete task
Example JSON (POST/PUT):

{
  "title": "Learn Spring Boot",
  "description": "Practice building REST APIs",
  "status": "in progress"
}

💾 H2 Console
URL: http://localhost:8080/h2-console

Database settings:

JDBC URL: jdbc:h2:mem:taskdb
User: sa
Password: (leave empty)


