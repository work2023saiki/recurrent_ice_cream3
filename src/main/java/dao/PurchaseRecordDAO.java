package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import beans.PurchaseBean;


//「まとめてカートに入れる」ボタンを押したとき、購入記録テーブルに記録するDAO。
public class PurchaseRecordDAO extends ConfigDB {
  
    public boolean addRecord(PurchaseBean rec) {
        // JDBCドライバを読み込む
        ReadJDBC_Driver();

        // データベースに接続
        try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {


            String sql = "INSERT INTO 購入記録 (アカウントID, 商品ID, 個数, 購入日) VALUES (?, ?, ?, ?)";
            try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setInt(1, rec.getAccountID());
                pstmt.setInt(2, rec.getItemID());
                pstmt.setInt(3, rec.getNumber());
                pstmt.setDate(4, rec.getBuyDate());
                
                pstmt.executeUpdate();
                return true; // 挿入成功
            }
        } catch (SQLException e) {
            e.printStackTrace(); // 適切に例外処理を行う
          return false; // 挿入失敗
        }
        
    }
}