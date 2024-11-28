import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;

public class DonorDetails extends HttpServlet 
{
public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
{
       
        PrintWriter out = response.getWriter();
        
            out.println("<html>");
            out.println("<body>");
            out.print("<head>");
            out.print("<style type='text/css'>");
//out.print("body{background-image:url(img4.jpg);}");
out.print("</style>");
  out.print("</head>");
            try
            {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/raktseva?useSSL=false","root","root");
            String s11="select * from donordetails";
            Statement st=con.createStatement();
            ResultSet rs=st.executeQuery(s11);
             out.print("<center>");
             out.print("<table border='1' cellpadding='10px' cellspacing='5px'>");
             out.print("<tr>");
             out.print("<th>"); out.print("Name"); out.print("</th>");
             out.print("<th>"); out.print("BloodGroup"); out.print("</th>");
             out.print("<th>"); out.print("Age"); out.print("</th>");
             out.print("<th>"); out.print("Disease"); out.print("</th>");
             out.print("<th>"); out.print("Date"); out.print("</th>");
             out.print("<th>"); out.print("Time"); out.print("</th>");
             out.print("<th>"); out.print("Address"); out.print("</th>");
             out.print("<th>"); out.print("Contact"); out.print("</th>");
             
             out.print("</tr>");
             
            while(rs.next())
            {
            out.print("<tr>");
            out.print("<td>"); out.print(rs.getString(1));out.print("</td>");
            out.print("<td>"); out.print(rs.getString(2));out.print("</td>");
            out.print("<td>"); out.print(rs.getString(3));out.print("</td>");
            out.print("<td>"); out.print(rs.getString(4));out.print("</td>");
            out.print("<td>"); out.print(rs.getString(5));out.print("</td>");
            out.print("<td>"); out.print(rs.getString(6));out.print("</td>");
            out.print("<td>"); out.print(rs.getString(7));out.print("</td>");
            out.print("<td>"); out.print(rs.getString(8));out.print("</td>");
            
            out.print("</tr>");
            }
            out.print("</table>");
            out.print("</center>");
             con.close();
            }
           
            catch(Exception e)
            {
            out.print(e);
            }
            out.close();
            out.println("</body>");
            out.println("</html>");
 }
 }
