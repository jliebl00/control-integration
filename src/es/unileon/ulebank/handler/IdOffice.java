package es.unileon.ulebank.handler;



import es.unileon.ulebank.exceptions.HandlerException;

public class IdOffice implements Handler {

	private int number;

	public IdOffice(int number) throws HandlerException {
		if (Integer.toString(number).length() == 5) {
			this.number = number;
		} else {
			throw new HandlerException();
		}
	}

	@Override
	public int compareTo(Handler another) {
		return Integer.toString(number).compareTo(another.toString());
	}

}
