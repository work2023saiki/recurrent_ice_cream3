//「スッキリわかるサーブレット＆JSP入門」P391のコード13-2、P190～P195
//参考サイト→「https://camp.trainocate.co.jp/magazine/whats-javabeans/」
//日付の型について↓
//https://www.sejuku.net/blog/19077#index_id0

package beans;

import java.io.Serializable;

//商品テーブルから情報を取得するため作成した
public class ItemBean implements Serializable{
  private int itemID;
  private String itemName;
  private int price;
  private String itemExplain;
  
  
  public ItemBean() { }
  
  
  //商品検索で使う
  public ItemBean(int itemID, String itemName, int price, String itemExplain) {
	    this.itemID = itemID;
	    this.itemName = itemName;
	    this.price = price;
	    this.itemExplain = itemExplain;
	  }
  
  //商品登録で使う
  public ItemBean(String itemName, int price, String itemExplain) {
    this.itemName = itemName;
    this.price = price;
    this.itemExplain = itemExplain;
  }
  
  
  //ゲッターとセッター
  public int getItemID() { return itemID; }
  public void setItemID(int itemID) { this.itemID = itemID; }
  
  public String getItemName() { return itemName; }
  public void setItemName(String itemName) { this.itemName = itemName; }
  
  public int getPrice() { return price; }
  public void setPrice(int price) { this.price = price; }
  
  public String getItemExplain() { return itemExplain; }
  public void setItemExplain(String itemExplain) { this.itemExplain = itemExplain; }
  
}