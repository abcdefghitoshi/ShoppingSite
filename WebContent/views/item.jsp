<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="jp.co.aforce.beans.Item"%>
<%@ page import="jp.co.aforce.Dao.ProductDao"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>商品一覧</title>
<link rel="stylesheet" type="text/css" href="../css/style.css">

</head>

<body>

<header>
<div class="top1">
<h2><a>Flavor World</a></h2>
         <form action="../jp.co.aforce/logout" method="post">
				<button type="submit">LOGOUT</button>
			</form>
<a href="../views/cart.jsp"><img alt="cart" src="../img/cart-alt-solid-24.png"></a>
</div>
</header>
<div class="itemform">

	<form action="../jp.co.aforce/itemsearch" method="post">
		<input type="search" name="keyword"> <input type="submit"
			value="検索">
	</form>
	
	<button onclick="location.href='../views/top.html'">TOP</button>

	

	<div class="top">
		<h1>商品一覧</h1>
	</div>
	
	<%
      String member = (String) session.getAttribute("member_id");
      if (member == null) {
      response.sendRedirect("../views/login.jsp"); // ログインページにリダイレクト
       }
     %>


	<%-- ログインユーザー名を表示 --%>
	<%
	String member_id = (String) session.getAttribute("member_id");
	if (member_id != null) {
	%>
	<p>
		<%=member_id%>
		様
		
		<% 
        session.setMaxInactiveInterval(900); // セッション時間制限（秒単位）
    %>
	</p>
	<%
	}
	%>

	<%-- カートに追加メッセージの表示 --%>
	<%
	String message = (String) request.getAttribute("message");
	if (message != null) {
	%>
	<p><%=message%></p>
	<%
	}
	%>
<%-- 検索のフォーム --%>
	<form action="../jp.co.aforce/itemsearch2" method="post">
		<select name="sort">
			<option value="default">並び替えなし</option>
			<option value="asc">価格の安い順</option>
			<option value="desc">価格の高い順</option>
		</select>
		<input type="submit" value="並び替え">
	</form>

	<section>
		<%-- 商品データの表示ループ --%>
		<%
		ProductDao productDao = new ProductDao();
		List<Item> itemList = (List<Item>) request.getAttribute("itemList");

		// 検索結果がある場合は検索結果を表示、ない場合は全商品一覧を表示
		if (itemList != null && !itemList.isEmpty()) {
			for (Item i : itemList) {
		%>

		<article>
			<div class="item">
				<form method="post" action="../jp.co.aforce/cart">
					<p>
						<img src="../img/<%=i.getItem_no()%>.jpg" height="64"
							class="img_item">
					</p>
					<p>
						<input type="text" name="item_name" size="20"
							value="<%=i.getItem_name()%>" readonly class="frame1">
					</p>
					<p>
						<input type="text" name="item_price" size="1.5"
							value="<%=i.getItem_price()%>" redonly class="frame2">円 <input
							type="hidden" name="item_no" value="<%=i.getItem_no()%>">
						<input type="number" name="count" min="1" value="1" class="number">
					</p>
					<span><input type="submit" class="button" value="CART"></span>
				</form>
			</div>
		</article>
		<%-- ループ終了 --%>
		<%
		}
		} else {
		List<Item> allItems = productDao.getAllItems();
		for (Item i : allItems) {
		%>

		<article>
			<div class="item">
				<form method="post" action="../jp.co.aforce/cart">
					<p>
						<img src="../img/<%=i.getItem_no()%>.jpg" height="64"
							class="img_item">
					</p>
					<p>
						<input type="text" name="item_name" size="20"
							value="<%=i.getItem_name()%>" readonly class="frame1">
					</p>
					<p>
						<input type="text" name="item_price" size="1.5"
							value="<%=i.getItem_price()%>" redonly class="frame2">円 <input
							type="hidden" name="item_no" value="<%=i.getItem_no()%>">
						<input type="number" name="count" min="1" value="1" class="number">
					</p>
					<span><input type="submit" class="button" value="カートに追加"></span>
				</form>
			</div>
		</article>
		
		

		<%-- ループ終了 --%>
		<%
		}
		}
		%>
         
         
	</section>

</div>
<footer id="footer">
  <small>&copy; copyright.</small>
</footer>

</body>
</html>