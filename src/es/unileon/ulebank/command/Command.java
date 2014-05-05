package es.unileon.ulebank.command;

import es.unileon.ulebank.handler.Handler;
import es.unileon.ulebank.exceptions.MalformedHandlerException;
import java.util.Date;

/**
 *
 * @author Patricia
 */
public interface Command {
 
    public Date getEffectiveDate();

    public Handler getID();

    public void execute() throws MalformedHandlerException;

    public void undo();
    
    public void redo();
   
}