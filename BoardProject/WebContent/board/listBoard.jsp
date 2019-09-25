<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="Cache-Control"
	content="no-cache, no-store, must-revalidate" />
<meta http-equiv="Pragma" content="no-cache" />
<meta http-equiv="Expires" content="0" />
<title>Board Project</title>
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
	$(function() {
		//검색 버튼에 이벤트 연결
		$('#search').click(function () {   
			pagelist(1);
		})
		//조회 조건이 요청 데이타에 있으면 해당 조회 조건으로 선택되어 있어야 한다. 
		<c:if test='${not empty param.key}'>
		 	$('#key').val('${param.key}')
		</c:if>
		 	
		$('.boardContent').hover(getContent, function() {
			$('div', this).addClass('boardSub').removeClass('boardView');
		} )
	})
	function getContent(){
		var thisContent = $('div', this);
		thisContent.addClass('boardView').removeClass('boardSub');
		$.ajax({
			 url : 'main.do'								//요청 url
			,data: { action :'searchBoardAjax.do'			//요청 데이타
				    ,no : $(this).attr('data-no') } 
			,dataType : 'json'								//응답 받는 데이타 타입
			,success  : function(data) {
				thisContent.text(data.contents);
			}
			,error : function(err) {
				console.log(err)
			}
		})
	}
	//조건 검색, 페이지 번호로 게시글 요청을 위한 메서드  
	function pagelist(cpage){
		//input 양식의 hidden으로 선언된 page에 요청된 페이지 정보 셋팅 
		$("#pageNo").val(cpage);
		var frm = $("#frm");
		$("#action").val("listBoard.do");
		frm.attr('action',"main.do");
		frm.submit();
	}
	//게시글 번호나 타이틀을 클릭하면 해당 게시글 요청을 위한 메서드 
	function getBoard(no){
		//input 양식의 hidden으로 선언된 no(게시글 번호)에 요청된 게시글 번호를 셋팅
		$("#no").val(no);
		var frm = $("#frm");
		$("#action").val("searchBoard.do");
		frm.attr('action',"main.do");
		frm.submit();
	}
</script>
</head>
<body>
	<div id="head">
		<jsp:include page="/menu.jsp" />
	</div>
	<article id="content">
		<jsp:include page="/aside.jsp" />
		<article id="mainContent">
			<div class="main">
				<jsp:useBean id="bean" class="com.ssafy.model.dto.PageBean"
					scope="request" />
				<form id="frm">
					<input type="hidden" id="pageNo" name="pageNo"
						value="${bean.pageNo}" /> <input type="hidden" id="action"
						name="action" /> <input type="hidden" id="no" name="no" />
					<table align="center">
						<tr>
							<th colspan="3">게시글 목록</th>
						</tr>
						<tr align="center">
							<td colspan="4" height="100" align="center"><select
								name="key" id="key">
									<option value="all">---선택하세요---</option>
									<option value="id">아이디</option>
									<option value="title">제목</option>
									<option value="contents">내용</option>
							</select> <input type="text" id="word" name="word" value='${bean.word}' />
								<a href="#" onclick="pagelist(1)" id='search'>검색</a>
								&nbsp;&nbsp;&nbsp; <c:if test="${not empty id }">
									<a href="insertBoardForm.do">글쓰기</a>
								</c:if></td>
						</tr>
						<tr align="center">
							<td width="50">번 호</td>
							<td width="150">제 목</td>
							<td width="50">아이디</td>
							<td width="100">게시일</td>
						</tr>
						<c:forEach items='${list}' var='board'>
							<tr>
								<td align='center'><a href='#'
									onclick="getBoard(${board.no})">${board.no}</a></td>
								<td align='center' class='boardContent' data-no='${board.no}'>
									<a href='#' onclick="getBoard(${board.no})">${board.title}</a>
									<div class='boardSub'></div>
								</td>
								<td align='center'>${board.id}</td>
								<td align='center'>${board.regdate}</td>
							</tr>
						</c:forEach>
					</table>
					<div class="bottom">
						<center>${bean.pagelink}</center>
					</div>
				</form>
			</div>
		</article>
	</article>
	<footer id="copyright">
		<jsp:include page="/copyright.jsp" />
	</footer>
</body>
</html>













