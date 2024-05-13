//「スッキリわかるサーブレット＆JSP入門」P392のコード13-3を参考

package dao.account;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import beans.AccountBean;
import dao.ConfigDB;
//ConfigDB.javaのConfigDBクラスを継承。
//JDBC_URL、DB_USER、DB_PASSがLoginDAOクラスで使えるようになる。
public class AccountFindDAO extends ConfigDB{
  
  public List<AccountBean> findAccount(String name1) {
	  
	List<AccountBean> AccountList = new ArrayList<>();  
	 
	//親クラスConfigDBのメソッドを利用
	ReadJDBC_Driver();
    
    // データベースへ接続
    try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {
    	
      // SELECT文を準備。
      //https://tech.pjin.jp/blog/2017/06/23/preparedstatement_problem_solution/
      String sql = "SELECT アカウントID, 氏名, パスワード, メールアドレス, 性別, 生年月日, 住所  FROM アカウント WHERE 氏名 like ? ";

        
      PreparedStatement pStmt = conn.prepareStatement(sql);
      
      //WHERE文の?に代入。「スッキリわかるSQL入門」P86～88のlike演算子使う
      pStmt.setString(1,  "%" + name1 + "%");
      
      
      // SELECTを実行し、結果表を取得
      ResultSet rs = pStmt.executeQuery();
      
      
	      
	      while (rs.next()) {

	        int accountID = rs.getInt("アカウントID"); 
	    	String name = rs.getString("氏名");
	    	String password = rs.getString("パスワード");
	        String mailAd = rs.getString("メールアドレス");
	        String gender = rs.getString("性別");
	        Date birthday = rs.getDate("生年月日"); 
	        String homeAd = rs.getString("住所");
	        
	          
	        AccountBean accountInfo = new AccountBean(accountID, name, password, mailAd, gender, birthday, homeAd);
	        AccountList.add(accountInfo);
	        
	      }
	      
	      
	      
    }  
      //tryの中でエラーが出たら、catchのみ実行する
    catch (SQLException e) {
      e.printStackTrace();
    return null;   
    }                
    
  //アカウント情報を取得できたとき
  return AccountList;                            
  }

  
}