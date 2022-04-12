<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- CSS only -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body>
<table class="table">
  <thead>
    <tr>
      <th scope="col-1">글번호</th>
      <th scope="col-6">제목</th>
      <th scope="col-1">글쓴이</th>
      <th scope="col-2">작성일</th>
      <th scope="col-2">수정일</th>
    </tr>
  </thead>
  <tbody>
    <c:forEach var="list" items="${boardList }">
	     <tr>
			 <th scope="row">${list.bno }</th>
	     	 <td><a href="/boardDetail/${list.bno }">${list.title }</a></td>
			 <td>${list.writer }</td>
			 <td>${list.regdate }</td>
			 <td>${list.updatedate }</td>
		</tr>
    </c:forEach>
  </tbody>
</table>
<button><a href="/boardInsert">글쓰기</a></button>
${pageMaker }
<nav aria-label="Page navigation example">
  <ul class="pagination justify-content-center">
    <li class="page-item ${pageMaker.prev == true ? '' : 'disabled' }">
      <a class="page-link" href="/boardList?pageNum=${pageMaker.startPage -1 }">&laquo;</a>
    </li>
    <c:forEach var="page" begin="${pageMaker.startPage }" end="${pageMaker.endPage }">
      <li class="page-item ${pageMaker.cri.pageNum == page ? 'active' : ''}">
   	    <a class="page-link" href="/boardList?pageNum=${page }">${page }</a>
      </li>
   </c:forEach>
   <li class="page-item ${pageMaker.next == true && pageMaker.endPage > 0 ? '' : 'disabled' }">
     <a class="page-link" href="/boardList?pageNum=${pageMaker.endPage +1 }">&raquo;</a>
   </li>
  </ul>
</nav>
</body>
</html>