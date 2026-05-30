# Global Booking System Backend

A production-ready backend system for managing global online class offerings, sessions, and bookings with timezone support, conflict detection, and concurrency handling.

--------------------------------------------------------------------------------------------------------------------------------------------------------------------------

# Project Overview

This project is built for a global live-learning platform where teachers conduct online classes for students/parents across different countries and timezones.

The system allows:

- Teachers to create courses
- Teachers to create offerings/batches
- Teachers to add sessions
- Parents to view offerings
- Parents to book complete offerings
- Automatic booking conflict detection
- Timezone-aware session handling
- Concurrent booking protection

--------------------------------------------------------------------------------------------------------------------------------------------------------------------------

# Features

## Teacher Features

- Create Teacher
- Create Course
- Create Offering
- Add Sessions
- View Teacher Offerings

------------------------------------------------------------------------------------------------------------------------------------------

## Parent Features

- Create Parent
- View Available Offerings
- Book Offerings
- View Bookings

---

## System Features

- Timezone conversion support
- Booking conflict detection
- Concurrent booking handling
- Global exception handling
- Proper layered architecture
- DTO-based API responses

---

# Tech Stack Used

| Technology                  |           Purpose              |
|-----------------------------|--------------------------------|
| Java 21                     | Programming Language           |
| Spring Boot                 | Backend Framework              |
| Spring Data JPA             | ORM                            |
| MySQL                       | Database                       |
| Hibernate                   | Persistence                    |
| Lombok                      | Boilerplate reduction          |
| Maven                       | Dependency management          |
| Postman                     | API testing                    |



# Project Structure

```text
src/main/java/com/shirish/globalbookingsystem
│
├── config
├── constants
├── controller
├── dto
├── entity
├── enums
├── exception
├── handler
├── mapper
├── repository
├── security
├── service
├── util
└── GlobalBookingSystemApplication


```

---

# Database Schema Overview

## Tables

### teachers
Stores teacher details.

### parents
Stores parent/student details.

### courses
Stores course information.

### offerings
Stores course batches/sections.

### sessions
Stores actual session timings.

### bookings
Stores offering bookings.

-----------------------------------------------------------------------------------------------------------------------------------------

# Database Relationships

- One Teacher → Many Offerings
- One Course → Many Offerings
- One Offering → Many Sessions
- One Parent → Many Bookings
- One Offering → Many Bookings

---

# Database Schema Diagram

Add your ER diagram screenshot here.

## ER Diagram

![Database Schema](<img width="1366" height="768" alt="Screenshot (166)" src="https://github.com/user-attachments/assets/e676cfd5-26c0-4552-ab49-500753413a7b" />
)
<img width="1366" height="768" alt="Screenshot (133)" src="https://github.com/user-attachments/assets/8b40e271-6aac-4111-9848-a7204bbeec83" />
<img width="1366" height="768" alt="Parent Not Found" src="https://github.com/user-attachments/assets/37f6426f-c4f6-41f8-bc66-5c008600678e" />

---

# Setup Instructions

## 1. Clone Repository

```bash
git clone https://github.com/YOUR_USERNAME/global-booking-system.git
```

---

## 2. Open Project

Open in IntelliJ IDEA.

---

## 3. Create MySQL Database

```sql
CREATE DATABASE global_booking_system;
```

---

## 4. Configure application.properties

Location:

```text
src/main/resources/application.properties
```

Add:

```properties
spring.application.name=global-booking-system

# DATABASE
spring.datasource.url=jdbc:mysql://localhost:3306/global_booking_system
spring.datasource.username=root
spring.datasource.password=YOUR_PASSWORD

# JPA
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.open-in-view=false

# TIMEZONE
spring.jpa.properties.hibernate.jdbc.time_zone=UTC

# SERVER
server.port=8080

# LOGGING
logging.level.org.hibernate.SQL=DEBUG
```

---

# Environment Variables Required

| Variable | Example |
|---|---|
| spring.datasource.username | root |
| spring.datasource.password | yourpassword |
| spring.datasource.url | jdbc:mysql://localhost:3306/global_booking_system |

---

# Steps To Run Application Locally

## Step 1

Start MySQL server.

---

## Step 2

Create database:

```sql
CREATE DATABASE global_booking_system;
```

---

## Step 3

Run Spring Boot application.

Run:

```bash
mvn spring-boot:run
```

OR run directly from IntelliJ.

---

## Step 4

Application starts on:

