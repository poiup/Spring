<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<%@ taglib uri= "http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	all주소
	
	<sec:authorize access="isAnonymous()">
		<a href="/customLogin">
			로그인 페이지
		</a>
	</sec:authorize>
	
	<sec:authorize access="isAuthenticated()">
		<a href="/customLogout">
			로그아웃 페이지
		</a>
	</sec:authorize>
</body>
</html>