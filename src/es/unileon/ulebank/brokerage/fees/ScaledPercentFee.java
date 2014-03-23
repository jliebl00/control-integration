package es.unileon.ulebank.brokerage.fees;

import java.util.ArrayList;
import java.util.Iterator;

public class ScaledPercentFee implements FeeStrategy {

    private final ArrayList<FeeStep> steps;

    /**
     * Minimum value which is always added to the total fee.
     */
    private final double minimum;

    public ScaledPercentFee(double minimum) {
        this.steps = new ArrayList<>();
        this.minimum = minimum;
    }

    public void addStep(FeeStep step) throws CrossedStepException {

        if (this.steps.size() > 0) {
            Iterator<FeeStep> it = this.steps.iterator();
            FeeStep fs;

            do {
                fs = it.next();
                if (fs.collides(step)) {
                    throw new CrossedStepException(fs, step);
                }
            } while (it.hasNext());
        }

        this.steps.add(step);
    }

    /**
     * Returns the fee that should be applied to the given amount.
     *
     * @param value
     * @return The fee that should be applied to the given amount
     */
    @Override
    public double getFee(double value) {
        boolean match;
        FeeStep fs = null;
        
        if (this.steps.size() > 0) {
            Iterator<FeeStep> it = this.steps.iterator();
            do {
                fs = it.next();
                match = fs.wraps(value);
            } while (!match && it.hasNext());

            return value * fs.getFee() + this.minimum;
        } else {
            return this.minimum;
        }
    }
}
