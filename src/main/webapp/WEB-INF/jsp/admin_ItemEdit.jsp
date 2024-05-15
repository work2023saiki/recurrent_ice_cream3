<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
 
<!DOCTYPE html>
<html lang="ja">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Admin MyPage</title>
  <link rel="stylesheet" href="css/style.css" type="text/css">
</head>
<body>
	<header class="wrapper">
        <h1>Recurrent ice cream</h1>
    </header>
	<main class="wrapper">
    <h2>商品の編集ページ</h2>
    
    <form action="ItemFind" method="post">
    <div class="search">
        <p>商品名
        <input type="text" name="name" required> <button type="submit">検索</button>
        </p>
    </div>
    </form>
    
    <form action="ItemRegist" method="post">
    <div class="registration">
    	<p>商品の新規登録</p>
        <p><input type="text" name="itemName" placeholder="商品名" required><input type="text" name="price" placeholder="商品価格" required>
        <input type="text" name="itemExplain" placeholder="商品説明" required>
        <button type="submit">登録</button></p>
    </div>
    </form>
    

    </br></br>
    
    <c:if test="${not empty Msg}">
    
      <p><font color="blue"><c:out value="${Msg}" /></font></p>
    
    </c:if> 
    
    <c:if test="${not empty errorMsg}">
    
      <p><font color="red"><c:out value="${errorMsg}" /></font></p>
    
    </c:if> 
    
    <c:if test="${not empty ItemList }">
    <table border="1" class="centered-table">
		
		    <tr>
		        <th>商品ID</th>
		        <th>商品名</th>
		        <th>商品価格</th>
		        <th>商品説明</th>		        		        
		    </tr>
	
		    <c:forEach var="item" items="${ItemList}" varStatus="status">
		        <tr>
		        <% //https://qiita.com/shun_tech/items/1fd16b5209e593e668b0  %>
		        <form action="?" method="post">
		            <td><c:out value="${item.itemID}" /></td>
		            <td><c:out value="${item.itemName}" /></td>
		            <td><c:out value="${item.price}"/></td>
		            <td><c:out value="${item.itemExplain}" /></td>
		            <td><button type="submit" formaction="ItemEdit2">編集</button></td>
		            <td><button type="submit" name="button" value=<c:out value="${item.itemID}"/> formaction="DeleteItem">削除</button></td>
                 
                    <input type="hidden" name="loopIndex" value=<c:out value="${status.index}"/>>	        
		        </form>
		        
		        </tr>
		    </c:forEach>
		</table>
		
	</c:if>
	
    

	</main>
	<a href="LogOut">ログアウト</a>
	<footer class="wrapper">© 2024 Recurrent ice cream. All rights reserved.</footer> 
</body>
</html>