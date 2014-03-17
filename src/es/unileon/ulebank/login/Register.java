import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

public class GuardarDatos {

	String login;
	String pass;
	String sacarLogin;
	String sacarPass;
	Codificador codificar;
	String ruta = System.getProperty("user.dir");
	String separado = System.getProperty("file.separator");

	public void datosAGuardar() {
		codificar = new Codificador();
		login = "berto";
		pass = codificar.encriptarPass("0123");
	}

	//TODO Aqui es donde tienes que recojer los datos de la interfaz para guardarlos en el texto plano
	public void guardarDatos() {
		File archivo = new File(ruta + separado +"archivo.txt");
		try {
			FileWriter escribirArchivo = new FileWriter(archivo, true);
			BufferedWriter buffer = new BufferedWriter(escribirArchivo);
			buffer.write(login);
			buffer.newLine();
			buffer.write(pass);
			buffer.newLine();
			buffer.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}


}
