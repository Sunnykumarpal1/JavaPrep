Java Streams API – Complete Guide
📌 What is Stream API?

Introduced in Java 8, the Streams API is used to process collections of data in a functional and declarative style.
A stream does not store data; it processes data from a source such as a Collection, Array, or I/O channel.

Streams allow operations like filter, map, reduce, collect, etc., without explicitly writing loops.

✨ Key Features

No Storage
A Stream is not a data structure; it only processes data.

Functional in Nature
Operations are expressed using functions and lambda expressions.

Lazy Evaluation
Intermediate operations execute only when a terminal operation is invoked.

Parallel Execution Support
Streams can run in parallel using parallelStream().

Pipelining
Multiple operations can be chained together to form a processing pipeline.

🔄 Stream Operations

Streams support two types of operations.

1. Intermediate Operations

Return a new Stream

Are lazy

Common Intermediate Operations

filter(Predicate) → Filters elements

map(Function) → Transforms elements

sorted() → Sorts elements

distinct() → Removes duplicates

limit(n) → Limits number of elements

2. Terminal Operations

Produce a result or side-effect

Trigger execution of the stream pipeline

Common Terminal Operations

collect() → Converts stream to List / Set / Map

forEach() → Iterates elements

reduce() → Reduces elements to a single value

count() → Returns number of elements

anyMatch(), allMatch(), noneMatch() → Conditional checks

🧱 Example Model Class
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

🧪 Stream API Examples
🔹 Filtering, Mapping, and Sorting
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


Explanation

Filters CS students with marks > 80

Sorts them by marks in descending order

Extracts student names

Collects results into a List

🔹 Grouping and Aggregation
Map<String, Double> avgMarks = students.stream()
.collect(Collectors.groupingBy(
Student::getDepartment,
Collectors.averagingDouble(Student::getMarks)
));


Explanation

Groups students by department

Calculates average marks per department

🔹 Max, Min, and Reduce
Optional<Student> topStudent = students.stream()
.max(Comparator.comparingDouble(Student::getMarks)));

double totalMarks = students.stream()
.mapToDouble(Student::getMarks)
.sum();


Explanation

Finds student with highest marks

Calculates total marks of all students

🔹 FlatMap Example
class StudentWithHobbies extends Student {
private List<String> hobbies;

    public StudentWithHobbies(String name, int age, double marks,
                              String department, List<String> hobbies) {
        super(name, age, marks, department);
        this.hobbies = hobbies;
    }

    public List<String> getHobbies() {
        return hobbies;
    }
}

List<String> uniqueHobbies = hobbyStudents.stream()
.flatMap(s -> s.getHobbies().stream())
.distinct()
.collect(Collectors.toList());


Explanation

Flattens a list of hobby lists into a single stream

Removes duplicate hobbies

🔹 Partitioning
Map<Boolean, List<Student>> partitioned = students.stream()
.collect(Collectors.partitioningBy(s -> s.getMarks() > 80));


Explanation

Divides students into passing (true) and failing (false)

🔹 Parallel Stream Example
double totalMarksParallel = students.parallelStream()
.mapToDouble(Student::getMarks)
.sum();


Explanation

Uses multiple CPU cores

Suitable for large datasets

Avoid shared mutable state

⚖️ Stream vs ParallelStream
Feature	Stream	ParallelStream
Execution	Sequential	Parallel
Performance	Normal	Faster for large data
Thread Safety	Not inherent	Careful with shared state
Use Case	Small / Medium data	Large datasets
📝 Key Takeaways

Streams simplify data processing in Java

Declarative and functional approach

Original collection remains unchanged

Collectors help with grouping, partitioning, and aggregation

Parallel streams improve performance but require caution

📌 Recommended Use

Use Streams for clean, readable, and expressive data processing logic.
Use Parallel Streams only when dealing with large datasets and stateless operations.