package es.unileon.ulebank.brokerage.buyable;

import es.unileon.ulebank.handler.Handler;

public class Enterprise extends Buyable {

    public Enterprise(Handler id, int amount, double totalPrice) throws InvalidBuyableException {
        super(id, amount, totalPrice);
    }
}
