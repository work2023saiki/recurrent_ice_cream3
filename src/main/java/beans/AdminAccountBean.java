//「スッキリわかるサーブレット＆JSP入門」P391のコード13-2、P190～P195
//参考サイト→「https://camp.trainocate.co.jp/magazine/whats-javabeans/」
//日付の型について↓
//https://www.sejuku.net/blog/19077#index_id0


package beans;

import java.io.Serializable;

public class AdminAccountBean implements Serializable{
  private int adminID;
  private String adminName;
  private String adminPassword;
  

  
  public AdminAccountBean() { }
  
  //アカウント登録用
  //public AdminAccountBean(String adminName, String adminPassword) {
  //  this.adminName = adminName;
  //  this.adminPassword = adminPassword;
  // }
  
  
  //ログイン用
  public AdminAccountBean(String adminName, String adminPassword) {
	    this.adminName = adminName;
	    this.adminPassword = adminPassword;
  }
  //ログイン用
  public AdminAccountBean(int adminID) {
	    this.adminID = adminID;
  }
  
  //パスワード変更のための本人確認用
  //public AdminAccountBean(String adminName, String mailAd, String gender) {
  	//	this.name = name;
	//    this.mailAd = mailAd;
	//    this.gender = gender;
  //}
  
  //パスワード変更
  public AdminAccountBean(String adminPassword) {
	    this.adminPassword = adminPassword;
  }
  
  //ゲッターとセッター
  public int getAccountId() { return adminID; }
  public void setAccountID(int adminID) { this.adminID = adminID; }
  
  public String getName() { return adminName; }
  public void setName(String adminName) { this.adminName = adminName; }
  
  public String getPassword() { return adminPassword; }
  public void setPassword(String adminPassword) { this.adminPassword = adminPassword; }
  

  
}