package es.unileon.ulebank.brokerage.fees;

public class CrossedStepException extends Exception {
    public CrossedStepException(FeeStep step1, FeeStep step2) {
        super("Step " + step1.getLow() + " collides with " + step2);
    }
}
