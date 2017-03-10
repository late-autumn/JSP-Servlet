<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%
    //pageContext Scope 속성 저장하기
    pageContext.setAttribute("pageAttribute", "홍길동");
    
    /* pageContext.setAttribute("pageAttribute",
    		"홍길동", PageContext.PAGE_SCOPE); */
    
    //request Scope에 속성 저장하기
    request.setAttribute("requestAttribute", "010-1234-1234");
    
    /* pageContext.setAttribute("pageAttribute",
    	    		"010-1234-1234", PageContext.REQUEST_SCOPE);
     */
    
     //session Scope에 속성 저장하기
     
     session.setAttribute("sessionAttribute", "acron@naver.com");
     
     /* pageContext.setAttribute("session Attribute",
	    		"acron@naver.com", PageContext.SESSION_SCOPE);
      */
     
     //application Scope에 속성 저장하기
     application.setAttribute("applicationAttribute", "Acron");
      
     /*  pageContext.setAttribute("application Attribute",
	    		"Acron", PageContext.APPLICATION_SCOPE);
      */     
          
    %>
    
    
    
    
<!DOCTYPE html>
<html>
<head>

<title></title>
</head>
<body>
<!--  request scope에 데이터를 저장해서 View 측으로 전달해줌 
   MVC 패턴 model에서 view 측으로 데이터를 넘겨줄때 사용함
-->

 <ul>
   <li> 이름 : <%=pageContext.getAttribute("pageAttribute") %></li>   
   <li> 전화번호 : <%=request.getAttribute("requestAttribute") %></li>   
   <li> 메일 :  <%=session.getAttribute("sessionAttribute") %></li>   
   <li> 회사정보 :<%=application.getAttribute("applicationAttribute") %></li>   
      
 </ul>

</body>
</html>