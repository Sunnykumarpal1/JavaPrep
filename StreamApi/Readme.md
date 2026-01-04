Reference:- https://www.geeksforgeeks.org/java/java-8-stream-tutorial/
1️⃣ What is Stream API?

Introduced in Java 8, the Streams API is used to process collections of data in a functional style.
A stream does not store data; it processes data from a source such as a Collection, Array, or I/O channel.
Streams allow operations like filter, map, reduce, collect, etc., in a declarative way.

Key Features

No storage: Stream is not a data structure.
Functional in nature: Operations are expressed as functions.
Lazy evaluation: Operations execute only when a terminal operation is invoked.
Parallel execution: Supports multi-core processing using parallelStream().
Pipelining: Multiple operations can be chained together.

2️⃣ Stream Operations

Streams support two types of operations.

A. Intermediate Operations
Return a new Stream.
Are lazy (do not execute immediately).

Examples

filter(Predicate) → Filters elements
map(Function) → Transforms elements
sorted() → Sorts elements
distinct() → Removes duplicates
limit(n) → Limits number of elements

B. Terminal Operations

Produce a result or side effect.
Trigger execution of the stream pipeline.

Examples

collect() → Converts stream to List / Set / Map
forEach() → Iterates elements
reduce() → Reduces elements to a single value
count() → Returns number of elements
anyMatch(), allMatch(), noneMatch() → Conditional checks

3️⃣ Example Class
class Student {
    private String name;
    private int age;
    private double marks;
    private String department;

    public Student(String name, int age, double marks, String department) {
        this.name = name;
        this.age = age;
        this.marks = marks;
        this.department = department;
    }

    public String getName() { return name; }
    public int getAge() { return age; }
    public double getMarks() { return marks; }
    public String getDepartment() { return department; }

    @Override
    public String toString() {
        return name + " (" + age + ", " + marks + ", " + department + ")";
    }
}

4️⃣ Complex Examples

A. Filtering, Mapping, and Sorting
List<Student> students = List.of(
    new Student("Alice", 20, 85.5, "CS"),
    new Student("Bob", 22, 92.0, "IT"),
    new Student("Charlie", 19, 78.0, "CS"),
    new Student("David", 21, 92.0, "IT"),
    new Student("Eva", 20, 88.0, "CS")
);

List<String> topCSStudents = students.stream()
    .filter(s -> s.getDepartment().equals("CS") && s.getMarks() > 80)
    .sorted(Comparator.comparingDouble(Student::getMarks).reversed())
    .map(Student::getName)
    .collect(Collectors.toList());


Observations

filter removes unwanted students

sorted sorts by marks (descending)

map extracts names

collect converts stream to a List

B. Grouping and Aggregating
Map<String, Double> avgMarks = students.stream()
    .collect(Collectors.groupingBy(
        Student::getDepartment,
        Collectors.averagingDouble(Student::getMarks)
    ));


Observations

groupingBy groups students by department

averagingDouble calculates average marks

**C. Max, Min, and Reduce**
Optional<Student> topStudent = students.stream()
    .max(Comparator.comparingDouble(Student::getMarks)));

double totalMarks = students.stream()
    .mapToDouble(Student::getMarks)
    .sum();


Observations

max finds the student with highest marks

mapToDouble + sum calculates total marks

**D. FlatMap Example**
class StudentWithHobbies extends Student {
    private List<String> hobbies;

    public StudentWithHobbies(String name, int age, double marks,
                              String department, List<String> hobbies) {
        super(name, age, marks, department);
        this.hobbies = hobbies;
    }

    public List<String> getHobbies() { return hobbies; }
}

List<String> uniqueHobbies = hobbyStudents.stream()
    .flatMap(s -> s.getHobbies().stream())
    .distinct()
    .collect(Collectors.toList());


Observations

flatMap flattens multiple lists into one stream

distinct removes duplicates

**E. Partitioning**
Map<Boolean, List<Student>> partitioned = students.stream()
    .collect(Collectors.partitioningBy(s -> s.getMarks() > 80));


Observations

Divides students into passing and failing

