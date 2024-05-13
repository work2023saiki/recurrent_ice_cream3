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
public class ItemRegisterDAO extends ConfigDB{

	
  public boolean itemRegist(ItemBean item) {
	  
	//親クラスConfigDBのメソッドを利用
	//JDBCドライバーを読み込む
		ReadJDBC_Driver();
    
    // データベースへ接続
    try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {
      
      // SELECT文を準備
      String sql = "INSERT INTO 商品(商品名, 単価, 商品説明)\r\n"
      		        + "VALUES (?, ?, ?)";
        
      PreparedStatement pStmt = conn.prepareStatement(sql);
      
      
      //WHERE文の?に代入
      pStmt.setString(1, item.getItemName());
      pStmt.setInt(2, item.getPrice());
      pStmt.setString(3, item.getItemExplain());
      
      // INSERT文を実行（resultには追加された行数が代入される）
      int result = pStmt.executeUpdate();
      if (result != 1) {
        return false;
      }
	      
    }  
      //try文の中でエラーが出たとき実行する
    catch (SQLException e) {
      e.printStackTrace();
      return false;
    }
    
    //できたとき
    return true;
  }
}