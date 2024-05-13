<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ja">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>超！チョコレート</title>
</head>
<body>
    <div class="container">
        <div class="img"><img src="img/chocolate.jpg" alt=""></div>
        <div class="title">超！チョコレート</div>
        <div class="price">価格: ￥1000（税抜）</div>
        <div class="quantity">
            <form action="/recurrent_ice_cream/AddToCartServlet" method="post">
                <label for="quantity">数量:</label>
	            <input type="number" id="quantity" name="quantity" min="1" value="1">
	            <input type="hidden" name="productName" value="超！チョコレート">
	            <input type="submit" value="カートに追加">
            </form>
        </div>
        <a href="catalogpage.jsp" class="back-btn">戻る</a>
    </div>
</body>
</html> 