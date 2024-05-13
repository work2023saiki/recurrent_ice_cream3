package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import beans.PurchaseBean;

public class PurchaseDAO extends ConfigDB {
  
    public boolean create(PurchaseBean purchase) {
        // JDBCドライバを読み込む
        ReadJDBC_Driver();

        // データベースに接続
        try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {


            String sql = "INSERT INTO 購入記録 (アカウントID, 商品ID, 個数, 購入日) VALUES (?, ?, ?, ?)";
            try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setInt(1, purchase.getaccountID());
                pstmt.setInt(2, purchase.getitemID());
                pstmt.setInt(3, purchase.getnumber());
                pstmt.setDate(4, new java.sql.Date(purchase.getbuyDate().getTime())); // 購入日
                pstmt.executeUpdate();
                return true; // 挿入成功
            }
        } catch (SQLException e) {
            e.printStackTrace(); // 適切に例外処理を行う

        }
        return false; // 挿入失敗
    }
}