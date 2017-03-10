package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CartBasketCookieServlet
 */
@WebServlet("/cookie/CartBasketCookie")
public class CartBasketCookieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CartBasketCookieServlet() {
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
		PrintWriter  out = response.getWriter();
		out.print("<html><body>");
		out.print("장바구니 리스트 <br>");
		
		Cookie cookies[] = request.getCookies();
		
		
		if(cookies != null){
			for(Cookie c : cookies){
				out.print(c.getName()+":"+c.getValue()+"<br>");
			}
		}else{
			out.println("basket emty<br>");
		}
		out.print("<a href = 'product.html'>상품 선택 페이지</a><br>");
		out.print("<a href = 'CartDeleteCookie'>list clean</a><br>");
		out.print("</body></html>");
	}

}
