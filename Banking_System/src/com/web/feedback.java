package com.web;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class feedback
 */
@WebServlet("/feedback")
public class feedback extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String email = request.getParameter("email");
		String query = request.getParameter("query");
		Connection connection = ConnectionProvider.getConn();
		
		
		try {
			PreparedStatement ps = connection.prepareStatement("insert into feedback values(?,?)");
		ps.setString(1, email);
		ps.setString(2, query);
		int i=ps.executeUpdate();
		
		if(i>0)
		{
		RequestDispatcher rd = request.getRequestDispatcher("Home.html");
		 PrintWriter out = response.getWriter();
        out.printf("<font color=red>Thanks for your feedback</font>");
        rd.include(request, response);
		}
		else
		{
			response.sendRedirect("error.html");
		}
					}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
