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
    <h2>会員編集</h2>
    
    <form name="MyPageEdit" action="MyPageEdit" method="post">
	    
	    <% //教科書P366、P449参考。 accountInfoは、Login.javaで作成したセッションスコープ %>
	    <p>氏名：<input type="text" name="name"  value=<c:out value="${accountInfo.name}" /> placeholder="お名前を入力してください" required></p>
		          
	    <p>メールアドレス：<input type="text" name="mailAd" value=<c:out value="${accountInfo.mailAd}" /> placeholder="入力してください" required></p>
	    
	    <p>住所：<input type="text" name="building" value=<c:out value="${accountInfo.homeAddress}" /> placeholder="入力してください" required></p>
	    
	    <button type="submit">保存する</button>
    </form>
    <footer class="wrapper">© 2024 Recurrent ice cream. All rights reserved.</footer>
</body>
</html>