package com.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Logout
 */
@WebServlet("/Logout")
public class Logout extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		 response.setContentType("text/html");
	      PrintWriter out = response.getWriter();
	      out.println("thanq you!!, Your Have been Logout successfully!!");
	      HttpSession session = request.getSession(false);
	      // session.setAttribute("user", null);
	      session.removeAttribute("user");
	      session.getMaxInactiveInterval();
		
	}

}
