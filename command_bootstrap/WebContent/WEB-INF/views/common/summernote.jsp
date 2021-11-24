<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>

<script>
function Summernote_start(targetObj) {
	targetObj.summernote({
       placeholder : '여기에 내용을 적으세요',
       height : 250,
       disableResizeEditor : true,
       callbacks:{
       	onImageUpload : function(files, editor, welEditable) {
       		//file size check!
       		for (var file of files) { // 유효성 체크 for문
       			if(file.size > 1024 * 1024 * 5){
       				alert("이미지는 5MB 미만입니다.");
       				return;
       			}
       			
       			if(file.name.substring(file.name.lastIndexOf(".")+1).toUpperCase() != "JPG"){
       				alert("JPG 이미지형식만 가능합니다.");
       				return;
       			}
       			
       		}
       		
       		for (var file of files) { // 파일을 하나씩 던지기 위한 for문
   				sendFile(file,this);
   			}
       	},
       	onMediaDelete : function(target) {
   			//alert(target[0].src.split("=")[1]);
   			deleteFile(target[0].src);
       	}
       }
    });
 }
 
 function sendFile(file, el) {
	  var form_data = new FormData();
	  form_data.append("file", file);
	  $.ajax({
		  data: form_data,
		  type: "POST",
		  url: '<%=request.getContextPath()%>/uploadImg.do',
		  cache: false,
		  contentType: false,
		  processData: false,
		  success: function(img_url) {
			  $(el).summernote('editor.insertImage', img_url);
		  },
		  error:function(){
			  alert("이미지 업로드에 실패했습니다.");
		  }
	  });
 }
 
 function deleteFile(src) {
	  var splitSrc = src.split("=");
	  var fileName = splitSrc[splitSrc.length-1];
	  
	  var fileData = {fileName:fileName};
	  
	  $.ajax({
		  url:"<%=request.getContextPath()%>/deleteImg.do",
		  data : JSON.stringify(fileData),
		  type : "post",
		  contentType:"application/json",
		  success : function(res) {
			  console.log(res);
		  },
		  error : function(){
			  alert("이미지 삭제가 불가합니다.");
		  }
	  });
 }

</script>