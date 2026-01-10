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

