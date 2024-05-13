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
</head>
<body>
    
    <form action="ItemEdit3" method="post">
	    
	    <% //教科書P366、P449参考。 accountInfoは、Login.javaで作成したセッションスコープ %>
	    <p>商品名：<input type="text" name="name"  value=<c:out value="${Item.itemName}" /> placeholder="入力してください" required></p>
		          
	    <p>商品価格：<input type="text" name="price" value=<c:out value="${Item.price}" /> placeholder="入力してください" required></p>
	    
	    <p>商品説明：<input type="text" name="itemExplain" value=<c:out value="${Item.itemExplain}" /> placeholder="入力してください" required></p>
	    
	    <button type="submit" name="button" value=<c:out value="${Item.itemID}"/>>保存する</button>
	 
    </form>
    
</body>
</html>