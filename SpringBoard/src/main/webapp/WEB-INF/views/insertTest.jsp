<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div>
		<div>
			Bno <input type="text" name="bno" id="newbno">
		</div>
		<div>
			REPLYER <input type="text" name="replyer" id="newReplyWriter">
		</div>
		<div>
			REPLY TEXT <input type="text" name="reply" id="newReply">
		</div>
		<button id="replyAddBtn">ADD REPLY</button>
	</div>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
 	<script type="text/javascript">
 		function addReply(){
 			var bno = $("#newbno").val();
 			var replyer = $("#newReplyWriter").val();
 			var reply = $("#newReply").val();
 			$.ajax({
 				type: 'post',
 				url : '/replies',
 				headers: {
 					"Content-Type" : "application/json",
 					"X-HTTP-Method-Override" : "POST"
 				},
 				dataType : 'text',
 				data : JSON.stringify({
 					bno : bno,
 					replyer : replyer,
 					reply : reply
 				}),
 				success : function(result){
 					alert("등록되었습니다.");
 				}
 			})
 		}
 		$("#replyAddBtn").on("click", function(){
 			addReply();
 		})
 	</script>
</body>
</html>