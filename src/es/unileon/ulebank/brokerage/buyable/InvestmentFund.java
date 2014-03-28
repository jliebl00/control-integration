package es.unileon.ulebank.brokerage.buyable;

import es.unileon.ulebank.Employee;
import es.unileon.ulebank.fees.FeeStrategy;

import java.util.logging.Handler;

public class InvestmentFund extends Buyable {

    private final Employee opener;
    private double profitability;
    private FeeStrategy fee;

    public InvestmentFund(Handler id, int amount, double totalPrice, Employee opener, FeeStrategy fee, double profitability) throws InvalidBuyableException {
        super(id, amount, totalPrice);


        if (profitability < 1) {
            throw new InvalidBuyableException("Profitability", "greater", 1);
        }

        this.opener = opener;
        this.fee = fee;
        this.profitability = profitability;
    }

    /**
     * @return the opener
     */
    public Employee getOpener() {
        return opener;
    }

    /**
     * @param participations the participations to set
     */
    public void setParticipations(int participations) throws TotalLowerThanBoughtException {
        if (participations < this.purchasedAmount) {
            throw new TotalLowerThanBoughtException();
        }

        this.amount = participations;
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
     * @return the profitability
     */
    public double getProfitability() {
        return profitability;
    }

    /**
     * @param profitability the profitability to set
     */
    public void setProfitability(double profitability) {
        this.profitability = profitability;
    }
}
