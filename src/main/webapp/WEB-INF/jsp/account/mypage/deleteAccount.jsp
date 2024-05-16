<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
  //P306の9～10行目を参照
  //リクエストスコープに保存されたエラーメッセージを取得
  String errorMsg = (String)request.getAttribute("errorMsg");
%>    
<!DOCTYPE html>
<html lang="ja">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>退会</title>
    <link rel="stylesheet" href="css/style.css" type="text/css">
</head>
	<body>
		<header class="wrapper">
	        <h1>Recurrent ice cream</h1>
	    </header>
		<main class="wrapper">
	    <% //P306の29～31行目を参照。errorMsgが空っぽでないなら %>
	        <% if (errorMsg != null) { %>
	        	<p><font color="red"><%= errorMsg %></font></p>
	        <% } %>
			<h2>本当に退会しますか？</h2><br>
			<form action="DeleteAccount" method="post">
		        <button type="submit">退会する</button>
		    </form>
		 </main>
		<footer class="wrapper">© 2024 Recurrent ice cream. All rights reserved.</footer>
	</body>
</html>
	