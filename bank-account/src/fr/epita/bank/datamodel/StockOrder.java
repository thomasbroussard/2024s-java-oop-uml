package fr.epita.bank.datamodel;

public class StockOrder {

    private double unitPrice;
    private int quantity;
    private double commissionRate;

    private InvestmentAccount account;

    private Stock stock;

    public StockOrder(double unitPrice, int quantity, double commissionRate, InvestmentAccount account, Stock stock) {
        this.unitPrice = unitPrice;
        this.quantity = quantity;
        this.commissionRate = commissionRate;
        this.account = account;
        this.stock = stock;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getCommissionRate() {
        return commissionRate;
    }

    public void setCommissionRate(double commissionRate) {
        this.commissionRate = commissionRate;
    }

    public InvestmentAccount getAccount() {
        return account;
    }

    public void setAccount(InvestmentAccount account) {
        this.account = account;
    }

    public Stock getStock() {
        return stock;
    }

    public void setStock(Stock stock) {
        this.stock = stock;
    }
}
