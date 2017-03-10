package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class CartBasketSevlet
 */
@WebServlet("/session/CartBasket")
public class CartBasketSevlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CartBasketSevlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print("<html><body>");
		out.print("cart list");
		//get session object
		HttpSession session = request.getSession();
		session.setMaxInactiveInterval(200);
		
		if(session != null){
			ArrayList<String> list = (ArrayList<String>)session.getAttribute("product");
			out.print("product : "+list+"<br>");
		}else{
			out.println("no session"+"<br>");
		}
		out.print("<a href = 'productsession.html'>select product</a><br> ");
		out.print("<a href = 'CartDelete'> clean cart </a><br>");
		out.print("</body></html>");
	}

}
