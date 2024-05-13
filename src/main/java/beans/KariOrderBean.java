//「スッキリわかるサーブレット＆JSP入門」P391のコード13-2、P190～P195
//参考サイト→「https://camp.trainocate.co.jp/magazine/whats-javabeans/」
//日付の型について↓
//https://www.sejuku.net/blog/19077#index_id0


package beans;

import java.io.Serializable;

public class KariOrderBean implements Serializable{
  private int kariOrderID;
  private int accountID;
  private String orderNum1;
  private String orderNum2;
  private String orderNum3;
  private String orderNum4;
  private String orderNum5;

  
  public KariOrderBean() { }
  
  //仮注文登録用
  public KariOrderBean(int accountID, String orderNum1, String orderNum2, String orderNum3, String orderNum4, String orderNum5) {
    this.accountID = accountID;
	this.orderNum1 = orderNum1;
    this.orderNum2 = orderNum2;
    this.orderNum3 = orderNum3;
    this.orderNum4 = orderNum4;
    this.orderNum5 = orderNum5;
  }
  
  
  
  
  //ゲッターとセッター
  public int getKariOrderID() { return kariOrderID; }
  public void setKariOrderID(int kariOrderID) { this.kariOrderID = kariOrderID; }

  public int getAccountID() { return accountID; }
  public void setAccountID(int accountID) { this.accountID = accountID; }

  public String getOrderNum1() { return orderNum1; }
  public void setOrderNum1(String orderNum1) { this.orderNum1 = orderNum1; }
  
  public String getOrderNum2() { return orderNum2; }
  public void setOrderNum2(String orderNum2) { this.orderNum2 = orderNum2; }
  
  public String getOrderNum3() { return orderNum3; }
  public void setOrderNum3(String orderNum3) { this.orderNum3 = orderNum3; }
  
  public String getOrderNum4() { return orderNum4; }
  public void setOrderNum4(String orderNum4) { this.orderNum4 = orderNum4; }
  
  public String getOrderNum5() { return orderNum5; }
  public void setOrderNum5(String orderNum5) { this.orderNum5 = orderNum5; }
  
}