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
    
    <form action="MyPageEdit3" method="post">
	    
	    <% //教科書P366、P449参考。 accountInfoは、Login.javaで作成したセッションスコープ %>
	    <p>氏名：<input type="text" name="name"  value=<c:out value="${account2.name}" /> placeholder="入力してください" required></p>
		          
	    <p>メールアドレス：<input type="text" name="mailAd" value=<c:out value="${account2.mailAd}" /> placeholder="入力してください" required></p>
	    
	    <p>住所：<input type="text" name="building" value=<c:out value="${account2.homeAddress}" /> placeholder="入力してください" required></p>
	    
	    <button type="submit" name="button" value=<c:out value="${account2.accountID}"/>>保存する</button>
    </form>
    
</body>
</html>