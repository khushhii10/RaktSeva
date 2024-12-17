import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;

public class Requests extends HttpServlet 
{
public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
{
       PrintWriter out = response.getWriter();
       // Start of HTML content
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Admin Dashboard</title>");
        
        // Embedded CSS
        out.println("<style>");
        out.println("* { box-sizing: border-box; margin: 0; padding: 0; }");
        out.println("body { font-family: Arial, sans-serif; background-color: #fff; color: #333; }");
        out.println(".sidebar { margin-top:100px; width: 230px; background-color: black; opacity: 0.8; color: #fff; padding: 20px; height: 100vh; position: fixed; top: 0; left: 0; }");
        out.println(".sidebar h2 { font-size: 1.6em; margin-bottom: 15px; }");
        out.println(".sidebar nav ul { list-style-type: none; padding: 20px; text-align: justify; }");
        out.println(".sidebar nav ul li { margin-bottom: 10px; padding: 10px; }");
        out.println(".sidebar nav ul li a { color: #fff; text-decoration: none; font-size: 1.1em; display: block; }");
        out.println(".sidebar nav ul li a:hover { text-decoration: underline; }");
        out.println(".container { margin-left: 250px; padding: 20px; margin-top:15px; }");
        out.println(".nav { width:100%;height:100px; background-color: red;color:white;padding:37px;}");
        out.println("h4 { text-align: right; margin-top: -30px; text-decoration:none;color:white; }");
        out.println("table { width: 100%; border-collapse: collapse; margin: 20px 0; }");
        out.println("table, th, td { border: 1px solid #ddd; padding: 8px; }");
        out.println("th { background-color: #f2f2f2; text-align: left; }");
        out.println("</style>");
        
        out.println("</head>");
        out.println("<body>");
        
        // Sidebar Navigation
        out.println("<aside class='sidebar'>");
        out.println("<h2>Recipient Details</h2>");
        out.println("<nav>");
        out.println("<ul>");
        out.println("<li><a href='Home.html'>Home</a></li>");
        out.println("<li><a href='DonorAdminDetail'>Donation</a></li>");
        out.println("<li><a href='Requests'>Blood Request</a></li>");
        out.println("<li><a href='AdminDashboard.html'>Blood Stocks</a></li>");
        out.println("</ul>");
        out.println("</nav>");
        out.println("</aside>");
        
        // Navbar
        out.println("<div class='nav'>");
        out.println("<span><h2>Admin Dashboard</h2></span>");
        out.println("<h4><a href='Logout.html'>Logout</a></h4>");
        out.println("</div>");
        
        // Main container
        out.println("<div class='container'>");
            try
            {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/raktseva?useSSL=false","root","root");
            String s11="select * from requestmade";
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
             out.print("<th>"); out.print("Emergency"); out.print("</th>");
             out.print("<th>"); out.print("Any Note"); out.print("</th>");
             out.print("<th>"); out.print("Unit"); out.print("</th>");
             out.print("<th>"); out.print("Action"); out.print("</th>");
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
            out.print("<td>"); out.print(rs.getString(9));out.print("</td>");
            out.print("<td>"); out.print(rs.getString(10));out.print("</td>");
            out.print("<td>"); out.print(rs.getString(11));out.print("</td>");
            out.println("<td>");
                out.println("<button style='margin-right: 5px;'>Approve</button>");
                out.println("<button>Reject</button>");
                out.println("</td>");
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

