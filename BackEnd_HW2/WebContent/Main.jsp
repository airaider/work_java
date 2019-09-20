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
                <td><input name="id" type="text" value="ssafy" /></td>
            </tr>
            <tr>
                <td><label for="pw">PW</label></td>
                <td><input name="pw" type="password" value="1111" /></td>
            </tr>
        </table>
        <input type="submit" value="LOGIN" id="login" />
    </fieldset>
</form>
</body>

</html>