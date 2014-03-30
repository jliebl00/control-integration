package es.unileon.ulebank.brokerage.pack;

import es.unileon.ulebank.Employee;
import es.unileon.ulebank.account.Account;
import es.unileon.ulebank.brokerage.buyable.Buyable;
import java.util.Date;

public class StockPack extends Pack {
    
    private final double price;
    private final Date date;    

    public StockPack(Buyable product, int amount, Account account, double price, Date date) {
        super(product, amount, account);
        
        this.price = price;
        this.date = date;
    }

    
    /**
     * @return the price
     */
    public double getPrice() {
        return price;
    }

    /**
     * @return the date
     */
    public Date getDate() {
        return date;
    }
}
