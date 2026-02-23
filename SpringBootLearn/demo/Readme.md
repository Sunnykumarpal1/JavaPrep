# API and REST API – Overview

## 📌 What is an API?

An **API (Application Programming Interface)** is a contract that defines how two software systems communicate with each other.

It specifies:
- The request format
- The response format
- The available operations
- While hiding internal implementation details

For example, in a REST API, we expose endpoints like:

```
GET /users
```

The client does not need to know how the data is stored internally.

---

## 📌 API in Spring Boot

In Spring Boot, we usually build **RESTful APIs** that allow frontend or external systems to communicate with backend services over HTTP.

We define endpoints using:
- `@RestController`
- `@GetMapping`
- `@PostMapping`
- `@PutMapping`
- `@DeleteMapping`

### Example:

```java
@RestController
@RequestMapping("/users")
public class UserController {

    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }
}
```

### Key REST Principles:
- Stateless communication
- Proper use of HTTP methods
- Resource-based URLs
- Returns JSON responses
- Proper HTTP status codes

We also implement:
- Input validation
- Global exception handling
- Security using Spring Security with JWT

---

## 📌 1️⃣ What is an API?

API is a general concept.
It is any interface that allows two systems to communicate.

### Examples:
- Java Collections API
- OS File System API
- Web API
- Payment Gateway API

So, API is a broad term.

---

## 📌 2️⃣ What is a REST API?

A **REST API** is a type of Web API that follows the architectural style called **REST (Representational State Transfer)**.

### REST Principles:
- Uses HTTP methods (GET, POST, PUT, DELETE)
- Stateless communication
- Resource-based URLs
- Usually returns JSON

### Example Endpoints:
```
GET /users
POST /orders
DELETE /product/10
```

---

## 📌 HTTP Status Codes

HTTP status codes are 3-digit numbers returned by a server to tell the client the result of the request.

| Scenario                | Status Code |
|--------------------------|------------|
| Fetch data successfully | 200 OK     |
| Create new entity       | 201 Created|
| Delete successfully     | 204 No Content |
| Invalid input           | 400 Bad Request |
| Not logged in           | 401 Unauthorized |
| No permission           | 403 Forbidden |
| Resource not found      | 404 Not Found |
| Server error            | 500 Internal Server Error |

---

## ✅ Commonly Used Status Codes

- **200 OK**
- **201 Created**
- **204 No Content**
- **400 Bad Request**
- **401 Unauthorized**
- **403 Forbidden**
- **404 Not Found**
- **500 Internal Server Error**

---

## 🎯 Summary

- API is a general interface for communication between systems.
- REST API is a type of Web API that follows REST principles.
- In Spring Boot, we use annotations like `@RestController` and mapping annotations to build RESTful APIs.
- Proper HTTP methods and status codes are essential for building robust APIs.




# 📌 What is ResponseEntity in Spring?

## ✅ 1️⃣ What is ResponseEntity?

`ResponseEntity` is a class in the **Spring Framework**.
It represents the **entire HTTP response** returned from a REST API.
Using `ResponseEntity`, we can fully control:

- ✅ HTTP Status Code
- ✅ Response Body
- ✅ Response Headers

---

## 🎯 Why Do We Use ResponseEntity?

By default, Spring returns only the response body.

But in real-world applications, we often need to:

- Return different HTTP status codes (200, 201, 400, 404, 500, etc.)
- Add custom headers
- Control the complete response structure

`ResponseEntity` helps us achieve this.

---

## 🧠 Basic Syntax

```java
return new ResponseEntity<>(body, HttpStatus.OK);

@GetMapping("/builder")
public ResponseEntity<String> responseBuilder() {
    return ResponseEntity
            .status(HttpStatus.CREATED)          // set status
            .header("Custom-Header", "Sunny")   // add header
            .body("User created successfully"); // set body
}
import org.springframework.http.HttpHeaders;

@GetMapping("/with-headers")
public ResponseEntity<String> responseWithHeaders() {
    HttpHeaders headers = new HttpHeaders();
    headers.add("Custom-Header", "Sunny");
    return new ResponseEntity<>("Hello World", headers, HttpStatus.OK);
}

