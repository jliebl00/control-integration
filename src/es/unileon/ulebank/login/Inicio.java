
public class Inicio {

	public static void main(String[] args) {
		Comparador compare = new Comparador();
		GuardarDatos guardar = new GuardarDatos();
		guardar.datosAGuardar();
		guardar.guardarDatos();
		compare.leer();
		compare.datos();
		compare.codificarPass();
		compare.comparar(compare.getSacarLogin(),compare.getSacarPass());
		
	}

}
