package beans;

import java.sql.Date;

public class PurchaseBean {
    private int accountID;
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

    // Getters and Setters
    public int getaccountID() {
        return accountID;
    }

    public void setaccountID(int accountID) {
        this.accountID = accountID;
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