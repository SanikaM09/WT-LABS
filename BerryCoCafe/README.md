# Berry Co Cafe - Java Full Stack Project

A simple full-stack Java project for a cafe named **Berry Co Cafe**.

## Tech Stack
- Java 17
- Spring Boot (REST API + Thymeleaf)
- HTML/CSS/Vanilla JavaScript frontend

## Features
- View cafe menu items
- Add new menu items
- Delete menu items
- In-memory repository with sample data

## Run Locally
```bash
cd BerryCoCafe
mvn spring-boot:run
```
Then open: `http://localhost:8080`

## API Endpoints
- `GET /api/menu` - list all items
- `POST /api/menu` - add item
- `DELETE /api/menu/{id}` - delete item
