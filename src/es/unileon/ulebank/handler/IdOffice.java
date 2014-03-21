package es.unileon.ulebank.handler;

/**
 * 
 * @author Patricia
 * 
 */
public class IdOffice implements Handler {

	private String numberOffice;

	public IdOffice(int number) throws MalformedHandlerException {

		if (number >= 0) {

			if (Integer.toString(number).length() == 4) {
				this.numberOffice = Integer.toString(number);
			} else {
				if (Integer.toString(number).length() < 4) {
					this.numberOffice = Integer.toString(number);
					while (numberOffice.length() <= 4) {
						numberOffice = 0 + numberOffice;
					}
				} else {
					throw new MalformedHandlerException(
							"The idOffice is malformed");
				}
			}
		} else {
			throw new MalformedHandlerException(
					"The idOffice has to be a positive number");
		}
	}

	public IdOffice(String numberOffice) throws MalformedHandlerException {
		if (Integer.parseInt(numberOffice) >= 0) {
			if (numberOffice.length() == 4) {
				this.numberOffice = numberOffice;
			} else {
				if (numberOffice.length() < 4) {
					while (numberOffice.length() <= 4) {
						numberOffice = 0 + numberOffice;
					}
				} else {
					throw new MalformedHandlerException(
							"The idOffice is malformed");
				}
			}
		} else {
			throw new MalformedHandlerException(
					"The idOffice has to be a positive number");
		}
	}

	@Override
	public int compareTo(Handler another) {
		return this.numberOffice.compareTo(another.toString());
	}

	@Override
	public String toString() {
		return this.numberOffice;
	}

}
