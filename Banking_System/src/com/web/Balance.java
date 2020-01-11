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
import javax.servlet.http.HttpSession;

import com.mysql.jdbc.ResultSetMetaData;
import com.mysql.jdbc.Statement;

/**
 * Servlet implementation class Balance
 */
@WebServlet("/Balance")
public class Balance extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String account_no = request.getParameter("account_no");
		try{
			Connection connection = ConnectionProvider.getConn();
			
			PreparedStatement ps = connection.prepareStatement("select account_no , sum(amount) as TOTAL_BALANCE from deposit_account where account_no = ? ");
			ps.setString(1,account_no);
			out.print("<table width=50% height=20% cellpadding=10 border = 1 align = center bgcolor=yellow>");
			out.printf("<center><h1>BALANCE OF ACCOUNT NUMBER" + " " + "<font color=red>" + account_no + "</font></h1></center><hr>");
			ResultSet rs = ps.executeQuery();
			ResultSetMetaData rsmd = (ResultSetMetaData) rs.getMetaData();
			while(rs.next())
			{
				
				out.print("<tr>");
				out.print("<td>" + rsmd.getColumnName(1) + "</td>");
				out.print("<td>" + rs.getString(1) + "</td></tr>");
				
				out.print("<tr>");
				out.print("<td>" + rsmd.getColumnName(2) + "</td>");
				out.print("<td>" + rs.getString(2) + "</td></tr>");
				
			}
			out.print("</table>");
			
			
		}
		catch(Exception e2){
			e2.printStackTrace();
		}
		
		finally{
			out.close();
		}
	}

}
