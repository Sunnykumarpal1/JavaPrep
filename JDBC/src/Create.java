import java.sql.*;

public class Create {
    public static void main(String[] args) {
        String url="jdbc:MySql://localhost:3306/jdbc";
        String user="root";
        String password="123456";
        Connection connection = null;
        Statement st=null;
        ResultSet rs=null;
        try {
            connection = DriverManager.getConnection(url,user,password);

            // create statement
            st  =connection.createStatement();

            String q1="Create table Employee (EId int primary key,EName varchar(30))";
            st.executeUpdate(q1);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        // query
    }
}
