package es.unileon.ulebank.brokerage;

public class InvestimentFoundPack {
    private final InvestimentFound found;
    private final int count;
    
    public InvestimentFoundPack(InvestimentFound found, int count) {
        this.found = found;
        this.count = count;
    }

    /**
     * @return the found
     */
    public InvestimentFound getFound() {
        return found;
    }

    /**
     * @return the count
     */
    public int getCount() {
        return count;
    }
}
