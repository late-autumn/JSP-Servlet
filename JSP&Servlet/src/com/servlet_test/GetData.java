package com.servlet_test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class GetData
 */
@WebServlet("/GetData")
public class GetData extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		String Name = new String(request.getParameter("name"));
		String Addr = new String(request.getParameter("address"));
		
		out.println("<html>");
		out.println("<head><title>Get Data</title></head>");
		
		out.println("<body>");
		if(!(Name.equals("")&&Addr.equals(""))){
			out.println("여기는 Ex01.jsp에서 넘어와 매칭된 다음 페이지인 GetData");
			out.println("<li>입력하신 이름:"+Name);
			out.println("<li>입력하신 주소:"+Addr);
		}
			
		out.println("</body>");
		out.println("</html>");
				
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
