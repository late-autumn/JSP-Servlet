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
		out.print("장바구니 비웠음");
		//세션 객체 얻기
		HttpSession session =request.getSession(false);
		
		if(session != null){
			
			session.invalidate();
			//세션 즉시 제거
	
		}else {
			out.print("세션 없음"+"<br>");
		}
			
		
		out.print("<a href='productsession.html'>상품 선택페이지</a><br>");
		out.print("</body></html>");
		
	}

}
