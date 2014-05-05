package es.unileon.ulebank.account.types;

import es.unileon.ulebank.account.Account;
import es.unileon.ulebank.bank.Bank;
import es.unileon.ulebank.Office;
import es.unileon.ulebank.exceptions.MalformedHandlerException;

/**
 *
 * @author runix
 */
public class SightAccount extends Account {


    public SightAccount(Office office, Bank bank, String accountnumber, double interest,
            double administrationWage,
            double anualInterest,
            double administrationFee,
            double negativeBallanceFee,
            double complaintFee,
            double buyingFee,
            double withdrawFee,
            double chequeFee,
            double repaymentFee,
            double depositOperationFee,
            double magneticSuppportFee,
            double paperFee,
            double terminalFee,
			double buyingFeePercentage) throws MalformedHandlerException {
        super(office, bank, accountnumber);
    }
}
