import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Comparador {
	Scanner teclado;
	Codificador codificar;
	GuardarDatos guardar;
	String login;
	String pass;
	String sacarLogin;
	String sacarPass;
	String ruta = "C:/Users/gripapc/Desktop/archivo.txt";
	ArrayList<String> array;
	String linea = "";
	

	public Comparador() {
		teclado = new Scanner(System.in);
		codificar = new Codificador();
		guardar = new GuardarDatos();
		array = new ArrayList<String>();

	}
	
	public void leer() {

		File archivo = new File(ruta);
		try {
		
			FileReader leerArchivo = new FileReader(archivo);
			BufferedReader buffer = new BufferedReader(leerArchivo);
			while((linea = buffer.readLine())!= null){
				array.add(linea);
			}
			
			setSacarLogin(array.get(0));
			setSacarPass(array.get(1));
		
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


	
	
	
	public void datos(){
		login = teclado.next();
		pass = teclado.next();
	}
	
	public void codificarPass(){
		pass = codificar.encriptarPass(pass);
	}
	
	public boolean comparar(String loginGuardado, String passGuardado){
		if(loginGuardado.equals(login) && passGuardado.equals(pass)){
			System.out.println("USUARIO CORRECTO");
			return true;
		}else{
			System.out.println("Usuario o contrasena incorrecta");
			return false;
		}
		
		
	}
}
