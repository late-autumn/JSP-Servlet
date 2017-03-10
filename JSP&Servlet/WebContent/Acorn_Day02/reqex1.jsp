<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

<title></title>
</head>
<body>

클라이 언트 IP : <%= request.getRemoteAddr() %><br><br>
<!-- 클라이언트의 정보 -->
요청정보 길이  :<%=request.getContentLength() %><br><br>
<!--  클라이언트가 요청한 정보의 길이  -->
요청정보 인코딩 : <%=request.getCharacterEncoding() %><br><br> 

요청정보 컨텐트 타입 : <%=request.getContentType() %><br><br> 
요청정보 프로토콜 : <%=request.getProtocol() %><br><br> 
요청정보 전송 방식 : <%= request.getMethod() %><br><br> 
요청 URL : <%= request.getRequestURL() %><br><br> 
요청 URI : <%= request.getRequestURI() %><br><br> 

컨텍스트 경로 :<%=request.getContextPath() %><br><br> 
서버 이름 : <%=request.getServerName() %><br><br> 
서버 포트 : <%=request.getServerPort() %><br><br> 

</body>
</html>