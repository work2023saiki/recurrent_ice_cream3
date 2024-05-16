
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
public class BowDashboardDAO extends ConfigDB{


    DashboardBean dashboardInfo = null;      
	 
	    //親クラスConfigDBのメソッドを利用    	    

	    public List<DashboardBean> getAllDashboards(int nendai) throws SQLException {
	    	ReadJDBC_Driver();
	    	
            List<DashboardBean> dashboard = new ArrayList<>();    

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
            	//商品名と個数表示
            	String sql = "select 個数, 商品名,年代 "
    		      		+ "from 購入記録 "
    		      		+ "join 商品 "
    		      		+ "on 購入記録.商品ID = 商品.商品ID "
    		      		+ "where 年代 = ?";
    		      	//	+ "order by 年代";
            	
//            	+------+--------------------------------+------+
//            	| 個数 | 商品名                         	| 年代 	|
//            	+------+--------------------------------+------+
//            	|    3 | 超！チョコレート                		|  	20 	|
//            	|    4 | ゴロゴロクッキーアンドクリーム		    	|   30 	|
//            	|    5 | おーい抹茶                   		|   10 	|
//            	|    6 | しゃりしゃりいちご          			|   50	|
//            	|    7 | ザ・プレミアムリッチバニラ    			|   40 	|
//            	|    8 | 超！チョコレート               		|   30 	|
//            	|    2 | ゴロゴロクッキーアンドクリーム 			|   20 	|
//            	+------+--------------------------------+------+

	             PreparedStatement pStmt = conn.prepareStatement(sql);
	             pStmt.setInt(1, nendai);
			     // SELECTを実行し、結果表を取得
			     ResultSet rs = pStmt.executeQuery();
      
				      // 結果表にあるアカウント情報をdashboardInfoインスタンスに保存。
				      while (rs.next()) {
				    	
				        int number = rs.getInt("個数"); 
			            String itemName = rs.getString("商品名");
			            int nendai2 = rs.getInt("年代");
					       
			            dashboardInfo = new DashboardBean(number,itemName,nendai2);
				        dashboard.add(dashboardInfo);
				      } 
            }
	         
		    //tryの中でエラーが出たら、catchのみ実行する
		    catch (SQLException e) {
		      e.printStackTrace();
		    return null;   
		    }                
    
			//アカウント情報を取得できたとき
			return dashboard;
                          
    }
  
}


