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