package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;



public class CartShowDAO extends ConfigDB {
  
    public boolean show(int accountID, int itemID, int kosu) {
        // JDBCドライバを読み込む
        ReadJDBC_Driver();

        // データベースに接続
        try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {


            String sql = "INSERT INTO 仮注文 (アカウントID, 商品ID, 個数) VALUES (?, ?, ?)";
            try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setInt(1, accountID);
                pstmt.setInt(2, itemID);
                pstmt.setInt(3, kosu);
                
                pstmt.executeUpdate();
                return true; // 挿入成功
            }
        } catch (SQLException e) {
            e.printStackTrace(); // 適切に例外処理を行う
          return false; // 挿入失敗
        }
        
    }
}