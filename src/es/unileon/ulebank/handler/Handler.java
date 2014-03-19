package es.unileon.ulebank.handler;

public interface Handler {
	public int compareTo(Handler another);

	@Override
	public String toString();
}
