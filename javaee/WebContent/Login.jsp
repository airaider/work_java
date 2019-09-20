<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
.errormsg {
	font-size: 14px;
	s color: red;
}
</style>
</head>
<body>
	<c:choose>
		<c:when test="${sessionScope.id!=null}">
	${sessionScope.id}님 환영합니다.
	<a href="logout.do">로그아웃</a>
		</c:when>
		<c:otherwise>
			<form method="post" action="login.do">
				<table align="center" border="1">
					<c:if test="${msg!=null}">
						<tr>
							<td colspan="2" class='errormsg'>${msg}</td>
						</tr>
					</c:if>
					<tr>
						<td>아 이 디</td>
						<td><input type="text" name="id" value="${cookie.id.value}"></td>
					</tr>
					<tr>
						<td>비밀번호</td>
						<td><input type="password" name="password"></td>
					</tr>
					<tr>
						<td colspan="2" align="right">아이디 저장<input type="checkbox"
							name="idsave" value="t"
							
							<c:if test="${cookie.id.value!=null}">
			  checked="checked"
			  </c:if> />
							<input type="submit" value="로그인">
						</td>
					</tr>
				</table>
			</form>
		</c:otherwise>
	</c:choose>


</body>
</html>







