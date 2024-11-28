import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
public class Registration extends HttpServlet
{
public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
{
        PrintWriter out = response.getWriter();
        String s1=request.getParameter("u1");
        String s2=request.getParameter("u2");
        String s3=request.getParameter("u3");
        String s4=request.getParameter("u4");
        String s5=request.getParameter("u5");
        String s6=request.getParameter("u6");
        String s7=request.getParameter("u7");
        String s8=request.getParameter("u8");
           
            try
            {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/raktseva?useSSL=false","root","root");
            //Connection con=DriverManager.getConnection("jdbc:mysql:///RaktSeva","root","root");
            Statement st=con.createStatement();
            String s11="insert into registration values('"+s1+"','"+s2+"','"+s4+"','"+s5+"','"+s6+"','"+s7+"','"+s8+"','"+s3+"')";
            st.executeUpdate(s11);
            response.sendRedirect("RLogin.html");
            con.close();
            }
            catch(Exception e)
            {
            out.print(e);
            }
            out.close();
            
         
        }
    }




/*import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class Registration extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // Get parameters from form
        String s1 = request.getParameter("u1");
        String s2 = request.getParameter("u2");
        String s3 = request.getParameter("u3");
        String s4 = request.getParameter("u4");
        String s5 = request.getParameter("u5");
        String s6 = request.getParameter("u6");
        String s7 = request.getParameter("u7");
        String s8 = request.getParameter("u8");

        out.println("<html><body>");
        try {
            // Load the MySQL JDBC driver
            //Class.forName("com.mysql.cj.jdbc.Driver");
            Class.forName("com.mysql.jdbc.Driver");
            // Establish connection
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/RaktSeva?useSSL=false", "root", "root");

            // Use PreparedStatement to insert data
            String query = "INSERT INTO registration (name, gender, age, bloodType, address, city, country, other) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, s1);
            ps.setString(2, s2);
            ps.setInt(3, Integer.parseInt(s3)); // Assuming age is an integer
            ps.setString(4, s4);
            ps.setString(5, s5);
            ps.setString(6, s6);
            ps.setString(7, s7);
            ps.setString(8, s8);

            // Execute the update
            int result = ps.executeUpdate();
            if (result > 0) {
                out.println("Data saved successfully!");
            } else {
                out.println("Data could not be saved.");
            }

            // Close connection
            con.close();
        } catch (Exception e) {
            out.println("Error: " + e.getMessage());
        }
        out.println("</body></html>");
        out.close();
    }
}*/
