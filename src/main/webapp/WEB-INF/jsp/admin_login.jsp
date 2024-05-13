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
    <title>管理者ログイン</title>
    <link rel="stylesheet" href="css/top.css" type="text/css">
</head>
<body>
<header class="wrapper">
        <h1>Recurrent ice cream</h1>
    </header>

<% //P306の29～31行目を参照。errorMsgが空っぽでないなら %>
	        <% if (errorMsg != null) { %>
	        
	        <p><font color="red"><%= errorMsg %></font></p>
	        
	        <% } %>
	        
    <form name="adminlogin_form" action="AdminLogin" method="post">
	    <h1>管理者ログイン</h1>
	    <p>名前・パスワードをご入力の上、ログインボタンをクリックしてください</p>
	
		<div class="login_form_btm">
		  <input type="name" name="AdminName" placeholder="お名前を入力してください"><br>
		  <input type="password" name="AdminPassword" placeholder="パスワードを入力してください">
		</div>
		<button type="submit">ログイン</button>
	</form>
</body>
</html>
