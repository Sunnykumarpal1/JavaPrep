Spring Core
Spring Core provides the fundamental infrastructure for Dependency Injection (DI) and basic utilities used by the entire Spring framework.
✔ Base module
✔ Foundation for IoC & DI

Spring Beans
Spring Beans module is responsible for bean creation, dependency injection, and complete bean lifecycle management using BeanFactory.
✔ Creates beans
✔ Manages lifecycle
✔ Performs DI
✔ Provides BeanFactory

Spring Context
Spring Context provides the IoC container through ApplicationContext, along with component scanning, event handling, and application-level features.
✔ Provides IoC container
✔ Manages application context
✔ Supports annotations & scanning

Spring Expression Language (SpEL)
Spring Expression Language is used to inject dynamic values and evaluate expressions at runtime.
✔ Dynamic values
✔ Runtime expressions
✔ Property & object access


| Feature                           | BeanFactory | ApplicationContext |
| --------------------------------- | ----------- | ------------------ |
| IoC container                     | ✅ Yes       | ✅ Yes              |
| Dependency Injection              | ✅ Yes       | ✅ Yes              |
| Bean initialization               | Lazy        | Eager (default)    |
| Annotation support (`@Autowired`) | ❌ Limited   | ✅ Full             |
| Component scanning                | ❌ No        | ✅ Yes              |
| Event handling                    | ❌ No        | ✅ Yes              |
| AOP support                       | ❌ Limited   | ✅ Full             |
| Internationalization (i18n)       | ❌ No        | ✅ Yes              |
| Used in Spring Boot               | ❌ No        | ✅ Yes              |


# Difference Between `@Component` and `@Bean` in Spring

Spring provides multiple ways to define beans that are managed by the **IoC (Inversion of Control) container**. Two commonly used approaches are `@Component` and `@Bean`. While both result in a Spring-managed bean, their usage and behavior differ.

---

## 1. Overview

| Feature               | `@Component`                         | `@Bean`                           |
|-----------------------|-------------------------------------|----------------------------------|
| **Usage Location**    | Applied on a **class**               | Applied on a **method**          |
| **Bean Creation**     | Auto-scanned by Spring              | Manually created in a `@Configuration` class |
| **Detection**         | Detected via **component scanning**  | Not auto-scanned; explicitly declared |
| **Control**           | Less control over instantiation      | More control over instantiation  |
| **Common Usage**      | Application-level classes            | Third-party / external classes   |

---

## 2. What is `@Component`?

- Marks a **class** as a Spring-managed bean.
- Automatically detected during **component scanning**.
- Bean is created and stored in the IoC container.

### Example

```java
What is @Bean?

Used on a method inside a @Configuration class.
Method returns an object that Spring registers as a bean.
Provides full control over bean instantiation and initialization.

Example
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public A a() {
        return new A();
    }
}

@Component → Class-level, auto-detected, simple bean creation.
@Bean → Method-level, manual declaration, full control.
Both register objects as beans in the Spring IoC container.
```

## Spring Bean Lifecycle

The lifecycle of a Spring bean consists of several phases managed by the Spring IoC container. Understanding these phases is crucial for effective Spring development.

### Bean Lifecycle Phases

``1. **Container Started**  
   The Spring IoC container is initialized.

2. **Bean Instantiated**  
   The container creates an instance of the bean.

3. **Dependencies Injected**  
   Spring injects dependencies into the bean using constructor injection, setter injection, or field injection.

4. **BeanPostProcessor (Before Initialization)**  
   Any `BeanPostProcessor` implementations are called before the initialization methods (`@PostConstruct` or `afterPropertiesSet()`).

5. **Custom init() Method**  
   If the bean implements `InitializingBean` or has a custom initialization method specified via `@PostConstruct` or `init-method`, it is executed here.

6. **BeanPostProcessor (After Initialization)**  
   `BeanPostProcessor` implementations are called again after the initialization methods.

7``. **Bean is Ready**  
   The bean is now fully initialized and ready for use.

8. **Custom Utility Method**  
   Any custom methods defined in the bean can be called as required by the application.

9. **Custom destroy() Method**  
   If the bean implements `DisposableBean` or has a custom destruction method specified via `@PreDestroy` or `destroy-method`, it is called when the container is shutting down.

## Bean PostProcessor
BeanPostProcessor is a Spring interface that allows custom logic to be executed before and after a bean’s initialization phase.

```
public interface BeanPostProcessor {
    Object postProcessBeforeInitialization(Object bean, String beanName);
    Object postProcessAfterInitialization(Object bean, String beanName);
}
```
# 🌱 Bean Init & Destroy – BIG PICTURE
Phase	Purpose
* Init	Run logic after bean creation & dependency injection
* Destroy	Cleanup before bean removal / context shutdown

⚠️ Destroy methods run only when the Spring context is closed and not for prototype beans.

## 1️⃣ Using @PostConstruct & @PreDestroy (Most Used 🔥)
```Example
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Component;

@Component
public class Car {

    @PostConstruct
    public void init() {
        System.out.println("🚗 Car initialized (@PostConstruct)");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("🔥 Car destroyed (@PreDestroy)");
    }
}
```
✅ Pros

