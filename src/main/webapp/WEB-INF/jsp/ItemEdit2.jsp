<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<% //教科書P366、P449参考  %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html>
<html lang="ja">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>MyPage</title>
    <link rel="stylesheet" href="css/style.css" type="text/css">
</head>
<body>
	<header class="wrapper">
        <h1>Recurrent ice cream</h1>
    </header>
    <main class="wrapper">
    	<h2>商品編集</h2>
	    <form action="ItemEdit3" method="post">
		    
		    <% //教科書P366、P449参考。 accountInfoは、Login.javaで作成したセッションスコープ %>
		    <p>商品名<input type="text" name="name"  value=<c:out value="${Item.itemName}" /> placeholder="入力してください" required></p>
			          
		    <p>価　格<input type="text" name="price" value=<c:out value="${Item.price}" /> placeholder="入力してください" required></p>
		    
		    <p>説　明<input type="text" name="itemExplain" value=<c:out value="${Item.itemExplain}" /> placeholder="入力してください" required></p>
		    
		    <button type="submit" name="button" value=<c:out value="${Item.itemID}"/>>保存する</button>
		 
	    </form>
    </main>
    <footer class="wrapper">© 2024 Recurrent ice cream. All rights reserved.</footer>
</body>
</html>