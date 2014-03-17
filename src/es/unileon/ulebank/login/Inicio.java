
public class Inicio {

	public static void main(String[] args) {
		Comparador compare = new Comparador();
		GuardarDatos guardar = new GuardarDatos();
		guardar.datosAGuardar();
		guardar.guardarDatos();
		guardar.leer();
		compare.datos();
		compare.codificarPass();
		compare.comparar(guardar.getSacarLogin(),guardar.getSacarPass());
		
	}

}
