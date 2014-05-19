package es.unileon.ulebank.command;

import es.unileon.ulebank.account.Account;
import es.unileon.ulebank.account.AccountHandler;
import es.unileon.ulebank.exceptions.ClientNotFoundException;
import es.unileon.ulebank.handler.CardHandler;
import es.unileon.ulebank.handler.CommandHandler;
import es.unileon.ulebank.handler.DNIHandler;
import es.unileon.ulebank.handler.Handler;
import es.unileon.ulebank.office.Office;


/**
 * @author Israel
 * Comando para realizar la cancelacion de la tarjeta
 */
public class CancelCardCommand implements Command {
	/**
	 * Identificador del comando
	 */
	private Handler id;
	/**
	 * Identificador de la tarjeta a cancelar
	 */
	private Handler cardId;
	/**
	 * Cuenta a la que esta asociada la tarjeta que se va a cancelar
	 */
	private Account account;
	
	/**
	 * Constructor de la clase
	 * @param cardId
	 * @param office
	 * @param dni
	 * @param account
	 * @throws ClientNotFoundException 
	 */
	public CancelCardCommand(Handler cardId, Office office, Handler dni, Handler account) throws ClientNotFoundException {
		this.id = new CommandHandler(cardId);
		this.cardId = (CardHandler) cardId;
		this.account = office.searchClient((DNIHandler) dni).searchAccount((AccountHandler) account);	
	}
	
	/**
	 * Realiza la cancelacion de la tarjeta
	 */
	@Override
	public void execute() {
		//Se borra la tarjeta de la lista de tarjetas de la cuenta
		account.removeCard((CardHandler) this.cardId);		
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
