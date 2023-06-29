<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="jp.co.aforce.beans.CartItem" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>確認</title>
    <link rel="stylesheet" type="text/css" href="../css/style5.css">
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



<div class="top">
    <h1>決済が完了しました</h1>

    <h2>カートの商品</h2>
    <table>
        <tr>
            <th>商品名</th>
            <th>価格</th>
            <th>数量</th>
            <th>小計</th>
        </tr>
        <%
        List<CartItem> cart = (List<CartItem>) session.getAttribute("cart");
        int totalAmount = 0;
        for (CartItem item : cart) {
            int subTotal = item.getItem_price() * item.getCount();
            totalAmount += subTotal;
        %>
        <tr>
            <td><%= item.getItem_name() %></td>
            <td><%= item.getItem_price() %>円</td>
            <td><%= item.getCount() %>個</td>
            <td><%= subTotal %>円</td>
        </tr>
        <% } %>
    </table>

    <h2>カートの商品の合計金額</h2>
    <p><%= totalAmount %>円</p>

    <h2>お届け主様</h2>
    <p><%= request.getParameter("name") %></p>

    <h2>お届け先住所</h2>
    <p><%= request.getParameter("address") %></p>
    
    <h2>決済方法</h2>
    <p><%= request.getParameter("payment") %></p>
    
    <%
    // カートを空にする
    session.removeAttribute("cart");
%>

    </div>
    
    <footer id="footer">
  <small>&copy; copyright.</small>
</footer>

</body>
</html>