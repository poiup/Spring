<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body>
<form action="/boardUpdate" method="post">
	<div class="container">
		제목 : <input type="text" name="title" placeholder="제목" value="${board.title }">
		<div class="row">
			<p>글쓴이 : ${board.writer }</p>
		</div>
		<div class="row" style="height: 300px">
		본문 내용 : <br>
			<textarea rows="10" cols="40" name="content">${board.content }</textarea>
		</div>
		<input type="hidden" value="${board.bno }" name="bno">
		<input type="hidden" name="pageNum" value="${param.pageNum }">
		<input type="hidden" name="searchType" value="${param.searchType }">
		<input type="hidden" name="keyword" value="${param.keyword }">
		<input type="submit">
	</div>
</form>
</body>
</html>