**F. Parallel Stream**
double totalMarksParallel = students.parallelStream()
    .mapToDouble(Student::getMarks)
    .sum();


Observations

Uses multiple CPU cores

Safe when no shared mutable state exists

**5️⃣ Stream vs ParallelStream**
Feature	Stream	ParallelStream
Execution	Sequential	Parallel
Performance	Normal	Faster for large data
Thread Safety	Not inherent	Careful with shared state
Use Case	Small/medium data	Large datasets

**6️⃣ Key Takeaways**

Streams simplify data processing in Java

Use filter, map, reduce, collect for complex logic

Streams are immutable

Collectors help with grouping and partitioning

Parallel streams improve performance but need caution


# Java Streams – Grouping, Aggregation, flatMap & Parallel Streams

This README provides a **clear, interview‑ready explanation** of **Grouping & Aggregation**, **flatMap**, and **Parallel Streams** in Java Streams with examples.

---

## 1️⃣ Grouping and Aggregation (Collectors)

### 🔹 What is Grouping?

Grouping means **categorizing stream elements based on a key**.

This is done using:

```java
Collectors.groupingBy()
```

### Basic Syntax

```java
Map<K, List<T>> map =
collection.stream()
          .collect(Collectors.groupingBy(keyExtractor));
```

---

### ✅ Example 1: Group Students by Age

```java
class Student {
    String name;
    int age;
    int marks;

    // constructor + getters
}
```

```java
Map<Integer, List<Student>> groupByAge =
students.stream()
        .collect(Collectors.groupingBy(Student::getAge));
```

**Output**

```
20 → [Student1, Student3]
21 → [Student2]
```

👉 Each **age** becomes a **key**, and the value is a **list of students**.

---

### 🔹 What is Aggregation?

Aggregation means **reducing grouped data into a single value**, such as:

* count
* sum
* average
* min / max

---

### ✅ Example 2: Count Students per Age

```java
Map<Integer, Long> countByAge =
students.stream()
        .collect(Collectors.groupingBy(
            Student::getAge,
            Collectors.counting()
        ));
```

**Output**

```
20 → 2
21 → 1
```

---

### ✅ Example 3: Average Marks per Age

```java
Map<Integer, Double> avgMarksByAge =
students.stream()
        .collect(Collectors.groupingBy(
            Student::getAge,
            Collectors.averagingInt(Student::getMarks)
        ));
```

---

### ✅ Example 4: Sum of Marks per Age

```java
Map<Integer, Integer> totalMarksByAge =
students.stream()
        .collect(Collectors.groupingBy(
            Student::getAge,
            Collectors.summingInt(Student::getMarks)
        ));
```

---

### 🎯 Interview Tip

> **`groupingBy` creates buckets, downstream collectors decide what happens inside each bucket**

---

---

## 2️⃣ flatMap (MOST IMPORTANT 🔥)

### 🔹 Why flatMap?

| Operation   | Conversion                                |
| ----------- | ----------------------------------------- |
| `map()`     | 1 element → 1 element                     |
| `flatMap()` | 1 element → multiple elements → flattened |

---

### ❌ Problem Without flatMap

```java
List<List<String>> list = List.of(
    List.of("Java", "Python"),
    List.of("C++", "Go")
);

list.stream()
    .map(l -> l.stream())
    .forEach(System.out::println);
```

**Output**

```
java.util.stream.ReferencePipeline$Head@xxx
```

❌ This creates a **Stream<Stream<String>>** (stream of streams).

---

### ✅ Solution Using flatMap

```java
list.stream()
    .flatMap(l -> l.stream())
    .forEach(System.out::println);
```

**Output**

```
Java
Python
C++
Go
```

✔️ Flattened into a **single stream**.

---

### ✅ Example 2: Words from Sentences

```java
List<String> sentences =
List.of("I love Java", "Streams are powerful");

sentences.stream()
         .flatMap(s -> Arrays.stream(s.split(" ")))
         .forEach(System.out::println);
```

**Output**

```
I
love
Java
Streams
are
powerful
```

---

### ✅ Example 3: Remove Duplicates from Nested List

