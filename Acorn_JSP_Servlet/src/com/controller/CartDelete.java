package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class CartDelete
 */
@WebServlet("/session/CartDelete")
public class CartDelete extends HttpServlet {
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
		
		
		out.print("<html><body>");
		out.print("��ٱ��� �����");
		//���� ��ü ���
		HttpSession session =request.getSession(false);
		
		if(session != null){
			
			session.invalidate();
			//���� ��� ����
	
		}else {
			out.print("���� ����"+"<br>");
		}
			
		
		out.print("<a href='productsession.html'>��ǰ ����������</a><br>");
		out.print("</body></html>");
		
	}

}
