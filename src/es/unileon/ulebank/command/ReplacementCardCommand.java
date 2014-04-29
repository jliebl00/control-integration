package es.unileon.ulebank.command;

import java.util.Date;

import es.unileon.ulebank.handler.CardHandler;
import es.unileon.ulebank.handler.Handler;
import es.unileon.ulebank.payments.Card;
import es.unileon.ulebank.strategy.StrategyCommissionRenovateCredit;
import es.unileon.ulebank.strategy.StrategyCommissionRenovateDebit;

/**
 * @author Israel
 */
public class ReplacementCardCommand implements Command {
	private Card card;

	public ReplacementCardCommand(Card card) {
		this.card = card;
	}

	@Override
	public void execute() {
		CardHandler newCard = new CardHandler();
		this.card.setCardId(newCard.getCardNumber());
		this.card.setPin(card.generatePinCode());
		this.card.setCvv(card.generateCVV());

		switch (card.getCardType()) {
		case DEBIT:
			this.card.setStrategy(new StrategyCommissionRenovateDebit());
			break;
		case CREDIT:
			this.card.setStrategy(new StrategyCommissionRenovateCredit());
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
