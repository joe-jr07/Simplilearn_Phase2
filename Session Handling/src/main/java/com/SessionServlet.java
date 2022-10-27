package com;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/SessionServlet")
public class SessionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		String name = request.getParameter("name");
		out.print("<h1>Name="+ name + "</h1>" );
		
		HttpSession session = request.getSession();
		if(name != null && name.length()>0)
			session.setAttribute("name", name);
		
		out.print("SessionId =" + session.getId());
		out.print("<h1>SessionName="+ session.getAttribute("name") + "</h1>" );
	}

}
