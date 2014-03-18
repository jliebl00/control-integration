package es.unileon.ulebank.brokerage;

import java.util.Date;

public class StockPack {
    
    private final Enterprise stock;
    private final double price;
    private final int count;
    private final Date date;    

    public StockPack(Enterprise stock, double price, int count, Date date) {
        this.stock = stock;
        this.price = price;
        this.count = count;
        this.date = date;
    }
    
    /**
     * @return the stock
     */
    public Enterprise getStock() {
        return stock;
    }

    /**
     * @return the price
     */
    public double getPrice() {
        return price;
    }

    /**
     * @return the count
     */
    public int getCount() {
        return count;
    }

    /**
     * @return the date
     */
    public Date getDate() {
        return date;
    }
}