Clean

No Spring interface dependency
Annotation-based (modern Spring)
❌ Cons
One init & destroy method only
📌 Interview Line
@PostConstruct and @PreDestroy are lifecycle annotations invoked after dependency injection and before bean destruction.

## 2️⃣ Using InitializingBean & DisposableBean (Interface-Based)
````
Example
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.stereotype.Component;

@Component
public class Car implements InitializingBean, DisposableBean {

    @Override
    public void afterPropertiesSet() {
        System.out.println("🚗 Car initialized (afterPropertiesSet)");
    }

    @Override
    public void destroy() {
        System.out.println("🔥 Car destroyed (DisposableBean)");
    }
}
````
✅ Pros
Guaranteed execution
Explicit lifecycle hooks

❌ Cons
Tight coupling to Spring
Not recommended for clean architecture

📌 Interview Line
Interface-based lifecycle methods tightly couple the bean to Spring.

## 3️⃣ Using @Bean(initMethod, destroyMethod) (Very Important ⭐)
````
Example
public class Engine {
public void start() {
System.out.println("🔧 Engine started");
}
public void stop() {
System.out.println("🛑 Engine stopped");
}
}

@Configuration
public class AppConfig {

    @Bean(initMethod = "start", destroyMethod = "stop")
    public Engine engine() {
        return new Engine();
    }
}
````
✅ Pros
No annotation in class
Works well for third-party classes

❌ Cons
Method names are strings (no compile-time safety)
📌 Interview Line
initMethod and destroyMethod are commonly used when source code cannot be modified.


# OSI Model – Clear Layer-by-Layer Explanation

This document explains the **OSI (Open Systems Interconnection) Model** in a **pure, concept-based way**.
No examples, no analogies — only **what each layer is**, **what it does**, and **why it exists**.

---

## What is the OSI Model?

The OSI Model is a **7-layer conceptual framework** used to understand how data moves from one computer to another over a network.

Each layer has a **specific responsibility**. Together, they ensure:

* Correct data delivery
* Interoperability between systems
* Easier troubleshooting and design

---

## 7️⃣ Application Layer

### What it is

The topmost layer that provides **network services to applications**.

### What it does

* Allows applications to request network communication
* Defines application-level protocols

### What it does NOT do

* Does not transmit data
* Does not handle encryption or reliability

### Common protocols

* HTTP / HTTPS
* FTP
* SMTP
* DNS

### Key responsibility

**User-facing network services**

---

## 6️⃣ Presentation Layer

### What it is

The **data translation layer** between the application and the network.

### What it does

* Converts data formats (text, images, audio → binary)
* Encrypts and decrypts data
* Compresses and decompresses data

### Why it exists

* Different systems use different data formats
* Ensures data is readable and secure

### Key responsibility

**Data representation and security**

---

## 5️⃣ Session Layer

### What it is

Manages **logical communication sessions** between two systems.

### What it does

* Establishes a session
* Maintains the session
* Terminates the session
* Handles session checkpoints and recovery

### Why it exists

* Prevents treating every request as a new connection

### Key responsibility

**Session management**

---

## 4️⃣ Transport Layer

### What it is

Provides **end-to-end communication** between sender and receiver.

### What it does

* Segments data
* Ensures reliable delivery (if required)
* Error detection and recovery
* Flow control
* Port addressing

### Protocols

* TCP (Reliable, connection-oriented)
* UDP (Fast, connectionless)

### Key responsibility

**Reliability and data integrity**

---

## 3️⃣ Network Layer

### What it is

Handles **logical addressing and routing** across networks.

### What it does

* Assigns IP addresses
* Determines the best path for data
* Routes packets between networks

### Devices

* Routers

### Protocols

* IP
* ICMP
* RIP, OSPF

### Key responsibility

**Routing and path selection**

---

## 2️⃣ Data Link Layer

### What it is

Provides **node-to-node delivery** within the same network.

### What it does

* Frames packets
* Uses MAC addresses
* Performs error detection (CRC)
* Controls access to the physical medium

### Devices

* Switches
* Bridges

### Key responsibility

**Reliable local delivery**

---

## 1️⃣ Physical Layer

### What it is

The lowest layer responsible for **physical transmission of data**.

### What it does

* Transmits raw bits (0s and 1s)
* Defines voltage levels, timing, signaling
* Specifies cables, connectors, and hardware details

### Devices

* Cables
* Hubs
* Network Interface Cards (NICs)

### Key responsibility

**Bit transmission**

---

## Data Units per OSI Layer

| Layer        | Data Unit |
| ------------ | --------- |
| Application  | Data      |
| Presentation | Data      |
| Session      | Data      |
| Transport    | Segment   |
| Network      | Packet    |
| Data Link    | Frame     |
| Physical     | Bits      |

---

## Why the OSI Model is Important

* Helps understand how networks work
* Makes troubleshooting systematic
* Standard interview topic
* Improves protocol and system design understanding

---

**End of README**
