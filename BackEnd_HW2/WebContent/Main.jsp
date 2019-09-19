<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%

%>
<h1>메인 페이지</h1>
<form method = "post" action="login.do">
    <fieldset>
        <legend>로그인하여 주세요</legend>
        <table>
            <tr>
                <td><label for="id">ID</label></td>
                <td><input id="id" type="text" /></td>
            </tr>
            <tr>
                <td><label for="pw">PW</label></td>
                <td><input id="pw" type="password" /></td>
            </tr>
        </table>
        <input type="submit" value="LOGIN" id="login" />
    </fieldset>
<a href="register.html">상품등록</a>
<a href="#">상품목록</a>
<a href="#">마지막 등록한 상품</a>
</form>
</body>

</html>