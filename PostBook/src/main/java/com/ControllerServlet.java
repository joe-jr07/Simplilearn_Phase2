package com;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/ControllerServlet")
public class ControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String login = request.getParameter("login");
		
		switch(login) {
		case "signin":{
			RequestDispatcher rd1 = request.getRequestDispatcher("SignInServlet");
			rd1.forward(request, response);
		}
		case "signup":{
			RequestDispatcher rd1 = request.getRequestDispatcher("SignUpServlet");
			rd1.forward(request, response);
		}
		}
	}

}
