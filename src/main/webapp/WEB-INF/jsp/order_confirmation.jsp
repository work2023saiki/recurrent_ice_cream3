<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="ja">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>注文内容確認</title>
    <link rel="stylesheet" href="css/style.css" type="text/css">
</head>
<body>
	<header class="wrapper">
    	<h1>Recurrent ice cream</h1>
    </header>
	<main class="wrapper">
    <h2>注文内容確認</h2>
    


    <c:forEach var="cart2" items="${cart}" varStatus="status">
    
      <form action="DeleteCartItem" method="post">
	    <table border="1" class="centered-table">
	        <tr>
	            <th>商品名</th>
	            <td><c:out value="${cart2.itemName}" /></td>
	        </tr>
	        <tr>
	            <th>選択した個数</th>
	            <td><c:out value="${cart2.number}" />個</td>
	        </tr>
	        <tr>
	            <th>金額</th>
	            <td>￥<c:out value="${cart2.totalPrice}" /></td>
	        </tr>
	        
	        <c:set value="${ alltotal + cart2.totalPrice }" var="alltotal"></c:set>
	        <input type="hidden" name="loopIndex" value=<c:out value="${status.index}"/>>

	    </table>
	    
	    
	    <button type="submit" name="button" value=<c:out value="${cart2.kariID}"/> >削除</button>
	    
	    </form>
	    
	    
	    </br></br></br>
	    
    </c:forEach>

    <p> 合計金額：<c:out value="${alltotal}" /> 円</p>
    </br></br></br>

    <!-- お届け先情報 -->
    <h2>お届け先</h2>
    <table border="1" class="centered-table">
        <tr>
            <th>お名前</th>
            <td><c:out value="${accountInfo.name}" /> 様</td>
        </tr>
        <tr>
            <th>お届け先</th>
            <td><c:out value="${accountInfo.homeAddress}" /></td>
        </tr>
        <tr>
            <th>メールアドレス</th>
            <td><c:out value="${accountInfo.mailAd}" /></td>
        </tr>
    </table>

    <!-- 注文確定ボタン -->
    <form action="OrderComplete" method="post">
        <input type="submit" value="注文確定">
    </form>
    

    </main>
        <!-- 商品一覧へのリンク -->
    <a href="ProductServlet">商品一覧へ</a>
    
    <!-- TOPページへのリンク -->
    <a href="LogOut">TOPページへ</a>
    <footer class="wrapper">© 2024 Recurrent ice cream. All rights reserved.</footer>
</body>
</html>