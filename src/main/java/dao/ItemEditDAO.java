//「スッキリわかるサーブレット＆JSP入門」コード13-3、コード13-5～13-9を参考

package dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import beans.ItemBean;



//アカウント情報をアカウントテーブルに新規登録するDAO
//サンプルデータがアカウントテーブルに登録されていなかったらエラーになる。
//configDB.javaを継承
public class ItemEditDAO extends ConfigDB{

	
  public void update(ItemBean item) {
	  
	//親クラスConfigDBのメソッドを利用
	//JDBCドライバーを読み込む
		ReadJDBC_Driver();
    
    // データベースへ接続
    try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {
      
    	
      // SELECT文を準備
      String sql = "UPDATE 商品 SET 商品名 = ?, 商品価格 = ?, 商品説明 = ?  WHERE 商品ID = ? ";
        
      PreparedStatement pStmt = conn.prepareStatement(sql);
      
      //WHERE文の?に代入
      pStmt.setString(1, item.getItemName());
      pStmt.setInt(2, item.getPrice());
      pStmt.setString(3, item.getItemExplain());
      pStmt.setInt(4, item.getItemID());

      pStmt.executeUpdate();
      conn.commit();
          
    }  
      //try文の中でエラーが出たとき実行する
    catch (SQLException e) {
      e.printStackTrace();   
    }
    
    
  }
}