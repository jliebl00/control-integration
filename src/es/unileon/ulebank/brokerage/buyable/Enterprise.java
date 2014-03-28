package es.unileon.ulebank.brokerage.buyable;

import es.unileon.ulebank.exceptions.InvalidInvestmentFundException;

public class Enterprise extends Buyable {

    public Enterprise(java.util.logging.Handler id, int amount, double totalPrice) throws InvalidInvestmentFundException {
        super(id, amount, totalPrice);
    }
}
