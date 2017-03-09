<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title></title>
</head>
<body>

<form method="get" action="/GetData">
	이름 : <input type="text" size="20" maxlength="20" name="name">
	주소 : <input type="text" size="20" maxlength="20" name="address">	
	
	<input type="submit" value="전송">&nbsp;&nbsp;
	<input type="reset" value="취소">
</form>

</body>
</html>