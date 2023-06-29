<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="jp.co.aforce.beans.CartItem"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>カート</title>
<link rel="stylesheet" type="text/css" href="../css/style6.css">

</head>

<body>
	<header>
		<div class="top1">
			<h2>Flavor World</h2>
            <form action="../jp.co.aforce/logout" method="post">
				<button type="submit">LOGOUT</button>
			</form>
			<button onclick="location.href='../views/item.jsp'">商品一覧</button>
		</div>
	</header>

	<h3>Cart一覧</h3>
	<button onclick="location.href='../views/top.html'">TOP</button>
	<button onclick="location.href='../views/item.jsp'">戻る</button>

	<%
	String member = (String) session.getAttribute("member_id");
	if (member == null) {
		response.sendRedirect("../views/login.jsp"); 
	}
	%>

	<%-- カートの情報取得 --%>
	<%
	List<CartItem> cart = (List<CartItem>) session.getAttribute("cart");
	%>

	<%-- カート内のアイテムが存在するか確認 --%>
	<%
	if (cart != null && !cart.isEmpty()) {
	%>
	<table>
		<tr>
			<th>商品名</th>
			<th>価格</th>
			<th>数量</th>
			<th>小計</th>
		</tr>
		<%-- カート内の各アイテムの情報を表示 --%>
		<%
		int totalAmount = 0;
		%>
		<%
		for (CartItem item : cart) {
		%>
		<tr>
			<form action="../jp.co.aforce/cartdelete" method="post">
				<td><input type="text" name="item_name" value="<%=item.getItem_name()%>" readonly></td>
				<td><input type="text" name="item_price" value="<%=item.getItem_price()%>" readonly>円</td>
				<td><input type="text" name="count_<%=item.getItem_no()%>" value="<%=item.getCount()%>" onchange="updateSubtotal(<%=item.getItem_no()%>)">個</td>
				<td><span id="subtotal_<%=item.getItem_no()%>"><%=item.getItem_price() * item.getCount()%>円</span></td>
				<td><input type="submit" value="削除"></td>
				<td><input type="hidden" name="item_no"value="<%=item.getItem_no()%>" readonly></td>
			</form>
			</td>
		</tr>
		<%-- 合計金額を計算 --%>
		<%
		totalAmount += item.getItem_price() * item.getCount();
		%>
		<%
		}
		%>
		<tr>
			<td colspan="4">合計金額</td>
			<td><span id="total"><%=totalAmount%>円</span></td>
		</tr>
	</table>

	<form action="../jp.co.aforce/confirmation" method="post">
		<input type="submit" value="確認">
	</form>
	<%
	} else {
	%>
	<p>カートは空です。</p>
	<%
	}
	%>
	
	<footer id="footer">
  <small>&copy; copyright.</small>
</footer>
</body>
</html>