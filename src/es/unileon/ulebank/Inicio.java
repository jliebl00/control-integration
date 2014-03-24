package es.unileon.ulebank;


public class Inicio {

	public static void main(String[] args) {
		Comparador compare = new Comparador();
		Register guardar = new Register("berto","0123");
		guardar.guardarDatos();
		compare.leer();
		compare.datos();
		compare.codificarPass();
		compare.comparar(compare.getSacarLogin(),compare.getSacarPass());
		
	}

}
