package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import beans.PurchaseBean;



public class CartShowDAO extends ConfigDB {
  
    public List<PurchaseBean> cartInfo(int accountID) {
    	
    	List<PurchaseBean> cartList = new ArrayList<>(); 
    	
        // JDBCドライバを読み込む
        ReadJDBC_Driver();

        // データベースに接続
        try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {


            String sql = "SELECT 仮注文ID, 仮注文.商品ID, 商品名, 個数, 商品価格 * 個数 AS 合計金額   \n"
            		+ "FROM 仮注文 \n"
            		+ "JOIN 商品\n"
            		+ "ON 商品.商品ID = 仮注文.商品ID\n"
            		+ "WHERE アカウントID = ?";
            
            PreparedStatement pStmt = conn.prepareStatement(sql);
            
            pStmt.setInt(1, accountID);
            
         // SELECTを実行し、結果表を取得
            ResultSet rs = pStmt.executeQuery();
            
              	      
      	      while (rs.next()) {
      	    	int kariID = rs.getInt("仮注文ID");
      	    	int ItemID = rs.getInt("商品ID"); 
      	    	String name = rs.getString("商品名");
      	    	int kosu = rs.getInt("個数");
      	    	int TotalPrice = rs.getInt("合計金額");    
      	          
      	        PurchaseBean purchase = new PurchaseBean(kariID, ItemID, name, kosu, TotalPrice);
      	        cartList.add(purchase);
      	        
      	      }
      	      
            return cartList;
            
        } catch (SQLException e) {
            e.printStackTrace(); // 適切に例外処理を行う
          return null; // 挿入失敗
        }
        
    }
}