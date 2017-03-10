package day01.java;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * Servlet implementation class JspServletEx03
 */
//@WebServlet("/JspServletEx03/Insert")
public class JspServletEx03 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException{
		
		request.setCharacterEncoding("UTF-8");
		
		//클라이언트가 http요청으로 전송한값 읽기
		String writer = request.getParameter("writer");
		String memo = request.getParameter("memo");
		
		StringBuffer sql = new StringBuffer();
		sql.append("insert into visit(no,writer,memo,regdate) ");
		sql.append("values(visit_seq.nextval,?,?,sysdate)");
		
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try{
	         Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:orcl",
					"scott","tiger");
			
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(1, writer);
			pstmt.setString(2, memo);
			
			pstmt.executeUpdate();
		}catch(SQLException se){
			se.printStackTrace();
		}catch(ClassNotFoundException cn){
			cn.printStackTrace();
		}
		finally{
			try{
				if(pstmt!=null)pstmt.close();
			}catch(SQLException se){
				se.printStackTrace();
			}
			
		}
		
		response.sendRedirect("/JSP_Servelt/JspServletEx03_visitList");
		
		
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		processRequest(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		processRequest(request, response);
	}

}
