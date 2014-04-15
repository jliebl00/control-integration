/* Application developed for AW subject, belonging to passive operations
 group.*/

package es.unileon.ulebank.exceptions;

/**
 *
 * @author runix
 */
public class MalformedHandlerException extends Exception{
    
	private static final long serialVersionUID = 1L;

	public MalformedHandlerException(String msg) {
        super(msg);
    }
}
