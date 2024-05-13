//「スッキリわかるサーブレット＆JSP入門」P392のコード13-3を参考

package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import beans.AdminAccountBean;

//ConfigDB.javaのConfigDBクラスを継承。
//JDBC_URL、DB_USER、DB_PASSがLoginDAOクラスで使えるようになる。
public class AdminLoginDAO extends ConfigDB{
  
  //６５行目の「return accountID」ができるよう初期設定しておく。
  AdminAccountBean adminInfo = null;
  
  
  public AdminAccountBean findadminInfo(AdminAccountBean account) {
	 
	//親クラスConfigDBのメソッドを利用
	ReadJDBC_Driver();
    
    // データベースへ接続
    try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {
    	
      // SELECT文を準備。
      // アカウントテーブルからアカウント名が一致し、パスワードも一致するアカウントIDを表示。

      String sql = "SELECT * FROM 管理者 WHERE 氏名=? AND パスワード=?";
        
      PreparedStatement pStmt = conn.prepareStatement(sql);
      
      //WHERE文の?に代入
      pStmt.setString(1, account.getName());
      pStmt.setString(2, account.getPassword());
      
      System.out.println(account.getName());
      System.out.println(account.getPassword());

      
      // SELECTを実行し、結果表を取得
      ResultSet rs = pStmt.executeQuery();
      // 結果表にあるアカウントIDをaccountIDインスタンスに保存。
      while (rs.next()) {
        String adminname = rs.getString("氏名");
        
        adminInfo = new AdminAccountBean(adminname);
      }    
    }catch (SQLException e) {
      e.printStackTrace();
      return null;   //Login.javaの35行目、dao.findAccountID(account)にnullが入る。
    }                
    
  //アカウントIDを取得できたとき
  return adminInfo;   //accountIDインスタンスにアカウントIDが入っている状態。
                          
  }
}