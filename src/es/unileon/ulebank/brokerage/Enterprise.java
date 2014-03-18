package es.unileon.ulebank.brokerage;

import java.util.logging.Handler;

public class Enterprise {
    private final double price;
    private final Handler enterpriseID;

    public Enterprise(double price, Handler enterpriseID) {
        this.price = price;
        this.enterpriseID = enterpriseID;
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
    
}
