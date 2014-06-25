package com.farmfinder.servlets;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name="LoginServlet", urlPatterns="/login")
public class loginServlet extends HttpServlet{
	public void doPost(HttpServletRequest request, HttpServletResponse response){
		String username = request.getParameter("username") ;
		String password = request.getParameter ("password") ;

	}
	
}
