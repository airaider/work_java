<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src='../js/basic.js'></script>
<script type="text/javascript">
window.onload=function(){
	//현재 창을 띄운 창(opener)에서 id를 찾아 오기
	var openerId = opener.document.getElementById('id');
	var id = document.getElementById('id');
	id.value = openerId.value;
	
	var selectId = document.getElementById('selectId');
	addEvent(selectId, 'click',useId);
}
function useId(){
	//Opener : 새창을 띄워준 창 
	var openerId = opener.document.getElementById('id');
	var id = document.getElementById('id');
	openerId.value = id.value;
	self.close();  //현재 창 닫기
}


</script>
</head>
<body>
	<form action=''>
		<input type='text' 		name='id'  id='id'/>
		<input type='button'	value='검사'/><br/>
		<div  id='centent'>
			사용할 수 있는 아이디입니다.</br/>
			<a href="#"  id="selectId">사용</a>
		</div>
	</form>
</body>
</html>