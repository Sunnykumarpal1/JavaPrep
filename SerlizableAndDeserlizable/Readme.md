# Serialization & Deserialization (Java | Spring Boot)

## 1️⃣ What is Serialization & Deserialization

### 👉 Simple Definition

* **Serialization** → Converting an **Object ➜ byte stream / JSON**
* **Deserialization** → Converting **byte stream / JSON ➜ Object**

In simple words:

> Serialization is used when data needs to be **sent or stored**, and deserialization is used when data needs to be **read back and used**.

---

## 2️⃣ Real‑Life Backend Example (REST API)

### Java Class

```java
class User {
    int id;
    String name;
}
```

### API Response Sent to Client

```json
{
  "id": 1,
  "name": "Sunny"
}
```

### 👉 What Happened Internally?

1. Java **User object** is created in backend
2. **Jackson** automatically **serializes** it into JSON
3. JSON is sent over **HTTP response**

---

### Incoming Request Example

```json
{
  "id": 2,
  "name": "Amit"
}
```

### 👉 Internally:

1. JSON comes from client
2. Jackson **deserializes** JSON
3. JSON ➜ Java **User object**

📌 **Important:**
You never write serialization logic manually — **Spring Boot + Jackson handle it automatically**.

---

## 3️⃣ Serializable Interface (Marker Interface)

### 👉 What is a Marker Interface?

* Interface with **NO methods**
* Used to **mark** a class
* JVM checks this marker during runtime

---

### Example

```java
import java.io.Serializable;

class User implements Serializable {
    int id;
    String name;
}
```

---

### 🔹 Why Serializable is Needed?

When you want to:

* Save object to a **file**
* Send object to **another JVM**
* Store object in **cache (Redis)**

📌 If a class does **NOT** implement `Serializable`:

```text
NotSerializableException
```

📌 JVM check:

> “Is this class marked as Serializable?”

---

## 4️⃣ transient Keyword (VERY IMPORTANT)

### 👉 What does `transient` do?

* Prevents a field from being **serialized**
* Field will be **ignored during serialization**

---

### Example (Password Case)

```java
class User implements Serializable {
    int id;
    String username;
    transient String password;
}
```

### Serialized Output

```json
{
  "id": 1,
  "username": "sunny"
}
```

❌ `password` is **NOT included**

---

### 🔹 Use Cases of `transient`

* Passwords
* OTPs
* Security tokens
* Sensitive internal data

---

## 5️⃣ Where is Serialization Used? (Real‑World Examples)

### 🔹 1. REST APIs (Most Common)

**Flow:**

```text
Java Object ➜ JSON ➜ HTTP ➜ Client
```

### Example

```java
@GetMapping("/user")
public User getUser() {
    return new User(1, "Sunny");
}
```

👉 Spring Boot automatically:

* Serializes `User` ➜ JSON
* Sends response to client

---

### 🔹 2. Caching (Redis Example)

```java
User user = userService.getUserById(1);
redisTemplate.opsForValue().set("user:1", user);
```

👉 Internally:

* User object ➜ **serialized**
* Stored in Redis
* Retrieved later ➜ **deserialized**

---

### 🔹 3. Messaging (Kafka / RabbitMQ)

```java
User user = new User(1, "Sunny");
```

👉 Flow:

* Producer ➜ serializes object
* Message sent to queue/topic
* Consumer ➜ deserializes message

📌 Used in:

* Event‑driven systems
* Microservices communication

---

## 6️⃣ One COMPLETE Interview Answer (Memorize This)

> Serialization is the process of converting a Java object into a byte stream or JSON so it can be stored or transmitted, while deserialization converts it back into an object. In Java, this is enabled using the Serializable marker interface. The transient keyword is used to prevent sensitive fields like passwords from being serialized. Serialization is commonly used in REST APIs, caching systems like Redis, and messaging systems like Kafka.

---

## ✅ Interview Tip

* Keep explanation **simple + structured**
* Give **1 REST example** and **1 real system use‑case**
* Mention **Serializable + transient** confidently

🔥 This explanation is **8–10 LPA interview ready**
