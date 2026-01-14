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