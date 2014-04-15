package es.unileon.assets;

public enum PaymentPeriod {
	Mensual(12), Bimensual(6), Trimestral(4), Semestral(2), Anual(1);
	int period;

	/**
	 * Constructor
	 * 
	 * @param period
	 */
	private PaymentPeriod(int period) {
		this.period = period;
	}

	/**
	 * Method that returns the period inserted with the constructor
	 * 
	 * @return
	 */
	public int getPeriod() {
		return period;

	}

	/**
	 * Method that changes the number of enum, used for calculate the fees and
	 * to know the period in months
	 * 
	 * @param month
	 * @return
	 */
	public int numFee(int month) {
		int num = this.getPeriod();
		if (num == 12)
			return 1;
		else if (num == 6)
			return 2;
		else if (num == 4)
			return 3;
		else if (num == 2)
			return 6;
		else if (num == 1)
			return 12;
		return 0;

	}
}
