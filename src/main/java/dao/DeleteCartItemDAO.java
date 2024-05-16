//「スッキリわかるサーブレット＆JSP入門」P392のコード13-3を参考

package dao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;



public class DeleteCartItemDAO extends ConfigDB{
  //削除ボタンを押して、買わない商品を削除する。  
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
  
  
  
  //注文確定ボタンを押したら、仮注文テーブルのログインアカウントの分を削除
  public Boolean deleteAll(int accountID) {
		 
		//親クラスConfigDBのメソッドを利用
		ReadJDBC_Driver();
	    
	    // データベースへ接続
	    try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {
	    	
	      String sql = "DELETE FROM 仮注文 WHERE アカウントID = ? ";
	        
	      PreparedStatement pStmt = conn.prepareStatement(sql);
	      
	      //WHERE文の?に代入
	      pStmt.setInt(1, accountID);
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