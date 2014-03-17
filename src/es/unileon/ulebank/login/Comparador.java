import java.util.Scanner;

public class Comparador {
	Scanner teclado;
	Codificador codificar;
	GuardarDatos guardar;
	String login;
	String pass;

	public Comparador() {
		teclado = new Scanner(System.in);
		codificar = new Codificador();
		guardar = new GuardarDatos();

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
