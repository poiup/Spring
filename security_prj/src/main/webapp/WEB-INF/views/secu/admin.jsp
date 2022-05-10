<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri ="http://www.springframework.org/security/tags" prefix="sec" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	admin주소
	<h2>다양한 페이지 정보</h2>
	
	<p>principal : <sec:authentication property="principal"/></p>
	<p>memberVO : <sec:authentication property="principal.member"/></p>
	<p>사용자 이름 : <sec:authentication property="principal.member.userName"/></p>
	<p>사용자의 아이디 : <sec:authentication property="principal.member.userid"/></p>
	<p>사용자 권한목록 : <sec:authentication property="principal.member.authList"/></p>
	
	
	<a href="/customLogout">
	로그아웃 페이지
	</a>
</body>
</html>