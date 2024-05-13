<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    <!DOCTYPE html>
<html lang="ja">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Recurrent ice cream</title>
    <link rel="stylesheet" href="css/style.css" type="text/css">
</head>
<body>
    <header class="wrapper">
        <h1>Recurrent ice cream</h1>
    </header>
    <main class="wrapper">
    <h2>商品一覧</h2>
    
    
    <form action="Order" method="post">
    <div class="container">
        <div class="item">
            <a href="chocolate.jsp">
                <div class="img"><img src="img/chocolate.jpg" alt=""></div>
                <div class="title">超！チョコレート</div>
            </a>
            <div class="price">¥1000</div>
            <div class="quantity">
                <input type="number" name="orderNum1" value="0" min="0" max="10" required>
            </div>
            <input type="hidden" name="超！チョコレート" value="0">
        </div>
        
        <div class="item">
            <div class="img"><img src="img/cookieandcream.jpg" alt=""></div>
            <div class="title">ゴロゴロクッキーアンドクリーム</div>
            <div class="price">¥1000</div>
            <div class="quantity">
                <input type="number" name="orderNum2" value="0" min="0" max="10" required>
            </div>
            <input type="hidden" name="ゴロゴロクッキーアンドクリーム" value="1">
        </div>
        
        <div class="item">
            <div class="img"><img src="img/matcha.jpg" alt=""></div>
            <div class="title">おーい抹茶</div>
            <div class="price">¥1000</div>
            <div class="quantity">
                <input type="number" name="orderNum3" value="0" min="0" max="10" required>
            </div>
            <input type="hidden" name="おーい抹茶" value="2">
        </div>
        
        <div class="item">
            <div class="img"><img src="img/strawberry.png" alt=""></div>
            <div class="title">しゃりしゃりいちご</div>
            <div class="price">¥1000</div>
            <div class="quantity">
                <input type="number" name="orderNum4" value="0" min="0" max="10" required>
            </div>
            <input type="hidden" name="しゃりしゃりいちご" value="3">
        </div>
        
        <div class="item">
            <div class="img"><img src="img/vanilla.jpeg" alt=""></div>
            <div class="title">ザ・プレミアムリッチバニラ</div>
            <div class="price">¥1000</div>
            <div class="quantity">
            	<input type="number" name="orderNum5" value="0" min="0" max="10" required>
            </div>
            <input type="hidden" name="ザ・プレミアムリッチバニラ" value="4">
        </div>
    </div>
    <button type="submit" name="add_to_cart_all" value="true">まとめてカートに追加</button>
    </form>
</main>

            <a href="LogOut">topページへ戻る</a>
            <a href="User_mypage">マイページへ</a>
    <footer class="wrapper">© 2024 Recurrent ice cream. All rights reserved.</footer>
</body>
</html>