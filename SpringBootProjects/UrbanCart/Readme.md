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