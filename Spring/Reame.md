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


# Spring Bean Lifecycle

The lifecycle of a Spring bean consists of several phases managed by the Spring IoC container. Understanding these phases is crucial for effective Spring development.

## Bean Lifecycle Phases

1. **Container Started**  
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

7. **Bean is Ready**  
   The bean is now fully initialized and ready for use.

8. **Custom Utility Method**  
   Any custom methods defined in the bean can be called as required by the application.

9. **Custom destroy() Method**  
   If the bean implements `DisposableBean` or has a custom destruction method specified via `@PreDestroy` or `destroy-method`, it is called when the container is shutting down.

#Bean PostProcessor
BeanPostProcessor is a Spring interface that allows custom logic to be executed before and after a bean’s initialization phase.

**public interface BeanPostProcessor {
    Object postProcessBeforeInitialization(Object bean, String beanName);
    Object postProcessAfterInitialization(Object bean, String beanName);
}**