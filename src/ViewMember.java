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


@WebServlet("/viewmember")
public class ViewMember extends HttpServlet {
	
	Connection con;
	PreparedStatement pst;
	ResultSet rs;
	int row;
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/userdb", "root", "1234");
			
			String sql;
			String phone = request.getParameter("phone");
			
			pst = con.prepareStatement("select * from member where phone=?");
			pst.setString(1, phone);
			
			rs = pst.executeQuery();
			
			out.println("<nav><a href='logout.jsp'>Logout</a><nav>");
			
			out.println("<table width ='400px' border='1'>");
			while(rs.next())
			{

			
			out.println("<tr>");out.println("<td width ='250px'> <strong>Name</strong> </td><td>"+ rs.getString("uname") + "</td>");out.println("</tr>");
			out.println("<tr>");out.println("<td> <strong>Phone</strong> </td><td>" + rs.getString("phone") + "</td>");out.println("</tr>");
			out.println("<tr>");out.println("<td> <strong>Age</strong> </td><td>" + rs.getString("age") + "</td>");out.println("</tr>");
			out.println("<tr>");out.println("<td> <strong>Gender</strong> </td><td>" + rs.getString("gender") + "</td>");out.println("</tr>");
			out.println("<tr>");out.println("<td> <strong>Address</strong> </td><td>" + rs.getString("address") + "</td>");out.println("</tr>");
			out.println("<tr>");out.println("<td> <strong>Password</strong> </td><td>" + rs.getString("password") + "</td>");out.println("</tr>");
			
			out.println("<td colspan=2>"+ "<a href='editreturn?phone=" + rs.getString("phone")+ "'>Edit</a>" + "</td>");
			out.println("</tr>");

			}
			out.println("</table>");
		} catch (ClassNotFoundException ex) {
			Logger.getLogger(Member.class.getName()).log(Level.SEVERE, null, ex);
		} catch (SQLException ex) {
			out.println ("fialed");
		}
	}
	
}
