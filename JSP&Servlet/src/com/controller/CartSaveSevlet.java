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
 * Servlet implementation class CartSaveSevlet
 */
@WebServlet("/CartSave")
public class CartSaveSevlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CartSaveSevlet() {
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
		
		response.setContentType("text/html;charst=utf-8");
		PrintWriter out = response.getWriter();
		
		String product = request.getParameter("product");
		//입력 파라미터 얻기
		HttpSession session = request.getSession();
		//세션 객체 얻기
		ArrayList<String> list = (ArrayList<String>)session.getAttribute("product");
		
		if(list == null){
			list = new ArrayList<String>();
			list.add(product);
			session.setAttribute("product", list);
			
		}else{
			list.add(product);
		}
		out.println("<html><body>");
		out.print("product add");
		out.print("<a href = 'CarBasket'> show chart</a>");
		out.println("</body></html>");
	}
}
