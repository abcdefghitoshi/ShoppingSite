<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="jp.co.aforce.beans.CartItem" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>確認画面</title>
<link rel="stylesheet" type="text/css" href="../css/style4.css">
</head>
<body>
<header>
<div class="top1">
<h2><a>Flavor World</a></h2>
<form action="../jp.co.aforce/logout" method="post">
        <button type="submit" >LOGOUT</button>
    </form>    
<a href="../views/cart.jsp"><img alt="cart" src="../img/cart-alt-solid-24.png"></a>
</div>
</header>

<div class="main">
    <h1>確認画面</h1>
    <div class="center">
    <button onclick="location.href='../views/cart.jsp'">戻る</button>
    </div>
    <h2>カートの中身</h2>
    <table>
        <tr>
            <th>商品名</th>
            <th>価格</th>
            <th>数量</th>
            <th>小計</th>
        </tr>
        <%
        List<CartItem> cart = (List<CartItem>) request.getAttribute("cart");
        int totalAmount = 0;
        if (cart != null && !cart.isEmpty()) {
            for (CartItem item : cart) {
                totalAmount += item.getItem_price() * item.getCount();
        %>
        <form action="../jp.co.aforce/payment" method="post">
        <tr>
            <td><%= item.getItem_name() %></td>
            <td><%= item.getItem_price() %>円</td>
            <td><%= item.getCount() %>個</td>
            <td><%= item.getItem_price() * item.getCount() %>円</td>
        </tr>
        <% }
        } %>
        <tr>
            <td colspan="3">合計金額</td>
            <td><%= totalAmount %>円</td>
        </tr>
    </table>
    
    <h2>名前と住所</h2>
    <div class="form">
    <p>名前: <input type="text" name="name"  required ></p>
    <p>お届け先: <input type="text" name="address"  required></p>
    決済方法：
    <input type="radio" name="payment" value="商品代引き" checked  required> 商品代引き
    <input type="radio" name="payment" value="カード決済"> カード決済
    <p><input type="submit" value="確定"></p>
      </div>
      </div>
      </form>
      
      <footer id="footer">
  <small>&copy; copyright.</small>
</footer>
</body>
</html>