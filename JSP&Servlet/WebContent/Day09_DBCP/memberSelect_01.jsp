<%@page import="day09.java.MemberDTO_01"%>
<%@page import="java.util.ArrayList"%>
<%@page import="day09.java.MemberDAO_01"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="EUC-KR"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%
		MemberDAO_01 memberDAO = new MemberDAO_01();
		ArrayList<MemberDTO_01> dtos = memberDAO.memberSelect();
		
		for(int i=0; i<dtos.size(); i++) {
			MemberDTO_01 dto = dtos.get(i);
			String name = dto.getName();
			String id = dto.getId();
			String pw = dto.getPw();
			String phone = dto.getPhone1() + " - "+ dto.getPhone2() + " - " + dto.getPhone3();
			String gender = dto.getGender();
			
			out.println("�̸� : " + name + ", ���̵� : " + id + ", ��й�ȣ : " + pw + ", ����ó : " + phone + ",  ���� : " + gender + "<br />" );
		}
		
	%>

</body>
</html>