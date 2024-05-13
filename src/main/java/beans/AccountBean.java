//「スッキリわかるサーブレット＆JSP入門」P391のコード13-2、P190～P195
//参考サイト→「https://camp.trainocate.co.jp/magazine/whats-javabeans/」
//日付の型について↓
//https://www.sejuku.net/blog/19077#index_id0


package beans;

import java.io.Serializable;
import java.util.Date;

public class AccountBean implements Serializable{
  private int accountID;
  private String name;
  private String password;
  private String mailAd;
  private String gender;
  private Date birth;
  private Double age;
  private String homeAddress;

  
  public AccountBean() { }
  
  //アカウント登録用
  public AccountBean(String name, String password, String mailAd, String gender, Date birth, String homeAddress) {
    this.name = name;
    this.password = password;
    this.mailAd = mailAd;
    this.gender = gender;
    this.birth = birth;
    this.homeAddress = homeAddress;
  }
  
  //ログインチェック用
  public AccountBean(String name, String password) {
	    this.name = name;
	    this.password = password;
  }
  
  //ログインユーザー情報
  public AccountBean(int accountID, String name, String password, String mailAd, String gender, Date birth, String homeAddress) {
    
	this.accountID = accountID;
	this.name = name;
    this.password = password;
    this.mailAd = mailAd;
    this.gender = gender;
    this.birth = birth;
    this.homeAddress = homeAddress;
  }
  
  
  //マイページの編集、表示用
  public AccountBean(int accountID, String name, String mailAd, String homeAddress) {
	    this.accountID = accountID;
	    this.name = name;
	    this.mailAd = mailAd;
	    this.homeAddress = homeAddress;
	  }
  
//ダッシュボード用
  public AccountBean(String name, String mailAd, Double age, String homeAddress) {
	    this.name = name;
	    this.mailAd = mailAd;
	    this.age = age;
	    this.homeAddress = homeAddress;
  }
	    
  //ゲッターとセッター
  public int getAccountID() { return accountID; }
  public void setAccountID(int accountID) { this.accountID = accountID; }
  
  public String getName() { return name; }
  public void setName(String name) { this.name = name; }
  
  public String getPassword() { return password; }
  public void setPassword(String password) { this.password = password; }
  
  public String getMailAd() { return mailAd; }
  public void setMailAd(String mailAd) { this.mailAd = mailAd; }
  
  public String getGender() { return gender; }
  public void setGender(String gender) { this.gender = gender; }
  
  public Date getBirth() { return birth; }
  public void setBirth(Date birth) { this.birth = birth; }
  
  public Double getAge() { return age; }
  public void setAge(Double age) { this.age = age; }
  
  public String getHomeAddress() { return homeAddress; }
  public void setHomeAddress(String homeAddress) { this.homeAddress = homeAddress; }
  
}