import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateEmployee {
    public static void main(String[] args) {
        Connection con=MyConnection.getConnection();
        String query="Update Employee set Ename=? where Eid=?";
        try {
            PreparedStatement stmt=con.prepareStatement(query);
            stmt.setString(1,"p1");
            stmt.setInt(2,1);
            int row=stmt.executeUpdate();
            System.out.println("Rows affected"+row);
        }catch (SQLException exp){
            exp.printStackTrace();
        }
    }
}
