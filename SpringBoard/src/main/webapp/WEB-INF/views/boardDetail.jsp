<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 
<!DOCTYPE html>
<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<meta charset="UTF-8">
<title>Insert title here</title>
 <style type="text/css">
 	* {text-decoration:none;
 		list-style:none;}
	#modDiv {
		width:300px;
		height:100px;
		background-color: green;
		position:absolute;
		top : 50%;
		left : 50%;
		transform: translate(-30%, -50%);
	}
 </style>  
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
		<button><a href="/Board/boardList?pageNum=${param.pageNum == null ? 1 : param.pageNum }&searchType=${param.searchType}&keyword=${param.keyword}">글목록</a></button>
		<form action="/Board/boardUpdateForm" method="post">
			<input type="hidden" name="bno" value="${board.bno }">
			<input type="hidden" name="pageNum" value="${param.pageNum }">
			<input type="hidden" name="searchType" value="${param.searchType }">
			<input type="hidden" name="keyword" value="${param.keyword }">
			<input type="submit" value="수정">
		</form>
		<form action="/Board/boardDelete" method="post">
			<input type="hidden" name="bno" value="${board.bno }">
			<input type="hidden" name="pageNum" value="${param.pageNum }">
			<input type="hidden" name="searchType" value="${param.searchType }">
			<input type="hidden" name="keyword" value="${param.keyword }">
			<input type="submit" value="삭제">
		</form>
		<div class="row">
			<ul id="replies">
			</ul>
		</div>
		<button onclick="getAllList()">댓글 불러오기</button>
		<div class="row box-box-success">
			<div class="box-header">
				<h2 class="text-primary"></h2>
				<div class="box-body">
					<strong>글쓴이</strong>
					 <input type="text" name="replyer" id="newReplyWriter">
					<strong>댓글내용</strong>
					<input type="text" name="reply" id="newReply">
				</div>
				<div class="footer">
					<button id="replyAddBtn" onclick="addReply()">ADD REPLY</button>
				</div>
			</div>
		</div>
	</div>
	
	<!-- modal은 일종의 팝업입니다.
	단 새창을 띄우지 않고 css를 이용해 특정 태그가 조건부로  보이거나 안보이도록 처리해서 마치 새로 창이
	띄워지는것처럼 만듭니다.
	따라서 눈에 보이지않아도 modal을 구성하는 태그 차제는 미리 적혀있어야 합니다.-->
	
	<div id="modDiv" style="display:none">
		<div class="modal-title"></div>
		<div>
			<input type="text" id="reply"/>
		</div>
		<div>
			<button type="button" id="replyModBtn">Modify</button>
			<button type="button" id="replyDelBtn">Delete</button>
			<button type="button" id="closeBtn">Close</button>
		</div>
	</div>
	
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
	<script>
	var bno = ${board.bno};
	function getAllList(){
	$.getJSON("/replies/all/" + bno, function(data){
		var str = "";		
		/*
		$(data).each(function(){
					str += "<li data-rno='" + this.rno + "' class='replyLi'><span>"
						+ this.replyer + "</span> :  <span class='newreply'>" + this.reply
						+ "</span><button>수정/삭제</button><li>";
					}); 
		*/
		$(data).each(function(){
			var timestamp = this.updateDate;
			var date = new Date(timestamp);
			
			var formattedTime = "게시일" + date.getFullYear()
								+ "/" + (date.getMonth()+1)
								+ "/" + date.getDate()
								+ "/" + date.getSeconds();
								
			str += "<div class = 'replyLi' data-rno='"+this.rno + "'><strong>@"
				+ this.replyer + "</strong> - " + formattedTime + "<br>"
				+ "<div class='reply'>" + this.reply + "</div>"
				+ "<button type='button' class='btn btn-info'>수정/삭제</button>"
				+ "</div>";
		});
				$("#replies").html(str);
			});
		}
		
		function addReply(){
			var reply = $("#newReply").val();
			var replyer = $("#newReplyWriter").val();
			$.ajax({
				type : 'post',
				url : '/replies',
				headers : {
					"Content-Type" : "application/json",
					"X-HTTP-Method-Override" : "POST"
				},
				dataType : 'text',
				data : JSON.stringify({
					bno : bno,
					reply : reply,
					replyer : replyer
				}),
				success : function(result){
					getAllList();
					alert("등록되었습니다.");
					// 글적으면 내부 내용 비우기
					$("#newReply").val("");
					$("#newReplyWriter").val("");
				}
			})
		}
		
		function replyDelete(){
			var rno = $(".modal-title").html();
			$.ajax({
				type : 'delete',
				url : '/replies/' + rno,
				headers : {
					"Context-Type" : "application/json",
					"X-HTTP-Method-Override" : "DELETE"
				},
				dataType : 'text',
				success : function(){
					alert("삭제되었습니다");
					$("#modDiv").hide();
					getAllList();
				}
			})
		}
		
		function replyPatch(){
			var rno = $(".modal-title").html();
			var reply = $("#reply").val();
			$.ajax({
				type : 'patch',
				url : '/replies/' + rno,
				headers : {
					"Context-Type" : "application/json",
					"X-HTTP-Method-Override" : "PATCH"
				},
				contentType : "application/json",
				data : JSON.stringify({reply : reply}),
				dataType : 'text',
				success : function(){
					alert("수정되었습니다.");
					$("#modDiv").hide();
					getAllList();
				}
			})
		}
		
	
		
		$("#replies").on("click", ".replyLi button", function(){
			// 클릭한 버튼과 연계된 부모태그인 li태그를 replytag변수에 저장합니다.
			var replytag = $(this).parent();
			var rno = replytag.attr("data-rno");
			var reply = $(this).prev(".reply").text();
			// 모달 내부에 값을 전달
			console.log(replytag.attr("data-rno"));
			$(".modal-title").html(rno);
			$("#reply").val(reply);
			$("#modDiv").show("slow");
		})
		// 모달 종료 함수
		$("#closeBtn").on("click", function(){
			$("#modDiv").hide("slow");
		})
		// 삭제버튼 클릭시 삭제
		$("#replyDelBtn").on("click", function(){
			replyDelete();
		})
		
		// 수정버튼 클릭시 수정
		$("#replyModBtn").on("click", function(){
			replyPatch();
		})
	</script>
</body>
</html>