package es.unileon.ulebank.brokerage;

import es.unileon.ulebank.handler.Handler;

public class Enterprise {

    private double price;
    private int amount;
    private final Handler enterpriseID;

    public Enterprise(Handler enterpriseID, double price, int amount) {
        this.price = price;
        this.enterpriseID = enterpriseID;
        this.amount = amount;
    }

    /**
     * @return the price
     */
    public double getPrice() {
        return price;
    }

    /**
     * @return the enterpriseID
     */
    public Handler getEnterpriseID() {
        return enterpriseID;
    }

    /**
     * @return the amount of actions the enterprise has.
     */
    public int getAmount() {
        return amount;
    }

    /**
     * @param price the price to set.
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * @param amount the amount of actions the enterprise will have.
     */
    public void setAmount(int amount) {
        this.amount = amount;
    }

}
