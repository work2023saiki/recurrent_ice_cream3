//「スッキリわかるサーブレット＆JSP入門」P392のコード13-3を参考

package dao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

//注文確定ボタンを押したら、仮注文テーブルのログインアカウントの分だけ削除。
public class DeleteCartItemDAO extends ConfigDB{
    
  public Boolean delete(int kariID) {
	 
	//親クラスConfigDBのメソッドを利用
	ReadJDBC_Driver();
    
    // データベースへ接続
    try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {
    	
      String sql = "DELETE FROM 仮注文 WHERE 仮注文ID = ? ";
        
      PreparedStatement pStmt = conn.prepareStatement(sql);
      
      //WHERE文の?に代入
      pStmt.setInt(1, kariID);
      //SQL実行
      pStmt.executeUpdate();
		      
    }  
      //tryの中でエラーが出たら、catchのみ実行する
    catch (SQLException e) {
      e.printStackTrace();
      return false;
    }           
    
    return true;                      
  }

}