<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="/score" method="post">
		<input type="number" name="meth" placeholder="수학"><br>
		<input type="number" name="eng" placeholder="영어"><br>
		<input type="number" name="lang" placeholder="언어"><br>
		<input type="number" name="soc" placeholder="사탐"><br>
		<input type="number" name="com" placeholder="컴퓨터"><br>
		<input type="submit">
	</form>
</body>
</html>