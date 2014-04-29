/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package es.unileon.ulebank.command;
import es.unileon.ulebank.account.Account;
import es.unileon.ulebank.account.exception.BalanceException;
import es.unileon.ulebank.handler.Handler;

import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Paula
 */
public class AddBalanceCommand implements Command{
    private Account cuenta;
    private float balance;
    private float amount;
    
    public AddBalanceCommand(float balance, float amount){
        this.balance=balance;
        this.amount=amount;
    }
    
    @Override
    public void execute() {
        try {
            cuenta.addBalance(amount);
        }catch (BalanceException ex) {
            Logger.getLogger(AddBalanceCommand.class.getName()).log(Level.SEVERE, null, ex);
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
