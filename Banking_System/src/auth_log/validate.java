package auth_log;

import java.sql.*;

import javax.servlet.annotation.WebServlet;


/**
 * Servlet implementation class validate
 */
@WebServlet("/validate")
public class validate {
	static boolean checkUser(String account_no, String password)
	{
		boolean st = false;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/WorldBank","root","admin");
			PreparedStatement ps = con.prepareStatement("select*from user_data where account_no=? and password=?");
			ps.setString(1, account_no);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			st = rs.next();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return st;
	}
       
	

}
