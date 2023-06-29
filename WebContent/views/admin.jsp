<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="../css/style7.css">
</head>
<body>
管理者ログイン画面
<%-- エラーメッセージの表示 --%>
	<%
	String errorMessage = (String) request.getAttribute("errorMessage");
	if (errorMessage != null) {
	%>
	<%=errorMessage%>
	<%
	}
	%>
<form action="../jp.co.aforce/login2" method="post">
<p>会員ID:<input type="text" name="admin_id"><p>
<p>password:<input type="password" name="password"><p></p>

<p><input type="submit" value="login"><p>
<p><input type="reset" value="リセット"></p>
</form>
<button ><a href="../views/top.html">top</a></button>



</body>
</html>