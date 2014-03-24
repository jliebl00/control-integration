package es.unileon.ulebank.brokerage;

public class InvestmentFoundPack {
    private final InvestmentFound found;
    private final int count;
    
    public InvestmentFoundPack(InvestmentFound found, int count) {
        this.found = found;
        this.count = count;
    }

    /**
     * @return the found
     */
    public InvestmentFound getFound() {
        return found;
    }

    /**
     * @return the count
     */
    public int getCount() {
        return count;
    }
}
