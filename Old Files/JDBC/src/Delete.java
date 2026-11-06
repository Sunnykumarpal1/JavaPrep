import java.sql.*;

public class Delete {
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

            String q1="DELETE FROM STUDENT WHERE ID=1";
            int rows=st.executeUpdate(q1);
            String query="SELECT * FROM STUDENT";
            rs= st.executeQuery(query);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        // query

        System.out.println(" ID " + " NAME "+" COURSE "+" AGE ");
        try {
            while(rs.next()){
                System.out.println(rs.getInt("ID")+" "+rs.getString("NAME")+" "+rs.getString("COURSE")+" "+rs.getInt("AGE"));
            }
        } catch (Exception e) {
            System.out.println("got exception while retriving");
        }
    }
}
