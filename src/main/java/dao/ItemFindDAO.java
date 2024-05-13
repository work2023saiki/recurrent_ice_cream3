//「スッキリわかるサーブレット＆JSP入門」P392のコード13-3を参考

package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import beans.ItemBean;
//ConfigDB.javaのConfigDBクラスを継承。
//JDBC_URL、DB_USER、DB_PASSがLoginDAOクラスで使えるようになる。
public class ItemFindDAO extends ConfigDB{
  
  public List<ItemBean> findItem(String name1) {
	  
	List<ItemBean> ItemList = new ArrayList<>();  
	 
	//親クラスConfigDBのメソッドを利用
	ReadJDBC_Driver();
    
    // データベースへ接続
    try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {
    	
      // SELECT文を準備。
      //https://tech.pjin.jp/blog/2017/06/23/preparedstatement_problem_solution/
      String sql = "SELECT 商品ID, 商品名, 単価, 商品説明  FROM 商品 WHERE 商品名 like ?";

        
      PreparedStatement pStmt = conn.prepareStatement(sql);
      
      //WHERE文の?に代入。「スッキリわかるSQL入門」P86～88のlike演算子使う
      pStmt.setString(1,  "%" + name1 + "%");
      
      
      // SELECTを実行し、結果表を取得
      ResultSet rs = pStmt.executeQuery();
      
	      
	      while (rs.next()) {

	        int itemID = rs.getInt("商品ID"); 
	    	String name = rs.getString("商品名");
	    	int price = rs.getInt("単価");
	        String itemExplain = rs.getString("商品説明");
	        
	          
	        ItemBean ItemInfo = new ItemBean(itemID, name, price, itemExplain);
	        ItemList.add(ItemInfo);
	        
	      }      
	      
    }  
      //tryの中でエラーが出たら、catchのみ実行する
    catch (SQLException e) {
      e.printStackTrace();
    return null;   
    }                
    
  //アカウント情報を取得できたとき
  return ItemList;                            
  }
}