# StudyBuddy - Academic Help & Resource Sharing Platform

![Java](https://img.shields.io/badge/Java-17-orange)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.x-brightgreen)
![MySQL](https://img.shields.io/badge/MySQL-8.0-blue)
![React](https://img.shields.io/badge/React-18-61dafb)
![Vite](https://img.shields.io/badge/Vite-5-646cff)
![TailwindCSS](https://img.shields.io/badge/TailwindCSS-3-38bdf8)

---

# Overview

StudyBuddy is a full-stack academic collaboration platform designed to help students connect with peers, share learning resources, participate in study groups, and improve their academic performance through collaborative learning.

The platform aims to bridge the gap between students by providing a centralized environment for:

- Study Group Management
- Resource Sharing
- Academic Discussions
- Peer Learning
- Progress Tracking
- Community Engagement

---

# Problem Statement

Students often struggle to:

- Find reliable study partners
- Access quality study materials
- Collaborate effectively on academic topics
- Track their learning progress
- Build productive academic communities

StudyBuddy addresses these challenges by providing a unified platform for academic collaboration.

---

# Key Features

## User Management
- User Registration
- Secure Login
- Profile Management
- Role-Based Access Control

## Study Groups
- Create Study Groups
- Join Existing Groups
- Manage Group Members
- Group Discussions

## Resource Sharing
- Upload Notes
- Share PDFs
- Download Resources
- Resource Categorization

## Discussions
- Academic Q&A
- Discussion Threads
- Community Support

## Dashboard
- Activity Tracking
- User Statistics
- Learning Progress

---

# System Architecture

```text
Frontend (React + Vite)
          │
          ▼
REST APIs
          │
          ▼
Spring Boot Backend
          │
          ▼
Service Layer
          │
          ▼
JPA / Hibernate
          │
          ▼
MySQL Database
```

---

# Frontend Stack

| Technology | Purpose |
|------------|----------|
| React 18 | UI Development |
| Vite | Build Tool |
| Tailwind CSS | Styling |
| React Router | Routing |
| Axios | API Calls |
| Context API | State Management |

---

# Backend Stack

| Technology | Purpose |
|------------|----------|
| Java 17 | Programming Language |
| Spring Boot | Backend Framework |
| Spring Security | Authentication & Authorization |
| Spring Data JPA | Database Access |
| Hibernate | ORM |
| MySQL | Database |
| Maven | Dependency Management |

---

# Security Features

- JWT Authentication
- BCrypt Password Encryption
- Role-Based Authorization
- Protected APIs
- Secure Session Management
- Input Validation
- Exception Handling

---

# Project Structure

```text
StudyBuddy/
│
├── frontend/
│   ├── src/
│   │   ├── components/
│   │   ├── pages/
│   │   ├── services/
│   │   ├── hooks/
│   │   └── utils/
│
├── backend/
│   ├── controller/
│   ├── service/
│   ├── repository/
│   ├── model/
│   ├── dto/
│   ├── security/
│   └── config/
│
└── README.md
```

---

# Application Flow

1. User registers an account
2. User logs in securely
3. User creates or joins study groups
4. User shares academic resources
5. Students collaborate through discussions
6. Resources and activities are tracked
7. Progress is monitored through dashboard analytics

---

# Database Design

## Core Tables

### Users
- id
- name
- email
- password
- role

### StudyGroups
- id
- group_name
- description
- created_by

### Resources
- id
- title
- file_url
- uploaded_by

### Discussions
- id
- title
- content
- created_by

### GroupMembers
- id
- user_id
- group_id

---

# API Documentation

## Authentication APIs

| Method | Endpoint | Description |
|----------|------------|--------------|
| POST | /api/auth/register | Register User |
| POST | /api/auth/login | Login User |
| GET | /api/auth/me | Current User |
| POST | /api/auth/logout | Logout |

---

## User APIs

| Method | Endpoint | Description |
|----------|------------|--------------|
| GET | /api/users | Get Users |
| GET | /api/users/{id} | Get User |
| PUT | /api/users/{id} | Update User |
| DELETE | /api/users/{id} | Delete User |

---

## Study Group APIs

| Method | Endpoint | Description |
|----------|------------|--------------|
| POST | /api/groups | Create Group |
| GET | /api/groups | Get Groups |
| GET | /api/groups/{id} | Get Group |
| POST | /api/groups/{id}/join | Join Group |
| DELETE | /api/groups/{id} | Delete Group |

---

## Resource APIs

| Method | Endpoint | Description |
|----------|------------|--------------|
| POST | /api/resources | Upload Resource |
| GET | /api/resources | Get Resources |
| GET | /api/resources/{id} | Get Resource |
| DELETE | /api/resources/{id} | Delete Resource |

---

## Discussion APIs

| Method | Endpoint | Description |
|----------|------------|--------------|
| POST | /api/discussions | Create Discussion |
| GET | /api/discussions | Get Discussions |
| POST | /api/discussions/{id}/reply | Reply Discussion |

---

# ⚡ Installation

## Backend

```bash
git clone https://github.com/samreen-sk/studyBuddy.git

cd backend

mvn clean install

mvn spring-boot:run
```

## Frontend

```bash
cd frontend

npm install

npm run dev
```

---

# Environment Variables

```env
SPRING_DATASOURCE_URL=
SPRING_DATASOURCE_USERNAME=
SPRING_DATASOURCE_PASSWORD=

JWT_SECRET=
JWT_EXPIRATION_MS=

FRONTEND_URL=
```

---

# Future Enhancements

## Phase 1
- User Authentication
- Study Groups
- Resource Sharing
- Discussions

## Phase 2
- Real-Time Chat
- Notifications
- Friend Requests
- Search Functionality

## Phase 3
- AI Study Assistant
- AI Quiz Generator
- AI Notes Summarizer
- AI Interview Preparation

## Phase 4
- Video Calling
- Live Collaboration Rooms
- Whiteboard Support
- Screen Sharing

## Phase 5
- Mobile Application
- Push Notifications
- Offline Access

## Phase 6
- Microservices Architecture
- Docker Deployment
- Kubernetes
- Redis Caching
- AWS Deployment
- CI/CD Pipeline

---

# Learning Outcomes

This project demonstrates:

- Full Stack Development
- REST API Design
- Database Design
- Authentication & Security
- Software Architecture
- Frontend Development
- Backend Development
- Scalable System Design

---
