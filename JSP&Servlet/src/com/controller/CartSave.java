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
 * Servlet implementation class CartSaveServlet
 */
@WebServlet("/session/CartSave")
public class CartSave extends HttpServlet {
	private static final long serialVersionUID = 1L;

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
		
		
		//�Է� �Ķ���� ���
		String product = request.getParameter("product");		
		
		//���� ��ü ���
		HttpSession session = request.getSession();
		ArrayList<String> list = (ArrayList<String>)session.getAttribute("product");
		
		if(list == null){
			list = new ArrayList<String>();
			list.add(product);
			session.setAttribute("product", list);
			
			
		}else {
			list.add(product);
		}
		
		out.print("<html><body>");
		
		out.print("Product �߰�");
		out.print("<a href='CartBasket'>��ٱ��� ����</a>");
		
		out.println("</body></html>");
	}

}
