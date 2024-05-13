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
   
    <body>
    <% //P306の29～31行目を参照。errorMsgが空っぽでないなら %>
        <% if (errorMsg != null) { %>
        	<p><font color="red"><%= errorMsg %></font></p>
        <% } %>
		<p>本当に退会しますか？</p>
		<form action="DeleteAccount" method="post">
	        <button type="submit">退会する</button>
	    </form>
	</body>
</html>
	