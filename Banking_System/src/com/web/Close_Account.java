package com.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class delete_account
 */
@WebServlet("/Close_Accountt")
public class Close_Account extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String account_number = request.getParameter("account_no");
		String password = request.getParameter("password");
		Connection connection = ConnectionProvider.getConn();
		try
		{
			PreparedStatement ps = connection.prepareStatement("delete from user_data where account_no=? and password=?");
			ps.setString(1,account_number);
			ps.setString(2,password);
			int i=ps.executeUpdate();
			if(i!=0)
			{
				PrintWriter out = response.getWriter();
				out.print("Deleted Account Successfully");
			}
			
			else if(i==0)
			{
				response.sendRedirect("error.html");
			}
			}
		
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}

}
