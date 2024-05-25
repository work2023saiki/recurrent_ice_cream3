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
	    <h2>マイページ</h2>
	    
	    <c:if test="${not empty Msg}">
            <p><font color="blue"><c:out value="${Msg}" /></font></p>
    	</c:if>
    	 
	    <% //教科書P366、P449参考。 accountInfoは、Login.javaで作成したセッションスコープ %>
	    <table border="1" class="centered-table">
	
	    <tr>
	        <td>氏名</td>
	        <td><c:out value="${accountInfo.name}" /></td>
	    </tr>
	    <tr>
	        <td>メールアドレス</td>
	        <td><c:out value="${accountInfo.mailAd}" /></td>
	    </tr>
	    <tr>
	        <td>性別</td>
	        <td><c:out value="${accountInfo.gender}" /></td>
	    </tr>
	    <tr>
	        <td>生年月日</td>
	        <td><c:out value="${accountInfo.birth}" /></td>
	    </tr>
	    <tr>
	        <td>住所</td>
	        <td><c:out value="${accountInfo.homeAddress}" /></td>
	    </tr>
		</table>
    
  
     </main>
      <a href="LogOut">TOPページへ</a>
      <a href="MyPageEdit">会員情報編集</a>
      <a href="DeleteAccount">退会する</a>
      
     <footer class="wrapper">© 2024 Recurrent ice cream. All rights reserved.</footer> 
    
</body>
</html>