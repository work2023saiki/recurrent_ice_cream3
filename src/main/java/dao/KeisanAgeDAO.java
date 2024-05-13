//「スッキリわかるサーブレット＆JSP入門」P392のコード13-3を参考

package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import beans.AccountBean;
//ConfigDB.javaのConfigDBクラスを継承。
//JDBC_URL、DB_USER、DB_PASSがLoginDAOクラスで使えるようになる。
public class KeisanAgeDAO extends ConfigDB{
  
  public List<AccountBean> findAccount() {
	  
	List<AccountBean> AccountList = new ArrayList<>();  
	 
	//親クラスConfigDBのメソッドを利用
	ReadJDBC_Driver();
    
    // データベースへ接続
    try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {
    	
      // SELECT文を準備。
      //https://tech.pjin.jp/blog/2017/06/23/preparedstatement_problem_solution/
      String sql = "SELECT 氏名, 性別, 生年月日, 住所 FROM アカウント";

        
      PreparedStatement pStmt = conn.prepareStatement(sql);
      
      // SELECTを実行し、結果表を取得
      ResultSet rs = pStmt.executeQuery();
      
      
      SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
      
      //https://qiita.com/t_t238/items/5db1c6ca131a61ebd6ae
      // 現在日時を取得
      LocalDateTime nowDate = LocalDateTime.now();
      // 表示形式を指定
      DateTimeFormatter dtf =
          DateTimeFormatter.ofPattern("yyyyMMdd");
              String NowDate1 = dtf.format(nowDate);
              
              int NowDate = Integer.valueOf(NowDate1);
              
	      while (rs.next()) {
	        String name = rs.getString("氏名");
	        String gender = rs.getString("性別");
	        Date birthday = rs.getDate("生年月日");
	        String homeAd = rs.getString("住所");
	        
	        //Date型をString型に変更
	        String birthday1 = dateFormat.format(birthday);
	        //String型をint型に変更
	        int birth = Integer.valueOf(birthday1);
	        //計算して小数点以下切り捨て
	        double age = Math.floor( (NowDate - birth) / 10000); 
	     
	          
	        AccountBean accountInfo = new AccountBean(name, gender, age, homeAd);
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