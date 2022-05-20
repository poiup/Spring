<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<style type="text/css">
	.uploadResult {
		width:100%;
		background-color: gray;
	}
	.uploadResult ul{
		display:flex;
		flex-flow:row;
		justify-content:center;
		align-items: center;
	}
	.uploadResult ul li {
		list-style: none;
		padding: 10;
	}
	.uploadResult ul li img {
		width: 20px;
	}
</style>
<script src="/resources/js/jquery.min.js"></script>
<script src="/resources/js/js.js"></script>
<title>Insert title here</title>
</head>
<body>
<form action="/Board/boardInsert" method="post">
	<div class="container">
		<input type="text" name="title" placeholder="제목">
		<div class="row">
			<input type="text" name="writer" placeholder="글쓴이">
		</div>
		<div class="row" style="height: 300px">
			<textarea rows="10" cols="40" name="content"></textarea>
		</div>
		<input type="submit">
		<input type="hidden" name="pageNum" value="${pageMaker.cri.pageNum}">
		<input type="hidden" name="searchType" value="${pageMaker.cri.searchType }">
		<input type="hidden" name="keyword" value="${pageMaker.cri.keyword }">
	</div>
</form>
<h3>첨부파일</h3>
<div class="uploadDiv">
		<input type="file" name="uploadFile" multiple>
	</div>
	<div class="uploadResult">
		<ul>
			<!-- 업로드 내역이 들어갈자리 -->
		</ul>
	</div>
	<button id="uploadBtn">Upload</button>
</body>
</html>