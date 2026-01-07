# 🔹 Step-by-Step Working (From Browser to Servlet)

## 1️⃣ Client (Browser)

### Example
http://localhost:8080/login

markdown
Copy code

### What the browser does
- Creates an HTTP request

### Request contains
- URL
- HTTP Method (GET / POST)
- Headers
- Body (for POST requests)

➡️ This request is sent over the network to the server.

---

## 2️⃣ Web Server (Tomcat – Web Server Part)

Tomcat listens on a port (default **8080**).

### What happens
- Tomcat accepts the HTTP request
- Parses:
    - URL
    - HTTP Method
    - Headers

### Decision by Tomcat
❓ Is this request for:
- Static resource (HTML, CSS, image)?
- Dynamic resource (Servlet)?

### Case 1: Static Resource
Example:
/index.html

sql
Copy code

➡️ Tomcat directly reads the file and sends the response.

### Case 2: Dynamic Resource
Example:
/login

yaml
Copy code

➡️ Request is forwarded to the Servlet Container.

---

## 3️⃣ Servlet Container (Inside Tomcat)

Now the Servlet Container takes control.

### Responsibilities
- URL → Servlet mapping
- Create request and response objects
- Manage servlet lifecycle
- Handle multithreading

### 🔹 URL Mapping
Tomcat checks:
```java
@WebServlet("/login")
or web.xml

➡️ Finds LoginServlet.

4️⃣ Servlet Lifecycle Handling
If servlet is accessed for the first time
Load servlet class

Create servlet object

Call init()

For every request
Call service()

Internally, service() calls:

doGet()

doPost()

5️⃣ Servlet Processing
Inside doGet() / doPost():

java
Copy code
protected void doPost(HttpServletRequest request,
                      HttpServletResponse response) {

    String user = request.getParameter("username");

    // Business logic
    // DB call (JDBC)

    response.getWriter().println("Login Successful");
}
What the servlet does
Reads request data

Executes business logic

Interacts with database

Prepares response

6️⃣ HTTP Response Creation
The servlet writes data into HttpServletResponse.

Sets
Status code (200, 404)

Content type

Response body

Example Response
pgsql
Copy code
HTTP/1.1 200 OK
Content-Type: text/html

Login Successful
7️⃣ Response Back to Client
Flow Back
scss
Copy code
Servlet
   ↓
Servlet Container
   ↓
Web Server (Tomcat)
   ↓
Browser
Browser Action
Receives response

Renders HTML / displays output

markdown
Copy code
