package es.unileon.assets.FinancialProducts;

import java.awt.List;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

/**
 * Euribor class
 * 
 * 
 * v1.0 Initial version
 */
public class Euribor implements FinancialProductBase {
	
	/**
	 * List of Euribor observers
	 */
	private java.util.List<FinancialProductObserverBase> observers;
	
	/**
	 * Value of the Euribor at this moment
	 */
	private double interestRate;
	
	/**
	 * Contructor of Euribor class
	 * @param list List of Euribor observers
	 * @param iRate Value of the Euribor right now
	 */
	public Euribor(java.util.List<FinancialProductObserverBase> list,
			float iRate) {

		this.observers = list;
		interestRate = iRate;
	}
	
	/**
	 * Method used to add an observer to the list
	 * @param ob Specific observer expected to add
	 */
	public void registerObserver(FinancialProductObserverBase ob) {

		if (!observers.contains(ob)) {

			observers.add(ob);
		}
	}

	/**
	 * Method used to remove an observer from the list
	 * @param ob Specific observer expected to remove
	 */
	public void removeObserver(FinancialProductObserverBase ob) {

		if (!observers.isEmpty()) {

			if (observers.contains(ob)) {

				observers.remove(ob);
			}
		}
	}
	
	/**
	 * Method used to notify to the observers that the value of the Euribor has changed
	 */
	public void notifyObservers() {
		for (FinancialProductObserverBase observer : observers) {
			observer.update();
		}

	}
	
	/**
	 * Method used to change the present value of the Euribor
	 */
	public void setInterestRate(float interestRate) {

		this.interestRate = interestRate;
	}
	
	/**
	 * Method used to return the observers list
	 * @return List with all observers that has the Euribor right now
	 */
	public java.util.List<FinancialProductObserverBase> getObservers() {
		return this.observers;
	}
	
	/**
	 * Method used to return the present value of the Euribor
	 * @return Double with the value of the Euribor
	 */
	public double getInterestRate() {
		return this.interestRate;
	}
	
	
	/**
	 * Method to get current Euribor value from French Bank
	 * @return 0 if something go wrong or Euribor value if no problem appear
	 */
	public double getEuribor() {
		try {
			URL url12 = new URL(
					"https://www.banque-france.fr/fileadmin/user_upload/banque_de_france/Economie_et_Statistiques/Changes_et_Taux/qs.d.ieueonia.csv");
			URLConnection urlConn = url12.openConnection();
			InputStreamReader inStream = new InputStreamReader(
					urlConn.getInputStream());
			BufferedReader buff = new BufferedReader(inStream);

			String cvsSplitBy = ";";
			String line = "";
			String[] euribor = null;

			while ((line = buff.readLine()) != null) {
				euribor = line.split(cvsSplitBy);
			}

			return Double.parseDouble(Float.valueOf(euribor[1]).toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return 0;
	}



}
