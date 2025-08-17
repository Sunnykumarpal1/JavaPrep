import jakarta.servlet.*;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class FirstServlet extends HttpServlet {
    List<User> users=new ArrayList<>();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        res.setContentType("text/HTML");
        PrintWriter out=res.getWriter();
        out.print("The available users are"+"<br>");
        for(User u:users){
            out.print("name:- "+u.getUserName()+" email:-  "+u.getUserMail()+"<br>");
            out.print("<br>");
        }

        out.print("<a href='index.html'>Register User</a>");

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        res.setContentType("text/HTML");
        PrintWriter pw=res.getWriter();
        String name=req.getParameter("userName");
        String email=req.getParameter("userEmail");
        User us=new User(name,email);
        users.add(us);
        pw.print("<h1>hello how are you</h1>");
        pw.print("Name "+name);
        pw.print("Email "+email+"<br>");

        pw.print("<a href='index.html'>Register User</a><br><br>");
        pw.print("<a href='register'>View All Users</a>");
    }
}

class User{
    String userName;
    String userMail;

    public User(String userName, String userMail) {
        this.userName = userName;
        this.userMail = userMail;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserMail() {
        return userMail;
    }

    public void setUserMail(String userMail) {
        this.userMail = userMail;
    }
}


