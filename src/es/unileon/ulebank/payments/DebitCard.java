package es.unileon.ulebank.payments;

import java.io.IOException;

import es.unileon.ulebank.account.Account;
import es.unileon.ulebank.client.Client;
import es.unileon.ulebank.exceptions.CommissionException;
import es.unileon.ulebank.fees.InvalidFeeException;
import es.unileon.ulebank.handler.CardHandler;
import es.unileon.ulebank.fees.DebitMaintenanceFee;
import es.unileon.ulebank.fees.LinearFee;

/**
 * @author Israel
 * Clase que representa una tarjeta de Debito
 */
public class DebitCard extends Card {
	
	/**
	 * Constructor de la clase
	 * @param cardId
	 * @param owner
	 * @param account
	 * @param buyLimitDiary
	 * @param buyLimitMonthly
	 * @param cashLimitDiary
	 * @param cashLimitMonthly
	 * @param commissionEmission
	 * @param commissionMaintenance
	 * @param commissionRenovate
	 * @param limitDebit
	 * @throws NumberFormatException
	 * @throws CommissionException
	 * @throws IOException
	 */
	public DebitCard(CardHandler cardId, Client owner, Account account,
			double buyLimitDiary, double buyLimitMonthly, double cashLimitDiary, double cashLimitMonthly,
			float commissionEmission, float commissionMaintenance, float commissionRenovate, double limitDebit) throws NumberFormatException, CommissionException, IOException, InvalidFeeException {
		super(cardId, CardType.DEBIT,
				buyLimitDiary, buyLimitMonthly, cashLimitDiary, cashLimitMonthly,
				new LinearFee(commissionEmission,0), 
				new DebitMaintenanceFee(owner, commissionMaintenance), 
				new LinearFee(commissionRenovate,0),
				limitDebit);
	}
}
