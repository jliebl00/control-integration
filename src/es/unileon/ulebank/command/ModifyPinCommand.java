package es.unileon.ulebank.command;

import java.util.Date;

import es.unileon.ulebank.handler.Handler;
import es.unileon.ulebank.payments.Card;

/**
 * @author Israel
 */
public class ModifyPinCommand implements Command {
	private Card card;
	private String newPin;
	
	public ModifyPinCommand(Card card, String newPin) {
		this.card = card;
		this.newPin = newPin;
	}
	
	@Override
	public void execute() {
		this.card.setPin(newPin);
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