```text
http://localhost:8080
```

---

# Timezone Handling Approach

Teachers create sessions in their local timezone.

All session times are stored internally in UTC.

Parents view sessions in their own timezone.

This ensures:

- Correct global scheduling
- Consistent storage
- Accurate timezone conversion

Used:

- ZonedDateTime
- ZoneId
- UTC normalization

---

# Concurrency Handling Approach

Concurrency handling is implemented during booking.

The booking API uses:

```java
@Transactional
```

and pessimistic locking to avoid:

- Duplicate bookings
- Overlapping concurrent bookings
- Race conditions

The system ensures:

- Data consistency
- Safe simultaneous booking requests
- Conflict prevention

---

# Booking Conflict Logic

When a parent books an offering:

- All sessions of that offering are checked
- Existing booked sessions are compared
- Overlapping time slots are rejected

Example:

Already booked:

- Saturday 5 PM – 6 PM

Trying to book:

- Saturday 5:30 PM – 6:30 PM

Result:

```text
Booking conflict detected
```

---

# Assumptions Made

- One booking = entire offering
- Sessions belong to only one offering
- Teachers and parents have unique emails
- All session times are stored in UTC
- No authentication required for assignment
- MySQL used as database

---

# API Documentation

---

# Base URL

```text
http://localhost:8080
```

---

# 1. Create Teacher

## Endpoint

```http
POST /api/teachers
```

## Request Body

```json
{
  "name": "John Teacher",
  "email": "john@example.com",
  "timezone": "Asia/Kolkata"
}
```

## Response

```json
{
  "id": 1,
  "name": "John Teacher"
}
```

## Screenshot

![Create Teacher](screenshots/create-teacher.png)

---

# 2. Create Course

## Endpoint

```http
POST /api/teachers/courses
```

## Request Body

```json
{
  "title": "Minecraft Coding",
  "description": "Coding course"
}
```

## Screenshot

![Create Course](screenshots/create-course.png)

---

# 3. Create Offering

## Endpoint

```http
POST /api/teachers/offerings
```

## Request Body

```json
{
  "batchName": "Saturday Batch",
  "teacherId": 1,
  "courseId": 1
}
```

## Screenshot

![Create Offering](screenshots/create-offering.png)

---

# 4. Add Session

## Endpoint

```http
POST /api/teachers/sessions
```

## Request Body

```json
{
  "offeringId": 1,
  "startTime": "2026-06-06T12:30:00Z",
  "endTime": "2026-06-06T13:30:00Z"
}
```

## Screenshot

![Create Session](screenshots/create-session.png)

---

# 5. Create Parent

## Endpoint

```http
POST /api/parents
```

## Request Body

```json
{
  "name": "Shree Parent",
  "email": "shree@example.com",
  "timezone": "America/New_York"
}
```

## Screenshot

![Create Parent](screenshots/create-parent.png)

---

# 6. View Offerings

## Endpoint

```http
GET /api/parents/offerings
```

## Screenshot

![View Offering](screenshots/view-offering.png)

---

# 7. Book Offering

## Endpoint

```http
POST /api/bookings
```

## Request Body

```json
{
  "parentId": 1,
  "offeringId": 1
}
```

## Screenshot

![Book Offering](screenshots/book-offering.png)

---

# Booking Conflict Testing

Attempt overlapping booking.

Expected Response:

```json
{
  "error": "Booking conflict detected for session timing"
}
```

## Screenshot

![Booking Conflict](screenshots/booking-conflict.png)

---

# Concurrent Booking Testing

Open two Postman tabs.

Send booking requests simultaneously.

System prevents invalid overlapping bookings.

---

# Error Handling

Implemented using:

```java
@RestControllerAdvice
```

Handles:

- Resource not found
- Booking conflicts
- Concurrent booking issues
- Validation errors
- Duplicate email errors

---

# Sample Error Response

```json
{
  "timestamp": 1780132093,
  "status": 400,
  "error": "Booking conflict detected for session timing"
}
```

---

# Postman Collection

Exported Postman collection is included in repository.

File:

```text
Global-Booking-System.postman_collection.json
```

---

# API Documentation Format

Provided as:

- Postman Collection
- README API Documentation

---

# Future Improvements

- JWT Authentication
- Swagger/OpenAPI
- Docker Support
- Redis Caching
- Pagination
- Role-based access control
- Unit testing
- Integration testing

---

# Author

Shirish Kanoje

Backend Engineering Assignment Submission

```
