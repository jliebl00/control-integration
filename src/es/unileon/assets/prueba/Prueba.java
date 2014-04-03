package es.unileon.assets.prueba;

import javax.swing.JFrame;

import es.unileon.assets.FinancialProduct;
import es.unileon.assets.gui.Data;
import es.unileon.assets.gui.Data2;
import es.unileon.assets.gui.NewJFrame;

/**
 * Beta GUI to try loans
 * 
 */
public class Prueba {

	public static void main(String[] args) {

		Model model = new Model();
		Data2 view = new Data2(model);
		Controller controller = new Controller(model, view);
		view.setVisible(true);

	}
}
