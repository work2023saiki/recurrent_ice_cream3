<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<% //教科書P366、P449参考  %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
 

 
<!DOCTYPE html>
<html lang="ja">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>登録アカウントの確認、編集</title>
    <link rel="stylesheet" href="css/top.css" type="text/css">
</head>
<body>
<header class="wrapper">
	<h1>Recurrent ice cream</h1>
</header>
<main class="wrapper">

    <form action="AccountFind" method="post">
        
        
        <p>アカウントの登録、編集、検索、削除ができるページです</p></br>
        <div class="search">
            <p>氏名:
            <input type="text" name="氏名" required>
            <button type="submit">検索</button>
            </p>
            </br>
            <a href="Register">アカウント登録ページへ</a>
        </div>
        
    </form>
    
    <c:if test="${not empty Msg}">
    
      <p><font color="blue"><c:out value="${Msg}" /></font></p>
    
    </c:if> 
    
    <c:if test="${not empty errorMsg}">
    
      <p><font color="red"><c:out value="${errorMsg}" /></font></p>
    
    </c:if> 
    
    
    <c:if test="${not empty accountList }">
    <table border="1">
		
		    <tr>
		        <th>アカウントID</th>
		        <th>氏名</th>
		        <th>メールアドレス</th>
		        <th>性別</th>
		        <th>生年月日</th>
		        <th>住所</th>
		    </tr>
	
		    <c:forEach var="account" items="${accountList}" varStatus="status">
		        <tr>
		        <% //https://qiita.com/shun_tech/items/1fd16b5209e593e668b0  %>
		        <form action="?" method="post">
		            <td><c:out value="${account.accountID}" /></td>
		            <td><c:out value="${account.name}" /></td>
		            <td><c:out value="${account.mailAd}" /></td>
		            <td><c:out value="${account.gender}"/></td>
		            <td><c:out value="${account.birth}"/></td>
		            <td><c:out value="${account.homeAddress}"/></td>
		            <td><button type="submit" formaction="MyPageEdit2">編集</button></td>
		            <td><button type="submit" name="button" value=<c:out value="${account.accountID}"/> formaction="DeleteAccount2">削除</button></td>
                 
                    <input type="hidden" name="loopIndex" value=<c:out value="${status.index}"/>>	        
		        </form>
		        
		        </tr>
		    </c:forEach>
		</table>
		
	</c:if>
	
	</br></br>
	<a href="LogOut">ログアウト</a>
		
</main>
<footer class="wrapper">© 2024 Recurrent ice cream. All rights reserved.</footer> 
   
</body>
</html>