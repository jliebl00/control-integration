/* Application developed for AW subject, belonging to passive operations
 group.*/
package es.unileon.ulebank.history;

import java.util.Date;

/**
 * Generic transaction
 *
 * @author runix
 */
public class GenericTransaction extends Transaction {

    /**
     * Create a new generic transaction
     *
     * @param amount ( Transaction amount )
     * @param date ( Transaction date )
     * @param subject ( Transaction subject )
     * @throws es.unileon.ulebank.history.TransactionException
     */
    public GenericTransaction(double amount, Date date, String subject) throws TransactionException {
        super(amount, date, subject);
    }
}
