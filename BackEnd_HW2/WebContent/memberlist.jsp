<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="com.ssafy.model.dto.Member"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/basic.css" />
<style type="text/css">
.boardSub {
	display: none
}

.boardView {
	display: block
}
</style>
<script type="text/javascript" src="js/jquery-3.3.1.js"></script>
<script type="text/javascript">
	$(function(){
		$('.boardContent').hover(getContent, function() {
			$('div', this).addClass('boardSub').removeClass('boardView');
		} )
	})
	function getContent(){
		var thisContent = $('div', this);
		thisContent.addClass('boardView').removeClass('boardSub');
		$.ajax({
			 url : 'searchBoardAjax.do'								//요청 url
			,data: { no : $(this).attr('data-no') } 
			,dataType : 'json'								//응답 받는 데이타 타입
			,success  : function(data) {
				thisContent.text(data.descrip);
			}
			,error : function(err) {
				console.log(err)
			}
		})
	}
</script>
</head>
<body>
	<form method="post" action="memSearch.do" align="center">
		<input type="text" name="no">제품 번호 <input type="submit"
			value="검색">
	</form>
	<h1 align="center">회원 리스트</h1>
	<table align="center">
		<tr>
			<th colspan="3">게시글 목록</th>
		</tr>
		<tr align="center">
			<td width="100">제품번호</td>
			<td width="150">제품이름</td>
			<td width="100">가격</td>
		</tr>
		<c:forEach items="${requestScope.list}" var="g">
			<tr>
				<td align='center'>${pageScope.g.no}</td>
				<td align='center' class='boardContent' data-no='${g.no}'>
					<a href='#' onclick="getBoard(${g.no})">${g.name}</a>
					<div class='boardSub'></div>
					</td>
				<td align='center'>${g.price}</td>
		</c:forEach>
	</table>
	<a href="Login.jsp">뒤로가기</a>
</body>
</html>