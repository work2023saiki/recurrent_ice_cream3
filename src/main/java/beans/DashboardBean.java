//「スッキリわかるサーブレット＆JSP入門」P391のコード13-2、P190～P195
//参考サイト→「https://camp.trainocate.co.jp/magazine/whats-javabeans/」
//日付の型について↓
//https://www.sejuku.net/blog/19077#index_id0


package beans;

import java.io.Serializable;
import java.util.Date;

public class DashboardBean implements Serializable{
  private String gender;
  private Date birth;
  private int number;
  private String itemName;

  public DashboardBean() { }
  
  //ダッシュボード用
//  public DashboardBean(String gender, Date birth,int number, String itemName) {
//    this.gender = gender;
//    this.birth = birth;
//    this.number = number;
//    this.itemName = itemName;
//  }
 
  public DashboardBean(String gender, int number) {
	  
	  this.gender = gender;
	  this.number = number;
  }

  //ゲッターとセッター 
  public String getGender() { return gender; }
  public void setGender(String gender) { this.gender = gender; }
  
  public Date getBirth() { return birth; }
  public void setBirth(Date birth) { this.birth = birth; }
  
  public int getNumber() { return number;}
  public void setNumber(int number) { this.number = number; }

  public String getitemName() { return itemName;}
  public void setitemName(String itemName) { this.itemName = itemName; }

  
}