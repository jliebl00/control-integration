package es.unileon.ulebank.command;

import java.util.logging.Level;
import java.util.logging.Logger;

import es.unileon.ulebank.office.Office;
import es.unileon.ulebank.account.Account;
import es.unileon.ulebank.account.AccountHandler;
import es.unileon.ulebank.exceptions.ClientNotFoundException;
import es.unileon.ulebank.handler.CardHandler;
import es.unileon.ulebank.handler.CommandHandler;
import es.unileon.ulebank.handler.DNIHandler;
import es.unileon.ulebank.handler.Handler;

/**
 * @author Israel
 * Comando para realizar la cancelacion de la tarjeta
 */
public class CancelCardCommand implements Command {
	//Identificador del comando
	private Handler id;
	//Identificador de la tarjeta a cancelar
	private CardHandler cardId;
	//Cuenta a la que esta asociada la tarjeta que se va a cancelar
	private Account account;
	
	/**
	 * Constructor de la clase
	 * @param cardId
	 * @param office
	 * @param dni
	 * @param account
	 */
	public CancelCardCommand(CardHandler cardId, Office office, DNIHandler dni, AccountHandler account) {
		this.id = new CommandHandler(cardId);
		this.cardId = cardId;
		try {
			this.account = office.searchClient(dni).searchAccount(account);
		} catch (ClientNotFoundException e) {
			Logger.getLogger(CancelCardCommand.class.toString()).log(Level.SEVERE, null, e);
		}
	}
	
	/**
	 * Realiza la cancelacion de la tarjeta
	 */
	@Override
	public void execute() {
		//Se borra la tarjeta de la lista de tarjetas de la cuenta
		account.removeCard(this.cardId);
	}

	/**
	 * Operacion no soportada, no se puede deshacer una cancelacion
	 */
	@Override
	public void undo() {
		throw new UnsupportedOperationException();
	}

	/**
	 * Operacion no soportada, como no se puede deshacer una cancelacion tampoco se puede rehacer
	 */
	@Override
	public void redo() {
		throw new UnsupportedOperationException();
	}

	/**
	 * Devuelve el identificador del comando
	 */
	@Override
	public Handler getId() {
		return this.id;
	}
}
