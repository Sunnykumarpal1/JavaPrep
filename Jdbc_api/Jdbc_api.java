package Jdbc_api;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class start {

    public static void main(String[] args) {
        /*
        JDBC Explanation 
        
        JDBC API contains interfaces and classes
        This API defines a standard set of interfaces and classes for interacting with databases in Java, such as Connection, Statement, and ResultSet.

        JDBC driver implements the interfaces defined in the JDBC API
        The driver provides concrete implementations of these interfaces for a specific database.

        The JDBC driver converts Java method calls into database-specific protocol
        It translates Java code (like executeQuery()) into the format required by the database (SQL and low-level protocol).

        The driver communicates with the database
        After converting the method calls, it sends the request to the database and receives the response.

        The driver converts the database response into Java objects
        The response from the database is converted into Java-readable objects like ResultSet.

        The JDBC driver is usually provided by the database vendor (such as Oracle, MySQL, PostgreSQL) or a third-party provider, not directly by the database software itself.
         */

        /*  steps to connect the java to database 
            1. Load the driver(but after java 1.4 it's not required)
            2. Create connection
            3. create statement
            4. execute query
            5. Display result
        */ 
        // ladoing an driver
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            

             //  connection -> url, username, password
            // url format-> jdbc api: providing the implmentation ://https: ip adddress: portnumber
            String url="jdbc:MySql://https:localhost:3306/";
            String user="root";
            String password="123456";
            Connection connection = DriverManager.getConnection(url,user,password);

            // create statement
            Statement st=connection.createStatement();

            // query
            String query="selct * from STUDENT";

            ResultSet rs = st.executeQuery(query);
            System.out.println(" ID " + " NAME "+" COURSE "+" AGE ");
            try {
                 while(rs.next()){
               System.out.println(rs.getInt("ID")+" "+rs.getString("NAME")+" "+rs.getString("COURSE")+" "+rs.getInt("AGE")); 
              }
            } catch (Exception e) {
                System.out.println("got exception while retriving");
            }
           

        }catch(Exception ex){
            ex.printStackTrace();
        }
        
       

    }
}
