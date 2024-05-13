/* テーブルを作成するSQL。仮注文登録できたらこのテーブルに情報を入れる。

*/

CREATE TABLE 仮注文 (仮注文ID INTEGER  NOT NULL AUTO_INCREMENT,
アカウントID INTEGER(10)  NOT NULL,
商品ID INTEGER(5) NOT NULL,
個数 INTEGER(5)  NOT NULL,

PRIMARY KEY (仮注文ID),
FOREIGN KEY (アカウントID) REFERENCES アカウント(アカウントID),
FOREIGN KEY (商品ID) REFERENCES 商品(商品ID)
);

/*
SELECT 個数 FROM 仮注文
LEFT JOIN アカウント
ON　仮注文.アカウントID = アカウント.アカウントID
LEFT JOIN 商品
ON 仮注文.商品ID = 商品.商品ID
*/

SELECT * FROM 仮注文 JOIN 商品 ON 商品.商品ID = 仮注文.商品ID;

