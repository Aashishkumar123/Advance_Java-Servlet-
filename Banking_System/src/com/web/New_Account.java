package com.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class New_Account
 */
@WebServlet("/New_Account")
public class New_Account extends HttpServlet {
		/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
			String first_name = request.getParameter("firstname");
			String last_name = request.getParameter("lastname");
			String email = request.getParameter("email");
			String account_number = request.getParameter("account_no");
			String password = request.getParameter("password");
			String country = request.getParameter("country");
			String state = request.getParameter("state");
			String city = request.getParameter("city");
			String sex = request.getParameter("gender");
			String bank_name = request.getParameter("bank");
			Connection connection = ConnectionProvider.getConn();
			
			try {
				PreparedStatement ps = connection.prepareStatement("insert into user_data values(?,?,?,?,?,?,?,?,?,?)");
			ps.setString(1, first_name);
			ps.setString(2, last_name);
			ps.setString(3, email);
			ps.setString(4, account_number);
			ps.setString(5, password);
			ps.setString(6, country);
			ps.setString(7, state);
			ps.setString(8, city);
			ps.setString(9, sex);
			ps.setString(10, bank_name);
			int i=ps.executeUpdate();
			
			if(i>0)
			{
				
				RequestDispatcher rd = request.getRequestDispatcher("Home.html");
				 PrintWriter out = response.getWriter();
		         out.printf("<font color=red>Your Account is created successully</font>" + " " + first_name);
		         rd.include(request, response);
			}
			else
			{
				response.sendRedirect("Error.html");
			}
						}
			catch(Exception e)
			{
				e.printStackTrace();
			}
	}

}
