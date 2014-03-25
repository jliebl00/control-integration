package es.unileon.ulebank.brokerage.exceptions;

public class TotalLowerThanBoughtException extends Exception {
    public TotalLowerThanBoughtException() {
        super("Total of participations cannot be lower than bought participations.");
    }
}
