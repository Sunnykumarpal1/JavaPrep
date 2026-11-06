# 📘 Understanding `@SpringBootApplication` in Spring Boot

---

## 1️⃣ What is `@SpringBootApplication`?

`@SpringBootApplication` is a **convenience annotation** in Spring Boot.

👉 It combines multiple important Spring annotations into one, so you don’t have to write them separately.

### In simple words:

This single annotation tells Spring Boot:

> **“Hey, start my application, configure things automatically, and scan my code.”**

---

## 2️⃣ What does `@SpringBootApplication` contain internally?

Internally, it is made up of **three core annotations** 👇

```java
@SpringBootApplication
public class DemoApplication {
    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }
}
```

### Internally equals to 👇

```java
@Configuration
@EnableAutoConfiguration
@ComponentScan
```

Let’s understand each one deeply.

---

## 3️⃣ `@Configuration` – Java-based configuration

* Marks the class as a **configuration class**
* Used to define Spring beans using Java instead of XML

### Example:

```java
@Configuration
public class AppConfig {

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
```

👉 In Spring Boot, your **main application class itself becomes a configuration class**.

---

## 4️⃣ `@EnableAutoConfiguration` – Magic of Spring Boot ✨

This is the **heart of Spring Boot**.

### What it does:

Automatically configures beans based on:

* Dependencies present in `pom.xml`
* Classpath
* Application properties (`application.properties` / `application.yml`)

### Example:

If you add this dependency:

```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-web</artifactId>
</dependency>
```

Spring Boot automatically:

* Configures embedded **Tomcat**
* Configures **DispatcherServlet**
* Enables **Spring MVC**
* Configures **JSON support (Jackson)**

❌ You **do NOT** write:

* XML configuration
* Manual bean setup

👉 Auto-configuration classes are present inside:

```
spring-boot-autoconfigure.jar
```

Spring Boot checks:

> **“Which dependencies are present? Okay, configure only those.”**

---

## 5️⃣ `@ComponentScan` – Finding your beans

`@ComponentScan` tells Spring **where to search for beans**.

It scans for:

* `@Component`
* `@Service`
* `@Repository`
* `@Controller`
* `@RestController`

### Important Rule ⚠️

Spring scans:

* The **package of the main class**
* All its **sub-packages**

### Example package structure:

```
com.sunny.demo
 ├── DemoApplication.java
 ├── controller
 ├── service
 └── repository
```

✅ All classes are detected automatically.

❌ If a class is **outside this package**, it will **NOT** be detected unless explicitly scanned.

---

## 6️⃣ Why are all three needed together?

| Annotation                 | Purpose                          |
| -------------------------- | -------------------------------- |
| `@Configuration`           | Defines beans                    |
| `@EnableAutoConfiguration` | Auto setup based on dependencies |
| `@ComponentScan`           | Finds components                 |

Spring Boot merged all three into:

```java
@SpringBootApplication
```

👉 **Cleaner code + Less boilerplate**
---

## 7️⃣ How does Spring Boot start because of this?
### Application Startup Flow 🚀

1. JVM starts `main()`
2. `SpringApplication.run()` is called
3. Reads `@SpringBootApplication`
4. Loads configuration
5. Auto-configures required beans
6. Scans components
7. Starts embedded server (Tomcat)
8. Application is ready 🎉

---

## 8️⃣ Interview-friendly answer (Short & Crisp)

> **`@SpringBootApplication` is a meta-annotation that combines `@Configuration`, `@EnableAutoConfiguration`, and `@ComponentScan`. It enables auto-configuration, component scanning, and Java-based configuration, allowing Spring Boot applications to start with minimal setup.**

---

## ✅ Summary

* `@SpringBootApplication` simplifies Spring configuration
* Eliminates XML and boilerplate code
* Enables fast application startup
* Core reason why Spring Boot is developer-friendly

---

## Api 
**“API is a set of rules that allow multiple programs to talk to each other.
It allows one app to use the features of another without knowing the internal logic.”**


## RestApi
**“REST is an architectural style used to design web APIs that enable communication over HTTP using standard methods like GET, POST, PUT, and DELETE,
where resources are represented using formats such as JSON.”**

# REST API – Interview Ready Notes

## 1️⃣ Transition Smoothly to REST API

A REST API is a type of API that follows REST architectural principles and uses the HTTP protocol to perform operations on resources.

---

## 2️⃣ REST in One Strong Line (Must-Memorize)

