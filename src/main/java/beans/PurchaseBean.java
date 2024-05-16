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
    public PurchaseBean(int accountID, int itemID, int number, Date buyDate) {
        this.accountID = accountID;
        this.itemID = itemID;
        this.number = number;
        this.buyDate = buyDate;
    }
    
    public PurchaseBean(int kariID, String itemName, int number, int totalPrice) {
        this.kariID = kariID;
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

    
    public int getaccountID() {
        return accountID;
    }

    public void setaccountID(int accountID) {
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
    public int getitemID() {
        return itemID;
    }

    public void setitemID(int itemID) {
        this.itemID = itemID;
    }

    public int getnumber() {
        return number;
    }

    public void setnumber(int number) {
        this.number = number;
    }

    public Date getbuyDate() {
        return buyDate;
    }

    public void setbuyDate(Date buyDate) {
        this.buyDate = buyDate;
    }
    
    
}