import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/editreturn")
public class EditReturn extends HttpServlet {

	Connection con;
	PreparedStatement pst;
	ResultSet rs;
	int row;
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String phone = request.getParameter("phone");
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/userdb", "root", "1234");
			
			pst = con.prepareStatement("select * from member where phone =?");
			pst.setString(1, phone);
			
			rs = pst.executeQuery();
			
			while(rs.next())
			{
				out.println("<table>");
				out.println("<form action='editservlet' method='POST'");

				out.println("<tr>");out.println("<td>Name</td> <td><input type='text' name='uname' value='" + rs.getString("uname") + "'/></td>");out.println("</tr>");
				out.println("<tr>");out.println("<td>Age</td> <td><input type='text' name='age' value='" + rs.getString("age") + "'/></td>");out.println("</tr>");				
				out.println("<tr>");out.println("<td>Gender</td> <td><input type='text' name='gender' value='" + rs.getString("gender") + "'/></td>");out.println("</tr>");				
				out.println("<tr>");out.println("<td>Address</td> <td><input type='text' name='address' value='" + rs.getString("address") + "'/></td>");out.println("</tr>");				
				out.println("<tr>");out.println("<td>Password</td> <td><input type='text' name='password' value='" + rs.getString("password") + "'/></td>");out.println("</tr>");
				out.println("<tr>");out.println("<td colspan=2><input type='submit' name='submit' /></td></tr>");out.println("</tr>");
				out.println("</form>");

				out.println("</table>");
			}
			
		
		
		} catch (ClassNotFoundException ex) {
			Logger.getLogger(Member.class.getName()).log(Level.SEVERE, null, ex);
		} catch (SQLException ex) {
			out.println ("fialed");
		}
	}

	
}
