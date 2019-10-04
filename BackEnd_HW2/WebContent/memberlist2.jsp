<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="com.ssafy.member.dto.Member"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원정보 조회</title>
<link href="css/basic.css" rel="stylesheet" type="text/css">
</head>
<body>

	<c:choose>
		<c:when test="${msg != null}">
		${msg}
	</c:when>
		<c:otherwise>
		<form method="post" action="update.do">
				<table align='center'>
					<tr>
						<td class="caption" colspan='2'>검색정보</td>
					</tr>
					<tr>
						<td class='tbasic'>제품번호</td>
						<td class='tbasic'><input type='text' name='id' id='id'
							value='${member.no}' readonly="readonly"></td>
					</tr>
					<tr>
						<td class='tbasic'>제품이름</td>
						<td class='tbasic'><input type='text' name='pw' id='pw'
							value='${member.name}'></td>
					</tr>
					<tr>
						<td class='tbasic'>제품가격</td>
						<td class='tbasic'><input type='text' name='name' id='name'
							value='${member.price}'></td>
					</tr>
					<tr>
						<td class='tbasic'>제품설명</td>
						<td class='tbasic'><input type='text' name='email' id='email'
							value='${member.descrip}'>
					</tr>
					
					<tr>
						<td colspan='2' align='center' class='tfoot tspacial'>
						
						<input type="submit" value="제품수정">
						
						</td>
					</tr>
				</table>
				</form>
				<table align='center'>
				<tr>
				<td colspan='2' align='center' class='tfoot tspacial'>
						<a href="memberlist.do"><button>제품리스트</button></a><br/>
						<a href="delete.do"><button>제품삭제</button></a>
				</tr>
				</table>
		</c:otherwise>
	</c:choose>
</body>
</html>