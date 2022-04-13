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
<!--
${pageMaker }
<nav aria-label="Page navigation example">
  <ul class="pagination justify-content-center">
    <li class="page-item ${pageMaker.prev == true ? '' : 'disabled' }">
      <a class="page-link" href="/boardList?pageNum=${pageMaker.startPage -1 }&searchType=${pageMaker.cri.searchType}&keyword=${pageMaker.cri.keyword}">&laquo;</a>
    </li>
    <c:forEach var="page" begin="${pageMaker.startPage }" end="${pageMaker.endPage }">
      <li class="page-item ${pageMaker.cri.pageNum == page ? 'active' : ''}">
   	    <a class="page-link" href="/boardList?pageNum=${page }&searchType=${pageMaker.cri.searchType}&keyword=${pageMaker.cri.keyword}">${page }</a>
      </li>
   </c:forEach>
   <li class="page-item ${pageMaker.next == true && pageMaker.endPage > 0 ? '' : 'disabled' }">
     <a class="page-link" href="/boardList?pageNum=${pageMaker.endPage +1 }&searchType=${pageMaker.cri.searchType}&keyword=${pageMaker.cri.keyword}">&raquo;</a>
   </li>
  </ul>
</nav> 
<div class="row">
	<form action="/boardList" method="get">
		<select name="searchType">
			<option value="n">--</option>
			<option value="t" ${pageMaker.cri.searchType eq 't' ? 'selected' : '' }>제목</option>
			<option value="c" ${pageMaker.cri.searchType eq 'c' ? 'selected' : '' }>본문</option>
			<option value="w" ${pageMaker.cri.searchType eq 'w' ? 'selected' : '' }>글쓴이</option>
			<option value="tc" ${pageMaker.cri.searchType eq 'tc' ? 'selected' : '' }>제목+본문</option>
			<option value="cw" ${pageMaker.cri.searchType eq 'cw' ? 'selected' : '' }>본문+글쓴이</option>
			<option value="twc" ${pageMaker.cri.searchType eq 'twc' ? 'selected' : '' }>전체</option>
		</select>
		${sessionScope.sessionCri.keyword }
		<input type="text" name="keyword" placeholder="검색어"  value="${pageMaker.cri.keyword }">
		<input type="submit" value="검색하기">
	</form>
</div>
 -->
 <nav aria-label="Page navigation example">
  <ul class="pagination justify-content-center">
    <li class="page-item ${pageMaker.prev == true ? '' : 'disabled' }">
      <a class="page-link" href="/boardList?pageNum=${pageMaker.startPage -1 }&searchType=${sessionScope.sessionCri.searchType}&keyword=${sessionScope.sessionCri.keyword }">&laquo;</a>
    </li>
    <c:forEach var="page" begin="${pageMaker.startPage }" end="${pageMaker.endPage }">
      <li class="page-item ${pageMaker.cri.pageNum == page ? 'active' : ''}">
   	    <a class="page-link" href="/boardList?pageNum=${page }&searchType=${sessionScope.sessionCri.searchType}&keyword=${sessionScope.sessionCri.keyword }">${page }</a>
      </li>
   </c:forEach>
   <li class="page-item ${pageMaker.next == true && pageMaker.endPage > 0 ? '' : 'disabled' }">
     <a class="page-link" href="/boardList?pageNum=${pageMaker.endPage +1 }&searchType=${sessionScope.sessionCri.searchType}&keyword=${sessionScope.sessionCri.keyword }">&raquo;</a>
   </li>
  </ul>
</nav>
 <div class="row">
	<form action="/boardList" method="get">
		<select name="searchType">
			<option value="n">--</option>
			<option value="t" ${sessionScope.sessionCri.searchType eq 't' ? 'selected' : '' }>제목</option>
			<option value="c" ${sessionScope.sessionCri.searchType eq 'c' ? 'selected' : '' }>본문</option>
			<option value="w" ${sessionScope.sessionCri.searchType eq 'w' ? 'selected' : '' }>글쓴이</option>
			<option value="tc" ${sessionScope.sessionCri.searchType eq 'tc' ? 'selected' : '' }>제목+본문</option>
			<option value="cw" ${sessionScope.sessionCri.searchType eq 'cw' ? 'selected' : '' }>본문+글쓴이</option>
			<option value="twc" ${sessionScope.sessionCri.searchType eq 'twc' ? 'selected' : '' }>전체</option>
		</select>

		<input type="text" name="keyword" placeholder="검색어"  value="${sessionScope.sessionCri.keyword }">
		<input type="submit" value="검색하기">
	</form>
</div>
</body>
</html>