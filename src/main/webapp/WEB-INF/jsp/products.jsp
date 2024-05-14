<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ja">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Recurrent ice cream</title>
    <link rel="stylesheet" href="css/style.css" type="text/css">
</head>
	<body>
		<script>
		// 商品と画像を関連つけるための関数
			function assignImagesToProducts() {
			    // 商品名と画像の対応関係をオブジェクトで定義する
			    var productImages = {
			        "超！チョコレート": "chocolate.jpg",
			        "ゴロゴロクッキーアンドクリーム": "cookieandcream.jpg",
			        "おーい抹茶": "matcha.jpg",
			        "しゃりしゃりいちご": "strawberry.png",
			        "ザ・プレミアムリッチバニラ": "vanilla.jpeg"
			    };
			    // 各商品名のセルを取得し、画像を割り当てる
			    var titleCells = document.querySelectorAll('.title');
			    titleCells.forEach(function(cell) {
			        var productName = cell.textContent.trim();
			        if (productImages.hasOwnProperty(productName)) {
			            var imgDiv = document.createElement('div');
			            imgDiv.className = 'img';
			            var img = document.createElement('img');
			            img.src = 'img/' + productImages[productName];
			            img.alt = productName;
			            imgDiv.appendChild(img);
			            // 商品名のセルの後に画像を挿入する
			            cell.parentNode.insertBefore(imgDiv, cell.nextSibling);
			        }
			    });
			}
	
			// ページが読み込まれた後に画像を商品に割り当てる
			window.onload = assignImagesToProducts;		
		</script>
    <header class="wrapper">
       	<h1>Recurrent ice cream</h1>
   	</header>
    <main class="wrapper">
    	<h2>商品一覧</h2>
		    <form action="AddToCartServlet" method="post">
        <table border="1">
            <tr>
                <th>商品ID</th>
                <th>商品名</th>
                <th>単価</th>
                <th>商品説明</th>
                <th>数量</th>
            </tr>
            <c:forEach var="product" items="${products}" varStatus="status">
                <tr>
                    <td><c:out value="${product.id}" /></td>
                    <td><c:out value="${product.name}" /></td>
                    <td><c:out value="${product.price}" /></td>
                    <td><c:out value="${product.description}" /></td> <!-- 商品説明を追加 -->
                    <td>
                        <select name= "${status.index}" >
                            <c:forEach begin="0" end="10" var="num">
                                <option value="${num}">${num}</option>
                            </c:forEach>
                        </select>
                    </td>
                </tr>
            </c:forEach>
        </table>
        <input type="submit" name="商品ID" value="まとめてカートに入れる" />
    </form>
	</main>
            <a href="top.jsp">topページへ戻る</a>
            <a href="User_mypage">マイページへ</a>
    <footer class="wrapper">© 2024 Recurrent ice cream. All rights reserved.</footer>
</body>
</html> 