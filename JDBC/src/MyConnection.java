import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MyConnection {
    public  static  Connection getConnection() {
        String userName="root";
        String password="123456";
        String url="jdbc:mysql://localhost:3306/ptrial";
        Connection con=null;
        try{
            con= DriverManager.getConnection(url, userName, password);
        }catch (SQLException exp){
            exp.printStackTrace();
        }
        return con;

    }
}
