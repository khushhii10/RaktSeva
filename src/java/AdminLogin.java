import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import javax.swing.*;
public class AdminLogin extends HttpServlet
{
public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
{
        PrintWriter out = response.getWriter();
        String s1=request.getParameter("u1");
        String s2=request.getParameter("u2");
      
            try
            {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/RaktSeva?useSSL=false","root","root");
            Statement st=con.createStatement();
            String s11="select Name, Password from adminLogin where Name='"+s1+"' AND Password='"+s2+"' ";
            ResultSet rs=st.executeQuery(s11);
            if(rs.next())
            {
            response.sendRedirect("AdminDashboard.html");
            }
            else
            {
            out.println("Invalid username and password");
               /* JOptionPane.showMessageDialog("Enter a valid username or password", 
                                   "ERROR", JOptionPane.ERROR_MESSAGE);*/
            }
            //response.sendRedirect("ShowAll");
            con.close();
            }
            catch(Exception e)
            {
            out.print(e);
            }
               out.close();
        }
    }
