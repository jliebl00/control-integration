package src.es.unileon.ulebank.assets.command;

import src.es.unileon.ulebank.assets.Loan;
import src.es.unileon.ulebank.assets.exceptions.LoanException;
import src.es.unileon.ulebank.assets.handler.Handler;

public class CancelLoanCommand implements Command {
	private Handler idCommand;
	private Loan loan;
	private double debt;

	public CancelLoanCommand(Handler idCom, Loan loan) {
		this.idCommand = idCom;
		this.loan = loan;
		this.debt = loan.getDebt();
	}

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		try {
			this.loan.cancelLoan();
		} catch (LoanException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void undo() {
		// TODO Auto-generated method stub
		this.loan.setDebt(debt);

	}

	@Override
	public void redo() {
		// TODO Auto-generated method stub
		try {
			this.loan.cancelLoan();
		} catch (LoanException e) {
			e.printStackTrace();
		}

	}

	@Override
	public Handler getId() {
		// TODO Auto-generated method stub
		return idCommand;
	}

}
