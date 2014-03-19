package es.unileon.ulebank.brokerage;

/**
 * @class FeeStep
 * This class represents the boundaries of an interval and the fee associated to that interval.
 * LOWER boundary is included but HIGHER boundary is NOT (a.k.a. [low, high)).
 * @author roobre
 */
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
    
    public boolean wraps(double value) {
        return (value >= this.low && value < this.high);
    }
    
    @Override
    public String toString() {
        return "[" + this.low + "," + this.high + ")";
    }
}
