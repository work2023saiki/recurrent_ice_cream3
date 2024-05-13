<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ja">
<head>
    <title>Recurrent ice cream</title>
    <link rel="stylesheet" href="css/top.css" type="text/css">
</head>
<body>
   <header class="wrapper">
        <h1>Recurrent ice cream</h1>
        <nav>
            <ul>
                <li><a href="Login">ログイン</a></li> <!-- ログインリンク -->
                <li><a href="Register">会員登録</a></li> <!-- アカウント登録リンク -->
                <li><a href="AdminLogin">管理者</a></li> <!-- 管理者ログイン -->
            </ul>
        </nav>
    </header>

    <!-- スライドショー -->
    <div class="slideshow-container">
        <div class="mySlides fade">
            <img src="img/chocolate.jpg">
        </div>
        <div class="mySlides fade">
            <img src="img/cookieandcream.jpg">
        </div>
        <div class="mySlides fade">
            <img src="img/matcha.jpg">
        </div>
        <div class="mySlides fade">
            <img src="img/strawberry.png">
        </div>
        <div class="mySlides fade">
            <img src="img/vanilla.jpeg">
        </div>
    </div>
    <br>
    <!-- スライドショーのナビゲーションドット -->
    <div style="text-align:center">
        <span class="dot" onclick="currentSlide(1)"></span>
        <span class="dot" onclick="currentSlide(2)"></span>
        <span class="dot" onclick="currentSlide(3)"></span>
        <span class="dot" onclick="currentSlide(4)"></span>
        <span class="dot" onclick="currentSlide(5)"></span>
    </div>
    <!-- フッター -->
    <footer class="wrapper">© 2024 Recurrent ice cream. All rights reserved.</footer>

    <!-- スライドショーの機能に関するJavaScript -->
    <script>
        var slideIndex = 1;
        showSlides(slideIndex);

        // 自動スライドショータイマー
        var slideTimer = setInterval(function() {
            plusSlides(1);
        }, 5000); // 5000ミリ秒 = 5秒、必要に応じて調整

        // 次のスライドに移動する関数
        function plusSlides(n) {
            clearInterval(slideTimer);
            slideTimer = setInterval(function() {
                plusSlides(1);
            }, 5000); // タイマーをリセット
            showSlides(slideIndex += n);
        }

        // 特定のスライドを表示する関数
        function currentSlide(n) {
            clearInterval(slideTimer);
            slideTimer = setInterval(function() {
                plusSlides(1);
            }, 5000); // タイマーをリセット
            showSlides(slideIndex = n);
        }

        // スライドを表示する関数
        function showSlides(n) {
            var i;
            var slides = document.getElementsByClassName("mySlides");
            var dots = document.getElementsByClassName("dot");
            if (n > slides.length) {slideIndex = 1}
            if (n < 1) {slideIndex = slides.length}
            for (i = 0; i < slides.length; i++) {
                slides[i].style.display = "none";
            }
            for (i = 0; i < dots.length; i++) {
                dots[i].className = dots[i].className.replace(" active", "");
            }
            slides[slideIndex-1].style.display = "block";
            dots[slideIndex-1].className += " active";
        }
    </script>
</body>
</html>


