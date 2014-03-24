package es.unileon.ulebank.brokerage;

import es.unileon.ulebank.brokerage.fees.FeeStrategy;
import java.util.logging.Handler;
import es.unileon.ulebank.Employee;

public class InvestmentFound {
    private final Handler foundID;
    private final Employee opener;
    private int participations;
    private double price;
    private int boughtParticipations;
    private FeeStrategy fee;

    public InvestmentFound(Handler foundID, Employee opener, int participations, double price, FeeStrategy fee) {
        this.foundID = foundID;
        this.opener = opener;
        this.participations = participations;
        this.price = price;
        this.fee = fee;
        this.boughtParticipations = 0;
    }
    
    public void setPPP(double ppp, int participations) {
        this.price = ppp * participations;
    }
    
    public void setPPP(double ppp, double price) throws InvalidNumberOfParticipationsException, TotalLowerThanBoughtException {
        if(price % ppp != 0) {
            throw new InvalidNumberOfParticipationsException(price, ppp);
        } else if((int) (price / ppp) < this.boughtParticipations) {
            throw new TotalLowerThanBoughtException();
        }
        
        this.participations = (int) (price / ppp);
    }
    
    /**
     * @return the foundID
     */
    public Handler getFoundID() {
        return foundID;
    }

    /**
     * @return the opener
     */
    public Employee getOpener() {
        return opener;
    }

    /**
     * @return the participations
     */
    public int getParticipations() {
        return participations;
    }

    /**
     * @param participations the participations to set
     */
    public void setParticipations(int participations) throws TotalLowerThanBoughtException {
        if(participations < this.boughtParticipations) {
            throw new TotalLowerThanBoughtException();
        }
        
        this.participations = participations;
    }

    /**
     * @return the price
     */
    public double getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * @return the fee
     */
    public FeeStrategy getFee() {
        return fee;
    }

    /**
     * @param fee the fee to set
     */
    public void setFee(FeeStrategy fee) {
        this.fee = fee;
    }
    
     /**
     * @param participations the participations to buy
     */
    public void buy(int participations) throws NotEnoughParticipationsException {
        if(participations > this.participations - this.boughtParticipations) {
            throw new NotEnoughParticipationsException();
        }
        
        this.boughtParticipations += participations;
    }
    
   public int getBuyableParticipations() {
       return this.participations - this.boughtParticipations;
   }
}
