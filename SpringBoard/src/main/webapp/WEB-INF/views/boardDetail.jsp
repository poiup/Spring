<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 
<!DOCTYPE html>
<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<meta charset="UTF-8">
<title>Insert title here</title>
   
</head>
<body>
	<div class="container">
		<h1 class="text text-primary">${board.title }</h1>
		<div class="row">
			<div class="col" style="height: 50px">${board.writer }</div>
		</div>
		<div class="row" style="height: 300px">
			<div>${board.content }</div>
		</div>
		<div class="row">
			<div class="col-6">${board.regdate}</div>
			<div class="col-6">${board.updatedate }</div>
		</div>
		<button><a href="/boardList?pageNum=${param.pageNum }&searchType=${param.searchType}&keyword=${param.keyword}">글목록</a></button>
		<form action="/boardUpdateForm" method="post">
			<input type="hidden" name="bno" value="${board.bno }">
			<input type="submit" value="수정">
		</form>
		<form action="/boardDelete" method="post">
			<input type="hidden" name="bno" value="${board.bno }">
			<input type="submit" value="삭제">
		</form>
		${param.pageNum }
	</div>
</body>
</html>