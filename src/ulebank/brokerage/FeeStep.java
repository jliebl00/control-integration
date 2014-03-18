package ulebank.brokerage;

public class FeeStep {
    private final double low;
    private final double high;
    private final double fee;
    
    public FeeStep(double low, double high, double fee) {
        this.low = low;
        this.high = high;
        this.fee = fee;
    }
    
    /**
     * @return the fee
     */
    public double getFee() {
        return this.fee;
    }

    /**
     * @return the low
     */
    public double getLow() {
        return low;
    }

    /**
     * @return the high
     */
    public double getHigh() {
        return high;
    }
}
