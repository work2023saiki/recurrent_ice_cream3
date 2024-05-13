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
    <link rel="stylesheet" href="css/top.css" type="text/css">
</head>
<body>
	<header class="wrapper">
		<h1>Recurrent ice cream</h1>
	</header>
	<main class="wrapper">
    <h2>マイページ</h2>
    
    <% //教科書P366、P449参考。 accountInfoは、Login.javaで作成したセッションスコープ %>
    <p>氏名：<c:out value="${accountInfo.name}" /></p>
    <p>メールアドレス：<c:out value="${accountInfo.mailAd}" /></p>
    <p>性別：<c:out value="${accountInfo.gender}" /></p>
    <p>生年月日：<c:out value="${accountInfo.birth}" /></p>
    <p>住所：<c:out value="${accountInfo.homeAddress}" /></p>
    
    
    <a href="MyPageEdit">会員情報編集</a></br></br></br>
    
    <a href="DeleteAccount">退会する</a>

     </main>
     <footer class="wrapper">© 2024 Recurrent ice cream. All rights reserved.</footer> 
    
</body>
</html>