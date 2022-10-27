package com;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/SeeCookieServlet")
public class SeeCookieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		
		out.print("<h1>Reading all cookies</h1>");
		
		Cookie[] cookies = request.getCookies();
		
		if(cookies != null && cookies.length>0) {
			for(Cookie cookie:cookies)
				out.print("<h3>"+ cookie.getName()+ ":"+ cookie.getValue()+"</h3>");
		}
	}

}