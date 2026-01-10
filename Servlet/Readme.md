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



Correct Java Servlet Flow

1️⃣ Write Java Servlet code → LoginServlet.java

2️⃣ Compile → produces LoginServlet.class

3️⃣ Package the classes and resources → into a WAR (Web Application Archive)

WAR contains:

WEB-INF/classes → compiled .class files

WEB-INF/web.xml → servlet mappings

JSPs, HTML, CSS, JS, etc.

4️⃣ Deploy WAR to Tomcat

Tomcat extracts the WAR internally

Reads web.xml or @WebServlet annotations

Maps URLs → corresponding servlets

5️⃣ Servlet Loading & Initialization

Tomcat creates instance of servlet (only once)

Calls init() method → initializes the servlet

6️⃣ Browser sends HTTP request (GET / POST / etc.) to Tomcat web server

7️⃣ Tomcat maps the request → finds the correct servlet using URL mapping

8️⃣ Servlet processes the request

Servlet Container calls service() → internally calls doGet() / doPost()

Servlet executes Java code → reads request, processes logic, generates response

9️⃣ Servlet Container sends response back to Web Server

🔟 Web Server sends HTTP response back to browser

⚡ Important note: destroy() is not called after every request — it is called only once when:

Tomcat shuts down

Application undeployed