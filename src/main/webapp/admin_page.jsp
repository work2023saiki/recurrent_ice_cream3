<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html lang="ja">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  	<title>Admin MyPage</title>
  <link rel="stylesheet" href="css/sidebar.css" type="text/css">
  <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/3.2.0/chart.min.js" integrity="sha512-VMsZqo0ar06BMtg0tPsdgRADvl0kDHpTbugCBBrL55KmucH6hP9zWdLIWY//OTfMnzz6xWQRxQqsUFefwHuHyg==" crossorigin="anonymous"></script>
  <script src="https://cdn.jsdelivr.net/npm/chartjs-adapter-date-fns@next/dist/chartjs-adapter-date-fns.bundle.min.js"></script>
</head>
<body>
	<header class="wrapper">
		<h1>Recurrent ice cream</h1>
	</header>
	<main class="wrapper">
	<h2 style="padding:20px">管理者専用ページ</h2>
		<div class="container">
			<ul class="link-list">
				<li><a href="ItemRegist">商品編集</a></li> <!-- 商品編集リンク -->
				<li><a href="AccountFind">アカウント編集</a></li> <!-- 会員編集リンク -->
				<li><a href="LogOut">ログアウト</a></li> <!-- ログアウトリンク -->
			</ul>
		</div> 
		<div id="content">
			<p><canvas id="mychart-bar"></canvas></p>
			<p><canvas id="mychart-pie"></canvas></p>
		</div>
	</main>
	<footer class="wrapper">© 2024 Recurrent ice cream. All rights reserved.</footer> 
	
	<!-- --------------ここからChart.js------------------ -->
	<script type="text/javascript">
		var ctx = document.getElementById('mychart-bar');
		var myChart = new Chart(ctx, {
		  type: 'bar',
		  data: {
		    labels: ['10代', '20代', '30代', '40代', '50代'],
		    datasets: [{
		      label: '超！チョコレート',
		      data: [20, 35, 40, 10,20],//売上個数
		      backgroundColor: '#6c3524',
		    }, {
		      label: 'ごろごろクッキー＆クリーム',
		      data: [20, 10, 30, 15, 25],
		      backgroundColor: '#48f',
		    }, {
		        label: 'お～い抹茶',
		        data: [30, 20, 15, 35, 10],
		        backgroundColor: '#6BBA82',
		    },{
		        label: 'しゃりしゃりいちご',
		        data: [30, 20, 15, 35, 10],
		        backgroundColor: '#e73562',
		     },{
		        label: 'ザ・プレミアムリッチバニラ',
		        data: [30, 20, 15, 35, 10],
		        backgroundColor: '#e8c59c',
		     }],
		  },
		});
		
		var ctx = document.getElementById('mychart-pie');
		var myChart = new Chart(ctx, {
		  type: 'pie',
		  data: {
		    labels: ['超！チョコレート', 'ごろごろクッキー＆クリーム','お～い抹茶','しゃりしゃりいちご','ザ・プレミアムリッチバニラ',],
		    datasets: [{
		      data: [10, 20, 15, 30, 25],
		      backgroundColor: ['#6c3524', '#48f','#6BBA82','#e73562','#e8c59c'],
		      weight: 100,
		    }],
		  },
		});
	
	</script>
</body>
</html>