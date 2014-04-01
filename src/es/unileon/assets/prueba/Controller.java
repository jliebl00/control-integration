package es.unileon.assets.prueba;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import es.unileon.assets.gui.Data;
import es.unileon.assets.gui.Data2;
import es.unileon.assets.gui.View;

/**
 * Controller class to implement MVC pattern
 */
public class Controller {

	/**
	 * Model
	 */
	private Model model;

	/**
	 * View
	 */
	private View view;

	/**
	 * Class constructor
	 * 
	 * @param model
	 * @param view
	 */
	public Controller(final Model model, final View view) {
		this.model = model;
		this.view = view;

		view.addListenerRadioButtonAddToCredit(new ChangeListener() {

			@Override
			public void stateChanged(ChangeEvent e) {

			}
		});
		view.addListenerRadioButtonInHand(new ChangeListener() {

			@Override
			public void stateChanged(ChangeEvent e) {

			}
		});

		/**
		 * Calculate button
		 */
		view.addListenerbtnCalculate(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				model.setTotalLoan(view.getFieldMoney());
				model.setInterest((view.getFieldInterest()));
				model.setComisionForOpenning(view.getFieldOpenningComission());
				model.setPaymentPeriod(view.getPaymentPeriod());
				model.setMonth(view.getFieldMonths());
				model.setStrategyBaseLoan(view.getKindMethod());
				model.CreateLoan();
				view.resetPlannedPayments(model);
				
			}
		});
	}

}
