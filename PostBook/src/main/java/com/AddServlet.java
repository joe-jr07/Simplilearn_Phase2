package com;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Post;
import model.PostDAOImpl;



@WebServlet("/AddServlet")
public class AddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		
		Post post = new Post(0,request.getParameter("body"));
		
		PostDAOImpl postDAOImpl = new PostDAOImpl();
		try {
			postDAOImpl.initDatabase();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int res = postDAOImpl.addPost(post);
		
		if(res == 1) {
			out.print("Post was successfully added");
		}else {
			out.print("Post failed to be added");
		}
	}

}
