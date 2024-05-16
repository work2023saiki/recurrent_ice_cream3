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
    <script src="https://yubinbango.github.io/yubinbango/yubinbango.js"></script>
    <title>アカウント登録</title>
    <link rel="stylesheet" href="css/style.css" type="text/css">
    <style>
        .error-message {
            color: red;
        }
    </style>
    <script>
        window.onload = function () {
            var postalCodeInput = document.querySelector('.p-postal-code');

            postalCodeInput.addEventListener('input', function () {
                var postalCode = this.value;

                YubinBango.fetch(postalCode, function(addr) {
                    document.querySelector('.p-region').value = addr.region;
                    document.querySelector('.p-locality').value = addr.locality;
                    document.querySelector('.p-street-address').value = addr.street;
                });
            });
        };

        
    </script>
</head>
<body>
    <header class="wrapper">
        <h1>Recurrent ice cream</h1>
    </header>
    <main class="wrapper">
        <div class="container">
        
            <% //P306の29～31行目を参照。errorMsgが空っぽでないなら %>
	        <% if (errorMsg != null) { %>
	        
	        <p><font color="red"><%= errorMsg %></font></p>
	        
	        <% } %>
            
            <form name="registration" action="Register" method="post">
                <h2>会員登録</h2><br>
                <p>名前</p>
                <input type="text" name="name" maxlength="10" placeholder="山田太郎" required>
                
                <p>メールアドレス</p>
                <input type="text" name="mailAd" maxlength="254" placeholder="aaaa@gmail.com" required>
                
                <p>パスワード <span style="font-size: 12px"></span></p>
                <input type="password" name="password" maxlength="30" placeholder="パスワード" required><br>
                
                <label>〒</label>
                <input type="text" class="p-postal-code" size="8" maxlength="8"><br>
                <label for="address">住所</label>
                <input id="address" type="text" name="building1"class="p-region p-locality p-street-address p-extended-address"  required><br>
                <label for="building">番地/建物名</label>
                <input id="building" type="text" name="building2" placeholder="番地/建物名" required>
                
                <p>性別</p><br>
                <input id="male" type="radio" name="gender" value="男性"  required>男性
                <input id="female" type="radio" name="gender" value="女性"  required>女性

                <p>生年月日</p>
                <div style="display: flex;">
	                <select name="birth_year" required>
	                    <option value="">年</option>
	                    <script>
	                        var currentYear = new Date().getFullYear();
	                        for (var i = currentYear; i >= currentYear - 100; i--) {
	                            document.write('<option value="' + i + '">' + i + '</option>');
	                        }
	                    </script>
	                </select>
	                <select name="birth_month" required>
	                    <option value="">月</option>
	                    <script>
	                        for (var i = 1; i <= 12; i++) {
	                            document.write('<option value="' + i + '">' + i + '</option>');
	                        }
	                    </script>
	                </select>
	                <select name="birth_day" required>
	                    <option value="">日</option>
	                    <script>
	                        for (var i = 1; i <= 31; i++) {
	                            document.write('<option value="' + i + '">' + i + '</option>');
	                        }
	                    </script>
	                </select>
              	</div>
                <p><input type="submit" value="登録する"></p>     
                
            </form>
        </div>
    </main>
    <a href="top.jsp">TOPページへ</a>
    <footer class="wrapper">© 2024 Recurrent ice cream. All rights reserved.</footer>
</body>
</html>
 
 