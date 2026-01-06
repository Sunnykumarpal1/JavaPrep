# JDBC Notes

## What happens when a JDBC program runs?

When a JDBC program runs:

* The **JDBC driver** is loaded and registered with `DriverManager`.
* Based on the **JDBC URL**, `DriverManager` selects the appropriate driver.
* The driver establishes a **socket connection** with the database.
* The database **authenticates the user**.
* A `Connection` object is returned to the Java application.
* we execute SQL using Statement or PreparedStatement, the driver converts JDBC calls into database-specific protocol and sends them to the database engine.
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
# JDBC Transactions Guide

## 1️⃣ What is a Transaction?

A transaction is a group of SQL operations that must be executed as a single unit.

**Behavior:**

* All operations succeed → `COMMIT`
* Any operation fails → `ROLLBACK`

**Real-life Example:**

* **Bank Transfer:**

    * Debit from Account A
    * Credit to Account B
    * If debit succeeds but credit fails → ❌ data inconsistency
    * Both must succeed or both must fail.

## 2️⃣ Transaction Properties (ACID)

Databases follow ACID:

| Property    | Meaning                      |
| ----------- | ---------------------------- |
| Atomicity   | All or nothing               |
| Consistency | DB remains valid             |
| Isolation   | Transactions don’t interfere |
| Durability  | Committed data is permanent  |

## 3️⃣ Transactions in JDBC (Core Idea)

By default:

```java
con.getAutoCommit(); // true
```

* Each SQL statement is committed automatically.

**Why auto-commit is bad for multi-step logic?**

* If one statement fails, previous statements are already committed
* You cannot rollback

## 4️⃣ Manual Transaction Control in JDBC

To handle transactions properly:

**Step 1:** Disable auto-commit

```java
con.setAutoCommit(false);
```

**Step 2:** Execute multiple SQL statements

**Step 3:** Commit or rollback

```java
con.commit();   // success
con.rollback(); // failure
```

## 5️⃣ JDBC Transaction Example (Bank Transfer)

```java
Connection con = null;

try {
    con = DriverManager.getConnection(url, user, pass);

    // 1️⃣ Disable auto-commit
    con.setAutoCommit(false);

    PreparedStatement debit =
        con.prepareStatement("UPDATE account SET balance = balance - ? WHERE id = ?");

    PreparedStatement credit =
        con.prepareStatement("UPDATE account SET balance = balance + ? WHERE id = ?");

    // Debit from account A
    debit.setInt(1, 1000);
    debit.setInt(2, 1);
    debit.executeUpdate();

    // Credit to account B
    credit.setInt(1, 1000);
    credit.setInt(2, 2);
    credit.executeUpdate();

    // 2️⃣ Commit if everything succeeds
    con.commit();
    System.out.println("Transaction successful");

} catch (Exception e) {
    // 3️⃣ Rollback on failure
    if (con != null) {
        con.rollback();
    }
    System.out.println("Transaction failed, rolled back");

} finally {
    if (con != null) con.close();
}
```

## 6️⃣ What Happens Internally?

* `setAutoCommit(false)` → JDBC tells DB “don’t commit automatically”
* SQL statements are executed but not committed
* `commit()` → DB permanently saves changes
* `rollback()` → DB undoes all changes since last commit

## 7️⃣ Savepoints (Advanced but Good to Know)

Savepoints allow partial rollback.

```java
Savepoint sp = con.setSavepoint();

// some SQL statements
con.rollback(sp); // rollback to savepoint
```

✅ **This README can be directly used in GitHub or project documentation.**

