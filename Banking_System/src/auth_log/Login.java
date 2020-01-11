package auth_log;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		response.setContentType("text/html;charset=UTF-8");
		String account_no = request.getParameter("account_no");
		String password = request.getParameter("password");
		
		if(validate.checkUser(account_no,password))
		{
			RequestDispatcher rd = request.getRequestDispatcher("Home.html");
			PrintWriter out = response.getWriter();
			out.print("<font color=blue>Welcome to world bank</font>");
			rd.include(request, response);
		}
		else
		{
			
			RequestDispatcher rd = request.getRequestDispatcher("Home.html");
			PrintWriter out = response.getWriter();
			out.print("<font color=red>Account_number or Password is incorrect</font>");
			rd.include(request, response);	
		}
		
	}
}
