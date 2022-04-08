<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
 
<title>Insert title here</title>
</head>
<body>
<form action="/boardInsert" method="post">
	<div class="container">
		<input type="text" name="title" placeholder="제목">
		<div class="row">
			<input type="text" name="writer" placeholder="글쓴이">
		</div>
		<div class="row" style="height: 300px">
			<textarea rows="10" cols="40" name="content"></textarea>
		</div>
		<input type="submit">
	</div>
</form>
</body>
</html>