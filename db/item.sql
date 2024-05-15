/* 商品テーブルを作成するSQL。新規商品を登録できたらこのテーブルに情報を入れる。

*/

CREATE TABLE 商品 (商品ID INTEGER(5)  NOT NULL AUTO_INCREMENT,
商品名 VARCHAR(50)  NOT NULL UNIQUE,
商品価格 INTEGER(5) NOT NULL,
商品説明 VARCHAR(1000),

PRIMARY KEY (商品ID)
);

INSERT INTO 商品 (商品名, 商品価格, 商品説明)
     VALUES ('超！チョコレート', 1000, 'チョコ'),
            ('ゴロゴロクッキーアンドクリーム', 1000, 'クッキーアンドクリーム'),
            ('おーい抹茶', 1000, '抹茶'),
            ('しゃりしゃりいちご', 1000, 'いちご'),
            ('ザ・プレミアムリッチバニラ', 1000, 'バニラ');
