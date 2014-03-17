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
	String ruta = "C:/Users/gripapc/Desktop/archivo.txt";

	public void datosAGuardar() {
		codificar = new Codificador();
		login = "gripapc";
		pass = codificar.encriptarPass("12345");
	}

	public void guardarDatos() {
		File archivo = new File(ruta);
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

	public void leer() {

		File archivo = new File(ruta);
		try {
			FileReader leerArchivo = new FileReader(archivo);
			BufferedReader buffer = new BufferedReader(leerArchivo);
			setSacarLogin( buffer.readLine());
			setSacarPass(buffer.readLine());
			buffer.close();
		} catch (Exception ex) {
		}
	}

	public String getSacarLogin() {
		return sacarLogin;
	}

	public void setSacarLogin(String sacarLogin) {
		this.sacarLogin = sacarLogin;
	}

	public String getSacarPass() {
		return sacarPass;
	}

	public void setSacarPass(String sacarPass) {
		this.sacarPass = sacarPass;
	}
}
