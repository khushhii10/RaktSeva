
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;

public class DonorAdminDetail extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
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
        out.println("<h2>Donations</h2>");
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

        try {
            // Database connection and query execution
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/raktseva?useSSL=false", "root", "root");
            String query = "SELECT * FROM dschedule";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);

            // Display data in a table
            out.println("<center>");
            out.println("<table>");
            out.println("<tr>");
            out.println("<th>Name</th>");
            out.println("<th>Blood Group</th>");
            out.println("<th>Age</th>");
            out.println("<th>Gender</th>");
            out.println("<th>Disease</th>");
            out.println("<th>Date</th>");
            out.println("<th>Time</th>");
            out.println("<th>Address</th>");
            out.println("<th>Contact</th>");
            out.println("<th>Units</th>");
            out.println("<th>Action</th>");
            out.println("</tr>");

            // Loop through the results
            while (rs.next()) {
                out.println("<tr>");
                out.println("<td>" + rs.getString(1) + "</td>");
                out.println("<td>" + rs.getString(2) + "</td>");
                out.println("<td>" + rs.getString(3) + "</td>");
                out.println("<td>" + rs.getString(4) + "</td>");
                out.println("<td>" + rs.getString(5) + "</td>");
                out.println("<td>" + rs.getString(6) + "</td>");
                out.println("<td>" + rs.getString(7) + "</td>");
                out.println("<td>" + rs.getString(8) + "</td>");
                out.println("<td>" + rs.getString(9) + "</td>");
                out.println("<td>" + rs.getString(10) + "</td>");
                out.println("<td>");
                out.println("<button onclick=\"handleAction('approve', '" + rs.getString("Name") + "', '" + rs.getString("BloodGroup") + "', '" + rs.getString("Age") + "', '" + rs.getString("Gender") + "', '" + rs.getString("Disease") + "', '" + rs.getString("Date") + "', '" + rs.getString("Time") + "', '" + rs.getString("Address") + "', '" + rs.getString("Contact") + "', '" + rs.getString("Units") + "')\">Approve</button>");
out.println("<button onclick=\"handleAction('reject', '" + rs.getString("Name") + "', '" + rs.getString("BloodGroup") + "', '" + rs.getString("Date") + "', '" + rs.getString("Time") + "')\">Reject</button>");
out.println("</td>");

                out.println("</tr>");
            }
            out.println("</table>");
            out.println("</center>");
            con.close();
        } catch (Exception e) {
            out.println("<p>Error: " + e.getMessage() + "</p>");
        }

        out.println("</div>"); // Close container
        out.println("</body>");
        out.println("</html>");
    }
}
