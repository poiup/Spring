<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	${array }
	<%-- 위 array를 
	c:forEach로 나열해주세요 --%>
	<c:forEach var="arr" items="${array }">
		${arr }
	</c:forEach>
	
</body>
</html>