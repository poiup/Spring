/**
 * 
 */

$(document).ready(function(){
			
			var csrfHeaderName = "${_csrf.headerName}";
			var csrfTokenValue = "${_csrf.token}";
			
			var regex = new RegExp("(.*?)\.(exe|sh|zip|alz|png)$");
			var maxSize = 52428800; // 5MB
			
			function checkExtension(fileName, fileSize){
					if(fileSize >= maxSize){
						alert("파일사이즈 초과");
					return false;
					}
					
					console.log(regex.test(fileName));
					if(!regex.test(fileName)){
						alert("해당 종류의 파일은 업로드할 수 없습니다.");
						return false;
					}
					return true;
			}
			// 첨부가 안된 상태의 .uploadDiv를 깊은 복사해서
			// 첨부 완료후에 안된 시점의 .uploadDiv로 덮어씌우기
			var cloneObj = $(".uploadDiv").clone();
			$('#uploadBtn').on("click", function(e){
				var formData = new FormData();
				
				var inputFile = $("input[name='uploadFile']");
				
				var files = inputFile[0].files;
				
				console.log(files);
				for(var i = 0; i < files.length; i++){
					if(!checkExtension(files[i].name, files[i].size)){
						return false;
					}
					formData.append("uploadFile", files[i]);
				}
				
				$.ajax({
					url: 'uploadAjaxAction',
					processData: false,
					contentType: false,
					data: formData,
					type: 'POST',
					dataType: 'json',
					success: function(result){
							alert("Uploaded.");
							showUploadedFile(result);
							$(".uploadDiv").html(cloneObj.html());
					},
					beforeSend: function(xhr){
						xhr.setRequestHeader(csrfHeaderName, csrfTokenValue);
					}
			
				}); // ajax
			}); // onclick uploadbtn
			
			var uploadResult = $(".uploadResult ul");
			
			function showUploadedFile(uploadResultArr){
				var str = "";
				
				$(uploadResultArr).each(function(i,obj){
					console.log("인덱스번호 : " + i);
					console.log("실제 자료 : " + obj);
					if(!obj.image){			
						var fileCallPath = encodeURIComponent(obj.uploadPath +"/" + obj.uuid + "_" + obj.fileName);
						str += "<li><a href='/download?fileName="+fileCallPath+"'><img src='/resources/attach.png'/>" + obj.fileName + "</a><span data-file=\' " +fileCallPath + "\ data-type='file'>X</span></li>";
					} else{						
//						str += "<li>" + obj.fileName + "</li>";
						var fileCallPath = encodeURIComponent(obj.uploadPath +"/s_" + obj.uuid + "_" + obj.fileName);
						var fileCallPathOriginal = encodeURIComponent(obj.uploadPath +"/" + obj.uuid + "_" + obj.fileName);
						str += "<li><a href='/download?fileName="+fileCallPathOriginal+"'><img src='/display?fileName=" + fileCallPath+"'></a>"+obj.fileName+"<span data-file=\' " +fileCallPath + "\ data-type='image'>X</span></li>"
					}
				});
				uploadResult.append(str);
				
			}
			
			
			$(".uploadResult").on("click","span", function(e){
				var targerFile = $(this).data("file");
				var type = $(this).data("type");
				
				var targetLi = $(this).closest("li");
				
				$.ajax({
					url: '/deleteFile',
					data: {fileName: targetFile, type:type},
					dateType: 'text',
					type: 'POST',
					success: function(result){
						alert(result);
						targetLi.remove();
					}
				})
			})
		});