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
            <form class="h-adr">
            <form name="registration" action="Register" method="post">
                <h2>会員登録</h2>
                <p>名前</p>
                <input type="text" name="name" maxlength="10" placeholder="山田太郎" required>
                
                <p>メールアドレス</p>
                <input type="text" name="mailAd" maxlength="254" placeholder="aaaa@gmail.com" required>
                
                <p>パスワード <span style="font-size: 12px"></span></p>
                <input type="password" name="password" maxlength="30" placeholder="パスワード" required><br>
 
                <p>性別</p>
                <input id="male" type="radio" name="gender" value="男性"  required>男性
                <input id="female" type="radio" name="gender" value="女性"  required>女性
                <p>生年月日</p>
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
				<span class="p-country-name" style="display:none;">Japan</span>
                    <label>
                    <p>住所</p>
                    <span>郵便番号</span>
                    <input type="text" class="p-postal-code" size="3" maxlength="3">-<input type="text" class="p-postal-code" size="4" maxlength="4"><br>
              		</label>
                    <label>
                      <span>都道府県</span>
                      <input type="text" class="p-region" readonly /><br>
                    </label>
                    <label>
                      <span>市町村区</span>
                      <input type="text" class="p-locality" readonly /><br>
                    </label>
                    <label>
                      <span>町域</span>
                      <input type="text" class="p-street-address" /><br>
                    </label>
                    <label>
                      <span>以降の住所</span>
                      <input type="text" class="p-extended-address" />
                    </label>
                  </form></form>
               
            </form></form>
            
        </div>
        <input type="submit" value="会員登録を行う">   
          <a href="top.jsp" style="display: block; margin-top: 10px;">topページへ戻る</a>
    </main>
    <footer class="wrapper">© 2024 Recurrent ice cream. All rights reserved.</footer>
</body>
</html>
 