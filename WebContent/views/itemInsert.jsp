<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>商品の追加画面</title>
<link rel="stylesheet" type="text/css" href="../css/style8.css">
</head>
<body>
<p>追加する商品を入力してください。<p>
<form action="../jp.co.aforce/iteminsert" method="post">
商品名<input type="text" name="item_name">
価格<input type="text" name="item_price">
<input type="submit" value="追加">
</form>

<button ><a href="../views/top.html">top</a></button>



</body>
</html>