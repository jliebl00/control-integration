/* Application developed for AW subject, belonging to passive operations
 group.*/

package es.unileon.ulebank.account.handler;

/**
 *
 * @author runix
 */
public class MalformedHandlerException extends RuntimeException{
    
	private static final long serialVersionUID = 1L;

	public MalformedHandlerException(String msg) {
        super(msg);
    }
}
