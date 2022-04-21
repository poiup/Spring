<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	* {list-style: none}
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
<button onclick="getReplies()">댓글 불러오기</button>
<!--jquery는 여기서  -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script type="text/javascript">
	
	 function getReplies(){
			var bno = 16384;
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
								+ "<li>";
				
								console.log("-------------------------------------")
								console.log(this)
						}); 
					$("#replies").html(str);
				});
		}
	 
		// 버튼 클릭시 발동되는 이벤트
					// testBtn클릭시  //함수 실행(45~48)
		$("#testBtn").on("click", function(){
			var strTest = "<a href='https://www.daum.net/'>다음으로 이동</a>";
			$("#test").html(strTest);
		})
	
</script>
</body>
</html>