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
 * Servlet implementation class Transfer
 */
@WebServlet("/Transfer")
public class Transfer extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	String account_no1 = request.getParameter("account_no");
	String account_no2 = request.getParameter("account_no2");
	String amount = request.getParameter("amount");
	
	
	Connection connection = ConnectionProvider.getConn();
	
	try {
		PreparedStatement ps = connection.prepareStatement("update deposit_account set amount = amount - ?  where account_no = ? ");
		ps.setString(2, account_no1);
		ps.setString(2, account_no2);
		ps.setString(1, amount);
        int i=ps.executeUpdate();
	
	if(i>0)
	{
        PrintWriter out = response.getWriter();
		 out.print("You have successfully Transfer your amount");
		 
	}
	
	else{
		PrintWriter out = response.getWriter();
		out.print("Account Number is wrong");
	}
	
	}
	
	catch(Exception e)
	{
		e.printStackTrace();
	}

}
}