/* テーブルを作成するSQL。アカウント登録できたらこのテーブルに情報を入れる。

*/
select 性別,sum(個数) as 男女別の個数合計\r\n"
            		    + "from 購入記録\r\n"
            		    + "where 商品ID = 1\r\n"
            		    + "group by 商品ID,性別;