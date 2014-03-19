package es.unileon.ulebank.brokerage.fees;

public class LinearFee implements FeeStrategy {

    private final double fee;
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
