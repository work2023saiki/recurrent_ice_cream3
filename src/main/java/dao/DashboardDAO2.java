
    //「スッキリわかるサーブレット＆JSP入門」P392のコード13-3を参考

package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import beans.DashboardBean;
//ConfigDB.javaのConfigDBクラスを継承。
//JDBC_URL、DB_USER、DB_PASSがLoginDAOクラスで使えるようになる。
public class DashboardDAO2 extends ConfigDB{
  
    //６５行目の「return accountInfo」ができるよう初期設定しておく。
    DashboardBean dashboardInfo = null;
   
	    //親クラスConfigDBのメソッドを利用
	
	    
	    public List<DashboardBean> getAllDashboards() throws SQLException {
            List<DashboardBean> dashboard = new ArrayList<>();  
            ReadJDBC_Driver();
	
            // データベースへ接続
            try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {
    	
	        	// SELECT文を準備
//	        	String sql = "select 性別, 生年月日, 個数, 商品名 "
//		      		+ "from 購入記録 "
//		      		+ "join ユーザー "
//		      		+ "on 購入記録.アカウントID = ユーザー.アカウントID "
//		      		+ "join 商品 "
//		      		+ "on 購入記録.商品ID = 商品.商品ID ";
	        
            	// SELECT文を準備
            	//商品ID=1を購入した個数を男女別に表示
            	String sql2 = "select 性別,sum(個数) as 男女別の個数合計\r\n"
            		    + "from 購入記録\r\n"
            		    + "where 商品ID = 2\r\n"
            		    + "group by 性別" ;
            	
            	
            	
//            	+------+------------------+
//            	| 性別 | 男女別の個数合計 |
//            	+------+------------------+
//            	| 男性 |                3 |
//            	| 女性 |                8 |
//            	+------+------------------+
      	
	             PreparedStatement pStmt = conn.prepareStatement(sql2);
      
			     // SELECTを実行し、結果表を取得
			     ResultSet rs2 = pStmt.executeQuery();
      
				      // 結果表にあるアカウント情報をdashboardInfoインスタンスに保存。
				      while (rs2.next()) {
			    
				        String gender = rs2.getString("性別"); 
			            int number = rs2.getInt("男女別の個数合計");
				        
			            dashboardInfo = new DashboardBean(gender, number);
				        dashboard.add(dashboardInfo);
				        
				      } 
            }
	         
		    //tryの中でエラーが出たら、catchのみ実行する
		    catch (SQLException e) {
		      e.printStackTrace();
		    return null;   //Login.javaの35行目、dao.findAccount(account)にnullが入る。
		    }                
    
	  //アカウント情報を取得できたとき
	  return dashboard;   //accountInfoインスタンスにアカウント情報が入っている状態。
                          
    }
  
}


