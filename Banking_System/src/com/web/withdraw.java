package com.web;

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

/**
 * Servlet implementation class withdraw
 */
@WebServlet("/withdraw")
public class withdraw extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String account_no = request.getParameter("account_no");
		String amount = request.getParameter("amount");
		Connection connection = ConnectionProvider.getConn();
		
		try {
			PreparedStatement ps = connection.prepareStatement("update deposit_account set amount = amount - ? where account_no = ? ");
			ps.setString(2, account_no);
			ps.setString(1, amount);
            int i=ps.executeUpdate();
			
			if(i>0)
			{
				RequestDispatcher rd = request.getRequestDispatcher("withdraw.html");
                PrintWriter out = response.getWriter();
				 out.print("You have successfully withdrawn your amount");
				 rd.include(request, response);
			}
			
			else{
				PrintWriter out = response.getWriter();
				out.print("Account Number is wrong");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
