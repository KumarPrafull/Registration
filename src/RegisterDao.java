import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RegisterDao {
	
private String dbUrl="jdbc:mysql://localhost:3306/userdb";
private String dbUname="root";
private String dbPassword="1234";
private String dbDriver="com.mysql.cj.jdbc.Driver";

public void loadDriver(String dbDriver)
{
	try {
		Class.forName(dbDriver);
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}

public Connection getConnection() 
{
Connection con=null;
try {
	con=DriverManager.getConnection(dbUrl, dbUname, dbPassword);
} catch (SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
return con;
}

public String insert(Member member)
{
loadDriver(dbDriver);
	Connection con=getConnection();
	String result="Data enterd Successfully";
	String sql="insert into member values(?,?,?,?,?,?)";
	
	PreparedStatement ps;
	try {
	ps = con.prepareStatement(sql);

	ps.setString(1, member.getUname());
	ps.setString(2, member.getPhone());
	ps.setString(3, member.getAge());
	ps.setString(4, member.getGender());
	ps.setString(5, member.getAddress());
	ps.setString(6, member.getPassword());
	
	ps.executeUpdate();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	result="Data not entered";
	
	}

	return result;
	

}
}
