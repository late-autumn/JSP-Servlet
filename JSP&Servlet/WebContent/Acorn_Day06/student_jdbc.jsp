<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.PreparedStatement"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.sql.Connection" %>
    <%@ page import="javax.sql.DataSource" %>
    <%@ page import="javax.naming.InitialContext" %>
     <%@ page import="javax.naming.Context" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>student table data insert</h2>

<%
Connection con = null;
PreparedStatement pstmt = null;
Statement stmt = null;
ResultSet result = null;

StringBuffer sql = new StringBuffer("insert into student(no, sd_num, sd_name, sd_id, sd_password, s_num, sd_jumin, sd_phone, sd_address, sd_email, sd_date) ");
sql.append("values(student_seq.nextval, ?,?,?,?,?,?,?,?,?, sysdate)");

String name = "hong";

try{
	InitialContext context = new InitialContext();
	DataSource ds = (DataSource)context.lookup("java:comp/env/jdbc/mydb");
	con = ds.getConnection();
	pstmt = con.prepareStatement(sql.toString());
	//추가할 학생 데이터 입력
	pstmt.setString(1, "90030001");
	pstmt.setString(2, name);
	pstmt.setString(3,"dbcp");
	pstmt.setString(4, "dbcp1234");
	pstmt.setString(5, "03");
	pstmt.setString(6, "123456-1234567");
	pstmt.setString(7, ".01012341234");
	pstmt.setString(8, "서울시 영등포구 당산동");
	pstmt.setString(9, "dbcp@hanmail.net");
	
	int rowCount = pstmt.executeUpdate();
	if(rowCount == 1){
		out.println("<hr>학생 ["+name+"] recode one insert<hr>");
	}else{
		out.println("학생 레코드 추가에 문제가 있습니다. ");
	}
	//다시 조회
	stmt = con.createStatement();
	result = stmt.executeQuery("select sd_num, sd_name, sd_id, sd_password, s_num, sd_jumin, sd_phone, sd_address, sd_email, sd_date from student");
	%>
	
	<table width = "100%" border="2" cellpadding = "1">
	
	<tbody align = "center">
		<tr>
			<td>학번</td>
			<td>이름</td>
			<td>아이디</td>
			<td>비밀번호</td>
			<td>학과번호</td>
			<td>주민번호</td>
			<td>전화번호</td>
			<td>주소</td>
			<td>이메일</td>
			<td>등록일자</td>
		</tr>
		<%
		while(result.next()){
			%>
		<tr>
			<td><%=result.getInt("sd_num") %></td>
			<td><%=result.getString("sd_name") %></td>
			<td><%=result.getString("sd_id") %></td>
			<td><%=result.getString("sd_password") %></td>
			<td><%=result.getString("sd_num") %></td>
			<td><%=result.getString("sd_jumin") %></td>
			<td><%=result.getString("sd_phone") %></td>
			<td><%=result.getString("sd_address") %></td>
			<td><%=result.getString("sd_email") %></td>
			<td><%=result.getDate("sd_date") %></td>
				
		</tr>
		<%
		}
}catch(Exception e){
	out.println("student 테이블에 추가 및 조회에 문제가 발생했습니다.");
	out.println(e.toString());
	e.printStackTrace();
	}
finally{
	if(result != null){
		result.close();
	}if(pstmt != null){
		pstmt.close();
	}
	if(stmt != null){
		stmt.close();
	}
	if(con != null){
		con.close();
	}
}
	%>
	</tbody>
	
	</table>
	

</body>
</html>