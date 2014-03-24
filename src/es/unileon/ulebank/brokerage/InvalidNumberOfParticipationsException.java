package es.unileon.ulebank.brokerage;

public class InvalidNumberOfParticipationsException extends Exception {
    public InvalidNumberOfParticipationsException(double price, double ppp) {
        super(price + " is not divisible by " + ppp);
    }
}
