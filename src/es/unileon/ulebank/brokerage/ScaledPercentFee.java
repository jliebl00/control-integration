package es.unileon.ulebank.brokerage;

import java.util.ArrayList;

public class ScaledPercentFee implements FeeStrategy {

    private final ArrayList<FeeStep> steps;
    
    public ScaledPercentFee() {
        this.steps = new ArrayList<>();
    }
    
    public void addStep(FeeStep step) throws CrossedStepException {
        this.steps.add(step);
    }
    
    @Override
    public double getFee(double value) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
