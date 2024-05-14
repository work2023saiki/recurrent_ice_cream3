<%-- <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ja">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>注文内容確認</title>
</head>
<body>
    <h1>注文内容確認</h1>
    <div>注文時間: <%= session.getAttribute("orderTime") %></div>
    <div>商品名: <%= session.getAttribute("productName") %></div>
	<div>合計金額: ￥<%= session.getAttribute("totalPrice") %></div>
	<div>選択した個数: <%= session.getAttribute("selectedQuantity") %>個</div>
	
	<form name="MyPage" action="" method="post"></form>
	
    <h2>お届け先</h2>
    <p>お名前：<c:out value="${accountInfo.name}" />　様</p>
    <p>お届け先：<c:out value="${accountInfo.homeAddress}" /></p>
    <p>メールアドレス：<c:out value="${accountInfo.mailAd}" /></p>
    
    <form action="orderComplete.jsp" method="post">
    <input type="submit" value="注文確定">
  	</form>
    
    <a href="catalogpage.jsp">商品一覧へ</a><br>
    <a href="top.jsp">TOPページへ</a>
</body>
</html> --%>


<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ja">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>注文内容確認</title>
    <link rel="stylesheet" href="css/style.css" type="text/css">
</head>
<body>
	<header class="wrapper">
    	<h1>Recurrent ice cream</h1>
    </header>
    <main class="wrapper">
    <h2>注文内容確認</h2>
    
    <!-- forEach -->
    <div>商品名: <%= request.getAttribute("productName") %></div>
    <div>合計金額: ￥<%= request.getAttribute("totalPrice") %></div>
    <div>選択した個数: <%= request.getAttribute("selectedQuantity") %>個</div>
    
    
    </br></br></br></br></br>
    
    
    <!-- ログインするとき取得するaccounInfoから取り出して使う -->
    <!-- お届け先情報 -->
    <h2>お届け先</h2>
    <p>お名前：<%= request.getAttribute("name") %> 様</p>
    <p>お届け先：<%= request.getAttribute("homeAddress") %></p>
    <p>メールアドレス：<%= request.getAttribute("mailAd") %></p>
    
    <!-- 注文確定ボタン -->
    <form action="orderComplete.jsp" method="post">
        <input type="submit" value="注文確定">
    </form>
    
    <!-- 商品一覧へのリンク -->
    <a href="ProductServlet">商品一覧へ</a><br>
    
    <!-- TOPページへのリンク -->
    <a href="LogOut">TOPページへ</a>
    </main>
    <footer class="wrapper">© 2024 Recurrent ice cream. All rights reserved.</footer>
</body>
</html>