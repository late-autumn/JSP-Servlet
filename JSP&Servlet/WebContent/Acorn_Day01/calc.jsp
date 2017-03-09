<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

<title>두수의 합 계산</title>
</head>
<body>

<form name="form1" action="/Calc" method="post">

<input type="text" name="num1" width="200" size="5">

<select name="operator">
   <option selected="selected">+</option>
   <option>-</option>
   <option>*</option>
   <option>/</option>
</select>

<input type="text" name="num2" width="200" size="5"><br>

<input type="submit" value="계산" name="b1">
<input type="reset" value="다시입력" name="b2">


</form>

</body>
</html>