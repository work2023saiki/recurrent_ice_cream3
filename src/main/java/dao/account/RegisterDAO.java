//「スッキリわかるサーブレット＆JSP入門」コード13-3、コード13-5～13-9を参考

package dao.account;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import beans.AccountBean;
import dao.ConfigDB;
import model.SHA256;



//アカウント情報をアカウントテーブルに新規登録するDAO
//サンプルデータがアカウントテーブルに登録されていなかったらエラーになる。
//configDB.javaを継承
public class RegisterDAO extends ConfigDB{

	
  public boolean create(AccountBean account) {
	  
	//親クラスConfigDBのメソッドを利用
	//JDBCドライバーを読み込む
		ReadJDBC_Driver();
    
    // データベースへ接続
    try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {
      
      //パスワードをハッシュ化する
      SHA256 Hashpassword = new SHA256();
      String pass = Hashpassword.createHash(account.getPassword());
      
      // SELECT文を準備
      String sql = "INSERT INTO アカウント(氏名, パスワード, メールアドレス, 性別, 生年月日, 住所)\r\n"
      		        + "VALUES (?, ?, ?, ?, ?, ?)";
        
      PreparedStatement pStmt = conn.prepareStatement(sql);
      
      
      //WHERE文の?に代入
      pStmt.setString(1, account.getName());
      pStmt.setString(2, pass);
      pStmt.setString(3, account.getMailAd());
      pStmt.setString(4, account.getGender());
      
    //↓の参考サイト：https://www.web-dev-qa-db-ja.com/ja/java/preparedstatement%E3%81%A7setdate%E3%82%92%E4%BD%BF%E7%94%A8%E3%81%99%E3%82%8B/1042266168/
      pStmt.setDate(5, new java.sql.Date(account.getBirth().getTime()));
      
      pStmt.setString(6, account.getHomeAddress());
      
     

      // INSERT文を実行（resultには追加された行数が代入される）
      int result = pStmt.executeUpdate();
      if (result != 1) {
        return false;
      }
	      
    }  
      //try文の中でエラーが出たとき実行する
    catch (SQLException e) {
      e.printStackTrace();
      return false;
    }
    
    //できたとき
    return true;
  }
}