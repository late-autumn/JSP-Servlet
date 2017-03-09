<%@page import="day09.java.MemberDTO_03"%>
<%@page import="java.util.ArrayList"%>
<%@page import="day09.java.MemberDAO_03"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>

	<%
		MemberDAO_03 memberDAO = new MemberDAO_03();
		ArrayList<MemberDTO_03> dtos = memberDAO.memberSelect();

		for (int i = 0; i < dtos.size(); i++) {
			MemberDTO_03 dto = dtos.get(i);
			String name = dto.getName();
			String id = dto.getId();
			String pw = dto.getPw();
			String phone = dto.getPhone1() + " - " + dto.getPhone2() + " - " + dto.getPhone3();
			String gender = dto.getGender();

			out.println("이름 : " + name + ", 아이디 : " + id + ", 비밀번호 : " + pw + ", 연락처 : " + phone + ",  성별 : "
					+ gender + "<br />");
		}
	%>

</body>
</html>