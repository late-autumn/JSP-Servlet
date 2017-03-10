<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@page import = "java.sql.*, com.acorn.jdbc.*,java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
<link href="style.css" rel="stylesheet" type="text/css">
</head>
<body bgcolor="#FFFFCC">

<h2> JSP 데이터 베이스 </h2>

<h3>회원정보</h3>

<table bordercolor="#0000ff" border="1">
  <tr>
   <td><strong>ID</strong></td>
  <td><strong>PASSWD</strong></td>
  <td><strong>NAME</strong></td>
  <td><strong>MEM_NUM1</strong></td>
  <td><strong>MEM_NUM2</strong></td>
  <td><strong>E_MAIL</strong></td>
  <td><strong>PHONE</strong></td>
  <td><strong>ZIPCODE/ADDRESS</strong></td>
  <td><strong>JOB</strong></td>
  </tr>
<!-- 액션 태그 추가 
 -->

 <jsp:useBean id="dao" class = "com.acorn.jdbc.tempMemberDAO" scope = "page"></jsp:useBean>
 <%
 Vector<tempMemberVO> vlist = dao.getMemberList();
 int counter = vlist.size();
 
 for(int i = 0; i < vlist.size(); i++){
	 tempMemberVO vo = vlist.elementAt(i);
 %>
	
   <tr>
   <td><%=vo.getId() %></td>
    <td><%=vo.getPassword() %></td>
    <td><%=vo.getName() %></td>
    <td><%=vo.getMem_num1() %></td>
    <td><%=vo.getMem_num2() %></td>
    <td><%=vo.getEmail() %></td>
    <td><%=vo.getPhone() %></td>
    <td><%=vo.getZipcode() %>/<%=vo.getAddress() %></td>
    <td><%=vo.getJob() %></td>
 <%
  
	
   }//end if
 
 %>
   </tr> 	
 </table>
 <br><br>
 
 total records : <%= counter %>
 
</body>
</html>

