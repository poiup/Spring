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
	member주소
	<a href="/customLogout">
	로그아웃 페이지
	</a>
	
	<sec:authorize access="hasRole('ROLE_ADMIN')">
		<a href="/secu/admin">관리자페이지로 이동</a>
	</sec:authorize>
</body>
</html>