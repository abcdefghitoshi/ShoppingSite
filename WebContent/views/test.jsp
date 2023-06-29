<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="jp.co.aforce.beans.Item"%>
<%@ page import="jp.co.aforce.Dao.ProductDao"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>商品一覧</title>
</head>

<body>
	<form action="../jp.co.aforce/itemsearch" method="post">
		<input type="search" name="keyword"> <input type="submit" value="検索">
	</form>

	<a href="../views/cart.jsp">カート</a>

	<h1>商品一覧</h1>

	<%-- カートに追加メッセージの表示 --%>
	<%
	String message = (String) request.getAttribute("message");
	if (message != null) {
	%>
	<p><%=message%></p>
	<%
	}
	%>

	<table>
		<tr>
			<th>商品画像</th>
			<th>商品名</th>
			<th>価格</th>
			<th>個数</th>
			<th></th>
		</tr>
		<%-- 商品データの表示ループ --%>
		<%
		ProductDao productDao = new ProductDao();
		List<Item> itemList = (List<Item>) session.getAttribute("itemList");
		if (itemList != null) {
			for (Item i : itemList) {
		%>
		<!-- 商品データの表示 -->
		<tr>
			<form method="post" action="../jp.co.aforce/cart">
				<td><img src="../img/<%=i.getItem_no()%>.jpg" height="64"></td>
				<td><input type="text" name="item_name" size="20" value="<%= i.getItem_name() %>" readonly></td>
				<td><input type="text" name="item_price" size="1.5" value="<%= i.getItem_price() %>" readonly></td>
				<td><input type="hidden" name="item_no" value="<%= i.getItem_no() %>"> <input type="number" name="count" min="1" value="1"></td>
				<td><input type="submit" value="買い物かごに追加"></td>
			</form>
		</tr>
		<%
			}
		}
		%>
	</table>
</body>
</html>