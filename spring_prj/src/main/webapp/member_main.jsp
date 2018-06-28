<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
String username = (String)request.getAttribute("username");
out.println(username + "님 환영합니다.");
%>
<br>
<form action="/slogout" method="post">
<input type="submit" value="로그아웃">
</form>

</body>
</html>