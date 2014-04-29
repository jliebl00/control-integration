package es.unileon.ulebank.command;

import java.util.Date;

import es.unileon.ulebank.handler.Handler;
import es.unileon.ulebank.payments.Card;
import es.unileon.ulebank.strategy.StrategyCommissionEmissionCredit;
import es.unileon.ulebank.strategy.StrategyCommissionEmissionDebit;

/**
 * @author Israel
 */
public class NewCardCommand implements Command {

	private Card card;

	// private Handler owner;
	// private Account account;

	public NewCardCommand(Card card/* , Account account */) {
		this.card = card;
		// this.account = account;
	}

	@Override
	public void execute() {
		this.card.create();
		// account.addCard(this.card);
		switch (card.getCardType()) {
		case DEBIT:
			this.card.setStrategy(new StrategyCommissionEmissionDebit());
			break;
		case CREDIT:
			this.card.setStrategy(new StrategyCommissionEmissionCredit());
			break;
		case PURSE:

			break;
		case REVOLVING:

			break;
		default:
			break;
		}
	}

	public void generateContract(Card card) {
		switch (card.getCardType()) {
		case DEBIT:

			break;
		case CREDIT:

			break;
		case PURSE:

			break;
		case REVOLVING:

			break;
		default:
			break;
		}
	}

	@Override
	public Date getEffectiveDate() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Handler getID() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void undo() {
		// TODO Auto-generated method stub

	}

	@Override
	public void redo() {
		// TODO Auto-generated method stub

	}
}
