package es.unileon.ulebank.command;

import java.io.IOException;

import es.unileon.ulebank.exceptions.ClientNotFoundException;
import es.unileon.ulebank.exceptions.PaymentException;
import es.unileon.ulebank.exceptions.TransferException;
import es.unileon.ulebank.fees.InvalidFeeException;
import es.unileon.ulebank.handler.Handler;
import es.unileon.ulebank.history.TransactionException;

/**
 * @author Israel
 */
public interface Command {
	/**
	 * Realiza la ejecucion del comando
	 * @throws InvalidFeeException 
	 * @throws es.unileon.ulebank.history.TransactionException 
	 * @throws TransactionException 
	 * @throws PaymentException 
	 * @throws TransferException 
	 * @throws IOException 
	 * @throws NumberFormatException 
	 * @throws ClientNotFoundException 
	 */
	public void execute() throws Exception;
	/**
	 * Deshace los cambios realizados
	 * @throws TransferException 
	 * @throws es.unileon.ulebank.history.TransactionException 
	 */
	public void undo() throws Exception;
	/**
	 * Rehace los cambios deshechos
	 * @throws es.unileon.ulebank.history.TransactionException 
	 * @throws TransactionException 
	 * @throws PaymentException 
	 */
	public void redo() throws Exception;
	/**
	 * Devuelve el identificador del comando
	 * @return
	 */
	public Handler getId();
}
