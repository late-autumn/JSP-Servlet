package day01.java;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class JspServletEx01
 */
@WebServlet(name="jsp01", urlPatterns={"/jspex","/xxx","/yyy","/zzz"})
public class JspServletEx01 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html; charset=UTF-8");		//한글 깨짐 방지 
		PrintWriter out = response.getWriter();
		out.println("<html><head><title>서블릿 </title></head>");
		out.println("<body>");
		
		out.println("<h1>안녕하세요 여러분</h1>");
		
		out.println("</body>");
		out.println("</html>");
		
		System.out.println("여기는 서블릿 부분");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
