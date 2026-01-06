# JDBC Notes

## What happens when a JDBC program runs?

When a JDBC program runs:

* The **JDBC driver** is loaded and registered with `DriverManager`.
* Based on the **JDBC URL**, `DriverManager` selects the appropriate driver.
* The driver establishes a **socket connection** with the database.
* The database **authenticates the user**.
* A `Connection` object is returned to the Java application.
* SQL statements are sent to the database through the driver.
* The **database engine executes** the SQL queries.
* Results are returned to Java as `ResultSet` objects.

👉 **JDBC handles communication**, while the **database handles query execution and transaction management**.

---

## 1️⃣ What does JDBC do?

JDBC (Java Database Connectivity) acts as a **bridge between Java programs and databases** such as:

* MySQL
* PostgreSQL
* Oracle
* SQL Server

It allows Java applications to:

* Connect to a database
* Execute SQL queries (`SELECT`, `INSERT`, `UPDATE`, `DELETE`)
* Retrieve results
* Handle database transactions

---

## 2️⃣ Why is JDBC needed?

### Without JDBC:

* Java would not know how to communicate with different databases.

### With JDBC:

* The **same Java code works with different databases**.
* Only the **driver changes**, not the Java logic.

---

## 3️⃣ JDBC Architecture (Simple View)

```
Java Application
       |
   JDBC API
       |
 JDBC Driver
       |
   Database
```

### Components Explained:

* **JDBC API** → Interfaces and classes provided by Java
* **JDBC Driver** → Database-specific implementation (MySQL, Oracle, etc.)
* **Database** → Stores and processes the data

---

## 4️⃣ Main Components of JDBC API

### 1. DriverManager

* Manages JDBC drivers
* Establishes a connection with the database

```java
Connection con = DriverManager.getConnection(url, user, password);
```

---

### 2. Connection

* Represents an **active connection** to the database
* Used to create SQL statements

```java
Connection con;
```

---

### 3. Statement

Used to execute SQL queries.

#### a) Statement

```java
Statement st = con.createStatement();
```

---

#### b) PreparedStatement (⭐ MOST IMPORTANT FOR INTERVIEWS)

* Precompiled SQL statement
* Prevents **SQL Injection**
* Better performance

```java
PreparedStatement ps =
    con.prepareStatement("SELECT * FROM users WHERE id = ?");
ps.setInt(1, 101);
```

---

#### c) CallableStatement

* Used to execute **stored procedures**

---

### 4. ResultSet

* Stores data returned by a `SELECT` query

```java
ResultSet rs = ps.executeQuery();
while (rs.next()) {
    System.out.println(rs.getString("name"));
}
```

---

## 5️⃣ Steps to Use JDBC (Very Important)

1. Load the driver
2. Create a connection
3. Create a statement
4. Execute the query
5. Process the result
6. Close resources

---

## 6️⃣ Simple JDBC Example (MySQL)

```java
import java.sql.*;

class Demo {
    public static void main(String[] args) throws Exception {

        String url = "jdbc:mysql://localhost:3306/testdb";
        String user = "root";
        String password = "root";

        Connection con = DriverManager.getConnection(url, user, password);

        PreparedStatement ps =
            con.prepareStatement("SELECT * FROM student");

        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            System.out.println(rs.getInt(1) + " " + rs.getString(2));
        }

        con.close();
    }
}
```

---

## 📌 Key Interview Points

* JDBC is an **API**, not a tool
* `PreparedStatement` is preferred over `Statement`
* JDBC is **database-independent**
* Driver handles communication, DB handles execution

---

✅ **This README can be directly used in GitHub or project documentation.**