**REST is an architectural style where resources are identified using URLs, and operations are performed using standard HTTP methods like GET, POST, PUT, and DELETE, usually exchanging data in JSON format.**

---

## 3️⃣ Practical REST API Example (Interview Winner)

Consider a **User Management System**:

- `GET /users/1` → Fetch a user
- `POST /users` → Create a new user
- `PUT /users/1` → Update user details
- `DELETE /users/1` → Delete a user

Here:
- `/users` is the **resource**
- HTTP methods define the **action**

---

## 4️⃣ Statelessness (Key Interview Concept)

REST APIs are **stateless**, meaning each request contains all the information required to process it, and the server does not store any client state between requests.

**Benefits:**
- Scalability
- Independent requests
- Better performance

---

## 5️⃣ Request–Response Model

A REST API works on a **request–response model**.

- Client sends an HTTP request with:
    - Method
    - URL
    - Headers
    - Body (optional)
- Server responds with:
    - HTTP status code
    - Data (usually in JSON format)

---

## 6️⃣ REST API in Spring Boot

In Spring Boot, REST APIs are implemented using `@RestController`, where HTTP requests are mapped to controller methods, and responses are automatically converted to JSON using **Jackson**.

---

## 7️⃣ Why REST API? (Very Common Question)

REST APIs are lightweight, platform-independent, easy to scale, and widely supported, making them ideal for modern web and mobile applications.

---

## 8️⃣ Core REST Principles (Advanced but Short)

- Statelessness
- Client–Server Separation
- Uniform Interface
- Resource-Based Architecture

---

## 🧠 30-Second Power Answer (Memorize This)

An API is a contract that allows two applications to communicate.  
A REST API is a type of API that follows REST principles, where resources are accessed using URLs and manipulated using standard HTTP methods like GET, POST, PUT, and DELETE.  
REST APIs are stateless, use the HTTP protocol, and typically exchange data in JSON format.


# Jackson Annotations Example (`@JsonIgnore`, `@JsonManagedReference`, `@JsonBackReference`)

## Scenario

- `User` has sensitive field `password` → use `@JsonIgnore`
- `Parent` ↔ `Child` is bi-directional → use `@JsonManagedReference` and `@JsonBackReference`

---

## Complete Example (Single Code Block)

```java
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;

class User {
    private String username;

    @JsonIgnore
    private String password;

    public User() {} // needed for deserialization

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
}

class Parent {
    private String name;

    @JsonManagedReference
    private List<Child> children;

    public Parent() {}

    public Parent(String name, List<Child> children) {
        this.name = name;
        this.children = children;
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public List<Child> getChildren() { return children; }
    public void setChildren(List<Child> children) { this.children = children; }
}

class Child {
    private String name;

    @JsonBackReference
    private Parent parent;

    public Child() {}

    public Child(String name, Parent parent) {
        this.name = name;
        this.parent = parent;
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public Parent getParent() { return parent; }
    public void setParent(Parent parent) { this.parent = parent; }
}

public class JsonExample {
    public static void main(String[] args) throws Exception {
        ObjectMapper mapper = new ObjectMapper();

        // 1) User example
        User user = new User("Sunny", "mypassword123");
        String userJson = mapper.writeValueAsString(user);
        System.out.println("User JSON: " + userJson);
        // {"username":"Sunny"}  (password hidden)

        // 2) Parent-Child example
        Parent parent = new Parent("Parent1", null);
        Child child1 = new Child("Child1", parent);
        Child child2 = new Child("Child2", parent);
        parent.setChildren(List.of(child1, child2));

        String parentJson = mapper.writeValueAsString(parent);
        System.out.println("Parent JSON: " + parentJson);
        // {"name":"Parent1","children":[{"name":"Child1"},{"name":"Child2"}]}

        // 3) Deserialization
        Parent parent2 = mapper.readValue(parentJson, Parent.class);
        System.out.println("Deserialized child's parent name: " +
                parent2.getChildren().get(0).getParent().getName());
        // Parent1
    }
}


Key Points
@JsonIgnore: hides sensitive fields like password in JSON.
@JsonManagedReference: serializes forward side (Parent -> children).
@JsonBackReference: ignores backward side (Child -> parent) during serialization to avoid infinite recursion, and restores relation during deserialization.


@JsonManagedReference marks the forward side of the relationship and is serialized normally.
@JsonBackReference marks the back side and is ignored during serialization, but Jackson restores the relationship automatically during deserialization