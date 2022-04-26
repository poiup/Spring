<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
<style type="text/css">
	* {list-style: none}
	
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
<h2>
</h2>
<ul id="replies">
</ul>

<ul id="test">
</ul>
<button id="testBtn">다음링크 생성</button>
<button onclick="getAllList()">댓글 불러오기</button>
<div>
		<div>
			REPLYER <input type="text" name="replyer" id="newReplyWriter">
		</div>
		<div>
			REPLY TEXT <input type="text" name="reply" id="newReply">
		</div>
		<button id="replyAddBtn" onclick="addReply()">ADD REPLY</button>
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
	
<!--jquery는 여기서  -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script type="text/javascript">
			var bno = 311353;
			// 댓글 불러오는 function
	 function getAllList(){
						// 주소					// 콜백함수 주소요청으로 얻어온 json을 어떻게 처리할지
			$.getJSON("/replies/all/" + bno, function(data){
				//getJSON은 rest컨트롤러에 get방식으로 요청을 넣습니다.
				// 문자열을 이용해 태그를 생성하거나 끼워넣을수 있으므로
				// 빈 문자열을 만들어 놓고 거기에 댓글정보를 저장해 화면에 전송
				var str = "";		
				// 들고온 데이터 반복해서 출력하기
				// $(JSON형식데이터).each => 내부 JSON을 향상된 for문 형식으로 처리합니다.
				// 역시 내부에 콜백 함수(로직이 실행되었을떄 추가로 실행할 구문을 정의하기위해 파라미터로 넣는 함수)
				// 를 이용해 data를 하나하나 향상된 for문형식으로 처리할때 실행구문을 적을 수 있습니다.
				$(data).each(function(){
					// 하나하나 반복되는 각 데이터는 this라는 키워드로 표현합니다.
							str += "<li data-rno='" + this.rno + "' class='replyLi'>"
								+ this.rno + ":" + this.reply
								+ "<button>수정/삭제</button><li>";
				
								console.log("-------------------------------------")
								console.log(this)
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
	
		
		
		// 버튼 클릭시 발동되는 이벤트
					// testBtn클릭시  //함수 실행(45~48)
		$("#testBtn").on("click", function(){
			var strTest = "<a href='https://www.daum.net/'>다음으로 이동</a>";
			$("#test").html(strTest);
		})
		
		$("#replies").on("click", ".replyLi button", function(){
			// 클릭한 버튼과 연계된 부모태그인 li태그를 replytag변수에 저장합니다.
			var replytag = $(this).parent();
			var rno = replytag.attr("data-rno");
			var reply = replytag.text();
			// 모달 내부에 값을 전달
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