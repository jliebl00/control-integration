package es.unileon.ulebank.brokerage.fees;

public class LinearFee implements FeeStrategy {

    /**
     * Fee to be applied as amount multiplicator, THUS ONE (a 2% fee is storead
     * as 0.02).
     */
    private final double fee;

    /**
     * Minimum value which is always added to the total fee.
     */
    private final double minimum;

    public LinearFee(double fee, double minimum) {
        this.fee = fee;
        this.minimum = minimum;
    }

    @Override
    public double getFee(double value) {
        return this.fee * value + this.minimum;
    }

}