```java
List<List<Integer>> nums =
List.of(List.of(1,2), List.of(2,3), List.of(3,4));

nums.stream()
    .flatMap(List::stream)
    .distinct()
    .forEach(System.out::println);
```

**Output**

```
1 2 3 4
```

---

### 🎯 Interview One‑Liner

> **`flatMap` converts `Stream<Stream<T>>` into `Stream<T>`**

---

---

## 3️⃣ Parallel Streams

### 🔹 What is a Parallel Stream?

A **parallel stream** splits data into multiple parts and processes them using **multiple threads** via the **ForkJoinPool**.

```java
collection.parallelStream();
// OR
collection.stream().parallel();
```

---

### ✅ Example: Normal vs Parallel Stream

```java
List<Integer> nums = IntStream.rangeClosed(1, 10)
                             .boxed()
                             .toList();
```

#### Normal Stream

```java
nums.stream()
    .forEach(n ->
        System.out.println(Thread.currentThread().getName() + " " + n)
    );
```

#### Parallel Stream

```java
nums.parallelStream()
    .forEach(n ->
        System.out.println(Thread.currentThread().getName() + " " + n)
    );
```

**Sample Output (Parallel)**

```
ForkJoinPool.commonPool-worker-1 5
main 3
ForkJoinPool.commonPool-worker-3 8
```

✔️ Multiple threads are working concurrently.

---

### ⚠️ Order Issue

```java
nums.parallelStream().forEach(System.out::print);
```

❌ Order is **not guaranteed**

✔️ If order matters:

```java
nums.parallelStream().forEachOrdered(System.out::print);
```

---

### ❌ When NOT to Use Parallel Streams

* Small datasets
* I/O operations
* Shared mutable state
* When strict order is required

---

### ✅ When to Use Parallel Streams

* Large collections
* CPU‑intensive tasks
* Stateless operations

---

### 🎯 Interview Comparison

| Stream        | Parallel Stream         |
| ------------- | ----------------------- |
| Single thread | Multiple threads        |
| Ordered       | Unordered               |
| Predictable   | Faster but complex      |
| Safe          | Risk of race conditions |

---

---

## 🔥 Quick Summary (Revision)

* **Grouping** → `groupingBy(key)`
* **Aggregation** → `counting()`, `summingInt()`, `averagingInt()`
* **flatMap** → `Stream<Stream<T>> → Stream<T>`
* **Parallel Stream** → `parallelStream()` → multi‑threaded processing

Parallel streams use ForkJoinPool.commonPool
Worker threads are named commonPool-worker-n
Main thread also participates
Order is not guaranteed
Number of workers ≈ CPU cores − 1

---

✅ **Perfect for interview revision & GitHub README usage**


# Garbage Collection (GC) in Java

## 1️⃣ What is Garbage Collection?

**Definition:**  
Garbage Collection (GC) is the automatic process of reclaiming memory by deleting objects that are no longer reachable or needed by a program.

**Purpose:**
- Helps avoid memory leaks.
- Frees developers from manual memory management.

---

## 2️⃣ How Garbage Collection Works

1. The JVM keeps track of all objects in **heap memory**.
2. Objects that are **no longer referenced** by any part of the program become **eligible for GC**.
3. The **Garbage Collector** runs in the background and automatically frees memory occupied by these objects.

---

## 3️⃣ Using System.gc()
System.gc();



# Garbage Collection Algorithms

## 1️⃣ Mark-Sweep Algorithm

**Steps:**
1. **Mark:** Traverse all reachable objects from root references and mark them as alive.  
2. **Sweep:** Scan the heap and remove all unmarked (unreachable) objects.  

**Key Point:** Fast but can leave memory fragmentation.

---

## 2️⃣ Mark-Sweep-Compact Algorithm

**Steps:**
1. **Mark:** Same as Mark-Sweep.  
2. **Sweep:** Remove unreachable objects.  
3. **Compact:** Shift all remaining live objects together to make memory contiguous, reducing fragmentation.  

**Key Point:** Slightly slower than Mark-Sweep but prevents fragmentation.

