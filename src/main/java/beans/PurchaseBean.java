package beans;

import java.sql.Date;

public class PurchaseBean {
	private int kariID;
	private int accountID;
	private String itemName;
	private int totalPrice;
    
    private int itemID;
    private int number;
    private Date buyDate;

    // Constructor
    public PurchaseBean(int accountID, int itemID, int number) {
        this.accountID = accountID;
        this.itemID = itemID;
        this.number = number;
        
    }
    
    public PurchaseBean(int kariID, int itemID, String itemName, int number, int totalPrice) {
    	this.kariID = kariID;
    	this.itemID = itemID;
        this.itemName = itemName;
        this.number = number;
        this.totalPrice = totalPrice;
    }

    // Getters and Setters
    public int getKariID() {
        return kariID;
    }

    public void setKariID(int kariID) {
        this.kariID = kariID;
    }

    
    public int getAccountID() {
        return accountID;
    }

    public void setAccountID(int accountID) {
        this.accountID = accountID;
    }

    
    public String getItemName() {
        return itemName;
    }
    
    public void setItemName(String itemName) {
        this.itemName = itemName;
    }
    
    
    public int getTotalPrice() {
        return totalPrice;
    }
    
    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }
    public int getItemID() {
        return itemID;
    }

    public void setItemID(int itemID) {
        this.itemID = itemID;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Date getBuyDate() {
        return buyDate;
    }

    public void setBuyDate(Date buyDate) {
        this.buyDate = buyDate;
    }
    
    
}