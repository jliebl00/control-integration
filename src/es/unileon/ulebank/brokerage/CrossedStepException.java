package es.unileon.ulebank.brokerage;

public class CrossedStepException extends Exception {
    public CrossedStepException(String msg, FeeStep step1, FeeStep step2) {
        super(msg);
        //TODO
    }
}
