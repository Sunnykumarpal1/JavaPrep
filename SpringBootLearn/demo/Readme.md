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


# 📌 Spring Boot Internals & One-to-One Mapping Guide

---

# 🔹 How @Transactional Works Internally in Spring

## ✅ Core Concept

Spring uses **AOP (Aspect-Oriented Programming)** and a **proxy-based mechanism** to implement transaction management.

When a method is annotated with `@Transactional`, Spring does NOT modify the original class directly.

Instead, Spring creates a **proxy object** around the original bean.

All method calls go through this proxy.

---

## 🔄 Internal Working Flow

1. Client calls a method.
2. Call goes to the Proxy.
3. Proxy starts the transaction.
4. Proxy calls the actual method.
5. If execution succeeds → Commit.
6. If RuntimeException/Error occurs → Rollback.

---

## 🧠 Behind the Scenes

Spring internally uses:

- **JDK Dynamic Proxy** → If interface-based
- **CGLIB Proxy** → If no interface

Transaction is managed by:

- `PlatformTransactionManager`

Transaction logic handled by:

- `TransactionInterceptor`

---

## 📊 Simplified Flow Diagram

Client  
   ↓  
Proxy  
   ↓  
Start Transaction  
   ↓  
Call Actual Method  
   ↓  
Commit / Rollback  

---

## ⚠ Important Notes

- Works only for **public methods**
- **Self-invocation does NOT work**
- Default rollback → `RuntimeException` and `Error`
- For checked exceptions:

```java
@Transactional(rollbackFor = Exception.class)
```

---

## 🎯 Interview Summary (Transactional)

- Uses AOP
- Proxy-based mechanism
- Transaction starts before method execution
- Commit/Rollback after execution
- Managed by `PlatformTransactionManager`
- Self-invocation does not trigger transaction

---

# 🔹 One-to-One Mapping in JPA / Hibernate

## ✅ Owning Side Concept

In One-to-One relationship:

> Owning side = Entity that contains the foreign key column.

---

## 🏗 Where to Place the Foreign Key?

Rule:

- Place the foreign key in the **dependent entity**
- Dependent entity = cannot exist without the other

---

## 📌 Example Scenario

- A User can exist without a Profile
- A Profile cannot exist without a User

### Therefore:

- Profile is dependent entity
- Profile should contain foreign key
- Profile is owning side

---

## 🧩 Annotation Placement

### ✅ Owning Side (Profile)

```java
@Entity
public class Profile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String bio;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;
}
```

✔ Contains `@JoinColumn`  
✔ Stores foreign key

---

### 🔁 Inverse Side (User)

```java
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToOne(mappedBy = "user")
    private Profile profile;
}
```

✔ Uses `mappedBy`  
✔ Does NOT contain foreign key

---

## 📊 Database Representation

### USER Table

| id | name |

---

### PROFILE Table

| id | bio | user_id (FK) |

---

## ⚠ What Happens If Foreign Key is Placed in Wrong Table?

- Logical relationship becomes incorrect
- May allow invalid data
- Real-world dependency not reflected properly
- Cascade & orphan removal may not behave correctly
- Nullable columns may be introduced unnecessarily

---

## 🎯 Interview Summary (One-to-One)

- Owning side = entity with foreign key
- Owning side contains `@JoinColumn`
- Inverse side uses `mappedBy`
- Foreign key usually placed in dependent entity
- Think about real-world dependency before designing schema

---

# 🚀 Quick Revision

## 🔥 @Transactional
- AOP-based
- Proxy mechanism
- Uses `PlatformTransactionManager`
- Default rollback → Unchecked exceptions
- Self-invocation does NOT work

## 🔥 One-to-One Mapping
- Identify dependent entity
- Foreign key goes there
- `@JoinColumn` → Owning side
- `mappedBy` → Inverse side