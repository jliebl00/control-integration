package es.unileon.ulebank.brokerage;

public class LinearFee implements FeeStrategy {

    private final double fee;
    
    public LinearFee(double fee) {
        this.fee = fee;
    }
    
    @Override
    public double getFee(double value) {
        return this.fee * value;
    }
    
}
