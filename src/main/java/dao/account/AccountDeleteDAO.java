//「スッキリわかるサーブレット＆JSP入門」P392のコード13-3を参考

package dao.account;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import dao.ConfigDB;
//ConfigDB.javaのConfigDBクラスを継承。
//JDBC_URL、DB_USER、DB_PASSがLoginDAOクラスで使えるようになる。
public class AccountDeleteDAO extends ConfigDB{
    
  public Boolean delete(int accountID) {
	 
	//親クラスConfigDBのメソッドを利用
	ReadJDBC_Driver();
    
    // データベースへ接続
    try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {
    	
      String sql = "DELETE FROM アカウント WHERE アカウントID=? ";
        
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