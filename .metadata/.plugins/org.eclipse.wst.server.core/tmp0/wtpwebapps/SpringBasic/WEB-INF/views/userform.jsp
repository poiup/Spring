<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="/userInfo" method="post">
		<input type="number" name="userNum" placeholder="유저번호">
		<input type="text" name="userId" placeholder="유저아이디">
		<input type="password" name="userPw" placeholder="유저비밀번호">
		<input type="text" name="userName" placeholder="유저이름">
		<input type="number" name="userAge" placeholder="유저나이">
		<input type="submit">
	</form>
</body>
</html>