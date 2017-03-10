package day01.java;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class JspServletEx02
 */
@WebServlet("/Calc")
public class JspServletEx02 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doPost(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//변수 선언
		int num1, num2;
		int result;
		
		String op;		//연산자
		
		//한글 인코딩(클라이언트 응답시 전달될 콘텐츠에 대한 캐릭터 셋 지정)
		response.setContentType("text/html; charset=UTF-8");

		//클라이언트로 응답을 위한 출력 스트림
		PrintWriter out = response.getWriter();
		
		//jsp 폼을 통해 전달된 num1, num2 파라미터 값을 변수에 할당한다.
		//변수에 할당받을 때 getParameter()메소드를 이용하여 리턴한다.
		//숫자 데이터의 경우 Integer.parseInt()를 통해서 int 형으로 반환함
		
		num1 = Integer.parseInt(request.getParameter("num1"));
		num2 = Integer.parseInt(request.getParameter("num2"));
		op = request.getParameter("operator");
		
	      //calc() 메서드 호출해서 결과값을 얻어옴
	      result = Calc(num1, num2, op);
	      
	      //출력 스트림을 통해서 화면 구현
	      out.println("<html>");
	      out.println("<body>");
	      
	      out.println("<center>");
	      
	      out.println("<h2> 계산결과 </h2>");
	      out.println(num1+" "+op+" "+num2+"="+result);
	      
	      out.println("</center>");
	      
	      out.println("</body>");
	      out.println("</html>");
		
	}
	public int Calc(int num1, int num2, String op){
		
		int result =0;
		
		if(op.equals("+")){
			result = num1+num2;
		}
		else if(op.equals("-")){
			result = num1-num2;
		}
		else if(op.equals("*")){
			result = num1*num2;
		}
		else if(op.equals("/")){
			result = num1/num2;
		}
		
		return result;
	}

}
