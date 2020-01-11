package com.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.servlet.RequestDispatcher;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Deposit_Account
 */
@WebServlet("/Deposit_Account")
public class Deposit_Account extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String account_number = request.getParameter("account_no");
		String amount = request.getParameter("amount");
		Connection connection = ConnectionProvider.getConn();
		try
		{
			PreparedStatement ps = connection.prepareStatement("insert into deposit_account values(?,?)");
			ps.setString(1,account_number);
			ps.setString(2,amount);
			int i=ps.executeUpdate();
			if(i>0)
			{
				RequestDispatcher rd = request.getRequestDispatcher("Deposit_Account.html");
				PrintWriter out = response.getWriter();
			    out.printf("<font color=red>Congratulation, you have successfully Deposit </font>");
			    rd.include(request, response);
			}	
				
	        else
			{
	        	PrintWriter out = response.getWriter();
		        out.printf("<font color=red>Congratulation, you have successfully Depost</font>");
				
			}
			}
		
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
