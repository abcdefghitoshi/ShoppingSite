<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="../css/style9.css">
</head>
<body>

	<form action="../jp.co.aforce/insert" method="post">
		<h1>会員情報登録画面</h1>
          
          <p>・会員ID<p>
           <input type="text" name="member_id"  required="required" maxlength="16"><br>※16文字以内
          <p>・パスワード<p>
          <input type="text" name="password" required="required" maxlength="16"><br>※半角英数字16字以内
				<p>
			<input type="submit" value="登録"> <input type="reset"
				value="リセット">
		</p>
	</form>

</body>
</html>