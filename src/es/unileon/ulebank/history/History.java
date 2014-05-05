package es.unileon.ulebank.history;

import java.util.ArrayList;
import java.util.Collection;

/**
 * 
 * @author roobre
 * @param <T> A subclass of Transaction
 */
public class History<T extends Transaction> {

    private final Collection<T> transactions;

    public History() {
        this.transactions = new ArrayList();
    }

    public void add(T trans) {
        this.transactions.add(trans);
    }

    public void remove(T trans) {
        this.transactions.remove(trans);
    }
    
    public void clear() {
        this.transactions.clear();
    }
}
