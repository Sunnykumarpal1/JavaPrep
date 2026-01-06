import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertEmployee {
    public static void main(String[] args) {
        Connection con=MyConnection.getConnection();
        String query="Insert into employee(EID,EName) values(?,?),(?,?),(?,?)";
        try{
            PreparedStatement pstmt=con.prepareStatement(query);
            pstmt.setInt(1,1);
            pstmt.setInt(3,2);
            pstmt.setInt(5,3);
            pstmt.setString(2,"Sunny");
            pstmt.setString(4,"vaibhav");
            pstmt.setString(6,"faizan");
            int row=pstmt.executeUpdate();
            System.out.println("Rows "+row);


        }catch (SQLException exp){
            exp.printStackTrace();
        }


    }
}
