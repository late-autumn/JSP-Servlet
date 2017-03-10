<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
  
  <%
     int bufferSize = out.getBufferSize();
      //버퍼의 크기를 구함
     int remainSize = out.getRemaining();
      //현재 버퍼에서 남은 크기를 구함
     int usedSize = bufferSize - remainSize;
      // 사용하고 남은 버퍼의 크기를 구함
    
  %>  
    
    
<!DOCTYPE html>
<html>
<head>

<title></title>
</head>
<body>

 버퍼의 전체크기 : <%=bufferSize %><br><br>
 
 사용한 버퍼크기: <%=usedSize %><br><br>
 
 남은 버퍼 : <% out.println(remainSize); %>byte<br><br>

  

</body>
</html>






