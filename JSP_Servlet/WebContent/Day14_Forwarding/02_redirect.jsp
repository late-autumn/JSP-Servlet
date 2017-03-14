<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%><html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
			실행은 딱히 안된다. 아마 위에 디스패처 때문일지도... 중요한건
			sendredirect를 통해서 다시 클라이언트를 거쳐서 요청 되기때문에 null값이 나온다.
		<%
			request.setAttribute("id", "abcde");
			request.setAttribute("pw", "12345");
			
			response.sendRedirect("RequestObj_01");
		%>

</body>
</html>