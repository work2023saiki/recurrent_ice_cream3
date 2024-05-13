//「スッキリわかるサーブレット＆JSP入門」P392のコード13-3を参考

package dao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
//ConfigDB.javaのConfigDBクラスを継承。
//JDBC_URL、DB_USER、DB_PASSがLoginDAOクラスで使えるようになる。
public class ItemDeleteDAO extends ConfigDB{
    
  public Boolean delete(int itemID) {
	 
	//親クラスConfigDBのメソッドを利用
	ReadJDBC_Driver();
    
    // データベースへ接続
    try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {
    	
      String sql = "DELETE FROM 商品 WHERE 商品ID=? ";
        
      PreparedStatement pStmt = conn.prepareStatement(sql);
      
      //WHERE文の?に代入
      pStmt.setInt(1, itemID);
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