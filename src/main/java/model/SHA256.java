//参考  https://jp-seemore.com/app/14504/#toc6


package model;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

//パスワードをハッシュ化（暗号化）するクラス
public class SHA256 {
	
  String hash;
	
  public String createHash(String password) {
    
    try {
    	//文字列
    	String saltName = "recurrent_ice_cream";
    	//ソルトを生成
    	byte[] salt = saltName.getBytes();
        
        
      MessageDigest md = MessageDigest.getInstance("SHA-256");
      md.update(salt);
      md.update(password.getBytes());
      
      byte[] hashBytes = md.digest();
      
      //ストレッチング
      //https://gist.github.com/seyan/915057
      for(int i=1; i < 10000; i++){
          hashBytes = md.digest(hashBytes);
      }
      
      //ハッシュ作成
      hash = Base64.getEncoder().encodeToString(hashBytes);
      
      //エラー検証用
      System.out.println(password);
      System.out.println("Hashed Password: " + hash);
      
    } catch (NoSuchAlgorithmException e) {
      e.printStackTrace();
      return null;
    }
    
    return hash;
  }
}

