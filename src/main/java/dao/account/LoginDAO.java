//「スッキリわかるサーブレット＆JSP入門」P392のコード13-3を参考

package dao.account;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import beans.AccountBean;
import dao.ConfigDB;
//ConfigDB.javaのConfigDBクラスを継承。
//JDBC_URL、DB_USER、DB_PASSがLoginDAOクラスで使えるようになる。
public class LoginDAO extends ConfigDB{
  
  //６５行目の「return accountInfo」ができるよう初期設定しておく。
  AccountBean accountInfo = null;
  
  
  public AccountBean findAccount(String name, String password) {
	 
	//親クラスConfigDBのメソッドを利用
	ReadJDBC_Driver();
    
    // データベースへ接続
    try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {
    	
      // SELECT文を準備。

      String sql = "SELECT アカウントID, 氏名, パスワード, メールアドレス, 性別, 生年月日, 住所  FROM アカウント WHERE 氏名=? AND パスワード=?";

        
      PreparedStatement pStmt = conn.prepareStatement(sql);
      
      //WHERE文の?に代入
      pStmt.setString(1, name);
      pStmt.setString(2, password);

      
      // SELECTを実行し、結果表を取得
      ResultSet rs = pStmt.executeQuery();
      
	      // 結果表にあるアカウント情報をaccountInfoインスタンスに保存。
	      while (rs.next()) {

	        int accountID = rs.getInt("アカウントID"); 
	    	String name2 = rs.getString("氏名");
	    	String password2 = rs.getString("パスワード");
	        String mailAd = rs.getString("メールアドレス");
	        String gender = rs.getString("性別");
	        Date birthday = rs.getDate("生年月日"); 
	        String homeAd = rs.getString("住所");
	        
	          
	        accountInfo = new AccountBean(accountID, name2, password2, mailAd, gender, birthday, homeAd);

	      }
	      
    }  
      //tryの中でエラーが出たら、catchのみ実行する
    catch (SQLException e) {
      e.printStackTrace();
    return null;   //Login.javaの35行目、dao.findAccount(account)にnullが入る。
    }                
    
  //アカウント情報を取得できたとき
  return accountInfo;   //accountInfoインスタンスにアカウント情報が入っている状態。
                          
  }
}