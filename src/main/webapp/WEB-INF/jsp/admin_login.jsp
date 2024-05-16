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
    <link rel="stylesheet" href="css/style.css" type="text/css">
</head>
<body>
	<header class="wrapper">
        <h1>Recurrent ice cream</h1>
    </header>

<% //P306の29～31行目を参照。errorMsgが空っぽでないなら %>
	        <% if (errorMsg != null) { %>
	        
	        <p><font color="red"><%= errorMsg %></font></p>
	        
	        <% } %>
	 <main class="wrapper">  
	    <form name="adminlogin_form" action="AdminLogin" method="post">
		    <h2>管理者ログイン</h2>
		    <p>お名前とパスワードを入力してください。</p>
		
			<div class="login_form_btm">
			  <input type="name" name="AdminName" placeholder="お名前"><br>
			  <input type="password" name="AdminPassword" placeholder="パスワード">
			</div>
			<button type="submit">ログイン</button>
		</form>
	</main>     
	<a href="top.jsp">TOPページへ</a>
	<footer class="wrapper">© 2024 Recurrent ice cream. All rights reserved.</footer>
</body>
</html>
