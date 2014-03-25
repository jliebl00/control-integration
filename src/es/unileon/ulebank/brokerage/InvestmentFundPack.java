package es.unileon.ulebank.brokerage;

public class InvestmentFundPack {
    private final InvestmentFund found;
    private final int count;
    
    public InvestmentFundPack(InvestmentFund found, int count) {
        this.found = found;
        this.count = count;
    }

    /**
     * @return the found
     */
    public InvestmentFund getFound() {
        return found;
    }

    /**
     * @return the count
     */
    public int getCount() {
        return count;
    }
}
