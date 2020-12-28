package dam2.add.p1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Scanner;

public class OperacionesAcceso {

	private int contador = 3;
	private boolean existe = false;
	OperacionesBloqueo bloqueo = new OperacionesBloqueo();
	OperacionesLog operacionesLog = new OperacionesLog();
	OperacionesNuevoUsuario newUser = new OperacionesNuevoUsuario();
	private File f = new File("ficheros/acceso.txt");

	// Menu entrada de datos
	public void menu() {
		
		Scanner sc1 = new Scanner(System.in);
		Scanner sc2 = new Scanner(System.in);

		System.out.println("introduce usuario");
		String user = sc1.nextLine();
		System.out.println("introduce contrasena");
		String pass = sc2.nextLine();

		Usuario usuario = new Usuario(user, pass);

		leeDocumento(usuario.getUser(), usuario.getPass());
		
	}
	
	// Menu fallo de contrasena
	/*
	 * public void solicitaContrasena(String user) {
	 * 
	 * Scanner sc = new Scanner(System.in);
	 * 
	 * System.out.println("introduce contrasena"); String pass = sc.nextLine();
	 * 
	 * Usuario usuario = new Usuario(user, pass);
	 * 
	 * leeDocumento(user, usuario.getPass()); }
	 */

	// Lectura documento acceso.txt
	private void leeDocumento(String user, String pass) {
		
		try {
			
			FileReader fr = new FileReader(f);
			BufferedReader br = new BufferedReader(fr);
			String st;
			st = null;
			
			while ((st = br.readLine()) != null) {
				String[] word = st.split(":");
				
				if (word[0].equals(user) && word[1].equals(pass)) {
					bloqueo.compruebaBloqueado(user, pass);
					existe = true;
				} else if (word[0].equals(user) && !word[1].equals(pass)) {
					contadorIntentos(user, pass);
					operacionesLog.registroLoginIncorrecto(user);
					existe = true;
				}
				
			}
			
			if (!existe) {
				newUser.anadirNuevoUsuario(user, pass);
				operacionesLog.registroLoginIncorrecto(user);
			}
			
			br.close();

		} catch (FileNotFoundException e) {
			System.out.println("Error al abrir el archivo");
		} catch (IOException ex) {
			System.out.println("Error de entrada/salida");
		}

	}
	
	// Limite de los intentos para logearse
	public void contadorIntentos(String user, String pass) {
		if (contador != 0) {
			
			if (user == "admin" && pass == "admin") {
				cribaUsuarios(user, pass);
			} else {
				contador--;
				System.out.println("Contrasena incorrecta, por favor vuelva a intentarlo");
				System.out.println("Numero de intentos restante: " + contador + "\n");
				/* solicitaContrasena(user); */
				menu();
			}
			
		} else {
			
			bloqueo.bloquearUsuario(user, pass);
			
		}
	}

	// Discrimina entre usuarios normales y administrador
	public void cribaUsuarios(String user, String pass) {
		
		OperacionesAdministrador menuAdmin = new OperacionesAdministrador();
		
		if (user.equals("admin") && pass.equals("admin")) {
			menuAdmin.menuAdministrador();
		} else {
			System.out.println("Logueado correctamente");
			System.out.println("Hola " + user);
		}
		
	}

}
