//https://www.sejuku.net/blog/24926
//https://magazine.techacademy.jp/magazine/9246

package dao;

public class ConfigDB{
    //protectedについて→https://www.sejuku.net/blog/22679
    protected final String JDBC_URL = "jdbc:mysql://localhost:3306/recurrent_ice_cream";
	protected final String DB_USER = "root";
	protected final String DB_PASS = "adminadmin";
   
   
   public void ReadJDBC_Driver() {
	 //MySQL用のJDBCドライバを読み込む
     try {
         Class.forName("com.mysql.cj.jdbc.Driver");
     }
     //JDBCドライバが読み込めないとき実行する    
     catch (ClassNotFoundException e) {
         throw new IllegalStateException("JDBCドライバを読み込めませんでした");
     }
	    
   }
}

