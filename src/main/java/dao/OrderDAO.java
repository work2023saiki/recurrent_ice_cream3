//「スッキリわかるサーブレット＆JSP入門」コード13-3、コード13-5～13-9を参考

package dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import beans.KariOrderBean;



//アカウント情報をアカウントテーブルに新規登録するDAO
//サンプルデータがアカウントテーブルに登録されていなかったらエラーになる。
//configDB.javaを継承
public class OrderDAO extends ConfigDB{

	
  public boolean kariOrder(KariOrderBean account) {
	  
		ReadJDBC_Driver();
    
    // データベースへ接続
    try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {
      
      
      // SELECT文を準備
      String sql = "INSERT INTO 仮注文 (アカウントID, 商品ID, 個数)\r\n"
      		        + "VALUES (?, ?, ?)";
        
      PreparedStatement pStmt = conn.prepareStatement(sql);
      
      
      //WHERE文の?に代入
      pStmt.setInt(1, account.getAccountID());
      //pStmt.setString(2, account.getItemID);
      pStmt.setString(3, account.getOrderNum1());
      
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