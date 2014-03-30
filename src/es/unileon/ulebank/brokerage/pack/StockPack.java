package es.unileon.ulebank.brokerage.pack;

import es.unileon.ulebank.account.Account;
import es.unileon.ulebank.brokerage.buyable.Buyable;
import es.unileon.ulebank.brokerage.buyable.NotEnoughParticipationsException;
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
    
    public void sell(int amount) throws NotEnoughParticipationsException {
        int stockage = this.amount - amount;
        if(stockage < 0) {
            throw new NotEnoughParticipationsException();
        }
        this.amount = stockage;
    }
}
