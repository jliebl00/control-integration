package es.unileon.ulebank.handler;



import es.unileon.ulebank.exceptions.HandlerException;

public class IdDNI implements Handler {
	
	private char letter;
	private int dni;

	public IdDNI(int dni, char letter) throws HandlerException {
//Comprobar mayusculas. ignoreCase
//		if (Integer.toString(dni).length() == 8
//				&& Character.toString(letter).compareTo("ñ") != 0) {
			this.letter = letter;
			this.dni = dni;
//		} else {
//			throw new HandlerException();
//		}
	}

	public IdDNI(String dni) throws HandlerException {
		
		if (dni.length() == 9 && Character.toString(dni.charAt(dni.length()-1)).compareTo("ñ") != 0) {
			this.letter = dni.charAt(dni.length() - 1);
			this.dni = Integer.parseInt(dni.substring(0, dni.length() - 1));
		} else {
			throw new HandlerException();
		}
	}

	@Override
	public int compareTo(Handler another) {
		return this.toString().compareTo(another.toString());
	}

	@Override
	public String toString() {
		String resultado;
		resultado = Integer.toString(dni);
		return resultado.concat(Character.toString(letter));
	}

}
