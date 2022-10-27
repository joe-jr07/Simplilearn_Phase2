package com;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/CurrencyServlet")
public class CurrencyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		
		double rupees = Double.parseDouble(request.getParameter("rupees"));
		double money = 0;
		String currency = request.getParameter("currency");
		
		switch(currency) {
		case "dollar":{
			money = rupees/82;
			break;
		}
		case "euro":{
			money = rupees/83;
			break;
		}
		default:
			out.print("<h1>Invalid input</h1>");
		}
		
		double money1 = Math.round(money*100.0)/100.0;
		
		out.print("<h1> The" + currency + " value for "+rupees+" rupees is "+money1+"</h1>");
		
	}

}
