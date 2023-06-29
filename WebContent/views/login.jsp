<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="../css/style2.css">
</head>
<body>

	
		<form action="../jp.co.aforce/login" method="post" class="form">
		<div class="login_form">
		<h1>Login</h1>
		<p>メンバーIDとパスワードを入力してください。</p>
		<%-- エラーメッセージの表示 --%>
	<p><%
	String errorMessage = (String) request.getAttribute("errorMessage");
	if (errorMessage != null) {
	%>
	<%=errorMessage%>
	<%
	}
	%>
	</p>
		</div>
		<div class="login_item">
		 <input type="text" name="member_id" placeholder="MEMBER_ID">
		 <input type="password" name="password" placeholder="PASSWORD">
		</div>
		<button type="submit" class="login">LOGIN</button>
		<a href="../views/insert.jsp" class="register-link">→新規登録はこちらから←</a><br>
		<a href="../views/top.html" class="register-link">→TOPに戻る←</a>
		</form>
	
</body>
</html>