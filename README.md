# StudyBuddy – Academic Collaboration Platform

![Java](https://img.shields.io/badge/Java-17-orange)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.x-brightgreen)
![PostgreSQL](https://img.shields.io/badge/PostgreSQL-16-blue)
![React](https://img.shields.io/badge/React-18-61dafb)
![Vite](https://img.shields.io/badge/Vite-5-646cff)

---

# Overview

StudyBuddy is a full-stack academic collaboration platform built to help students manage and share academic notes/resources in a centralized environment.

The project demonstrates full stack development using React.js, Spring Boot, PostgreSQL, REST APIs, JWT authentication, and layered backend architecture.

Currently implemented features include:

* User Registration
* User Login
* JWT Authentication
* BCrypt Password Encryption
* Notes CRUD Operations
* REST API Integration
* PostgreSQL Database Integration

---

# Tech Stack

## Frontend

* React.js
* React Router DOM
* CSS

## Backend

* Java 17
* Spring Boot
* Spring Security
* JWT Authentication
* Spring Data JPA
* Hibernate
* PostgreSQL
* Lombok
* Maven

---

# Project Structure

```text
studyBuddy/
│
├── backend/
│   ├── controller/
│   ├── service/
│   ├── repository/
│   ├── entity/
│   ├── dto/
│   ├── security/
│   └── config/
│
├── frontend/
│   └── src/
│       ├── pages/
│       ├── services/
│       └── components/
│
└── README.md
```

---

# Implemented Features

## Authentication Module

* User Registration
* User Login
* JWT Token Generation
* BCrypt Password Encryption

## Notes Module

* Create Notes
* Fetch All Notes
* Delete Notes

## Backend Architecture

* Layered Architecture
* REST APIs
* JPA/Hibernate Integration
* PostgreSQL Database Connectivity

---

# Backend Architecture

```text
Frontend (React)
        ↓
REST APIs
        ↓
Spring Boot Backend
        ↓
Service Layer
        ↓
Repository Layer
        ↓
PostgreSQL Database
```

---

# API Endpoints

## Authentication APIs

| Method | Endpoint       | Description   |
| ------ | -------------- | ------------- |
| POST   | /auth/register | Register User |
| POST   | /auth/login    | Login User    |

---

## Notes APIs

| Method | Endpoint    | Description   |
| ------ | ----------- | ------------- |
| POST   | /notes      | Create Note   |
| GET    | /notes      | Get All Notes |
| DELETE | /notes/{id} | Delete Note   |

---

# Security Features

* JWT Authentication
* BCrypt Password Encryption
* Protected Authentication Flow
* Secure Password Storage

---

# Database Tables

## Users

* id
* name
* email
* password

## Notes

* id
* title
* content

---

# Installation

## Clone Repository

```bash
git clone https://github.com/samreen-sk/studyBuddy.git
```

---

# Backend Setup

```bash
cd backend

mvn clean install

mvn spring-boot:run
```

Backend runs on:

```text
http://localhost:8080
```

---

# Frontend Setup

```bash
cd frontend

npm install

npm start
```

Frontend runs on:

```text
http://localhost:3000
```

---

# PostgreSQL Configuration

Update `application.properties`:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/studybuddy
spring.datasource.username=postgres
spring.datasource.password=yourpassword

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

---

# Learning Outcomes

This project demonstrates:

* Full Stack Development
* REST API Development
* React Frontend Integration
* Authentication & Security
* JPA/Hibernate
* Database Integration
* Layered Backend Architecture
* CRUD Operations

---

# Future Enhancements

Planned future features:

* Study Group Management
* Resource Sharing
* Academic Discussions
* File Upload Support
* Real-Time Chat
* Docker Deployment
* Cloud Deployment
* Mobile Application
* Microservices Architecture

---
