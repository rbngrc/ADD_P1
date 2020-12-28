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

public class OperacionesBloqueo {

	// Lectura documento ficheros\bloqueados.txt
	public void compruebaBloqueado(String user, String pass) {

		OperacionesAcceso usuario = new OperacionesAcceso();
		OperacionesLog operacionesLog = new OperacionesLog();
		boolean bloqueado = false;
		File f = new File("ficheros\bloqueados.txt");

		if (f.exists()) {

			try {
				FileReader fr = new FileReader(f);
				BufferedReader br = new BufferedReader(fr);
				String st;
				st = null;

				while ((st = br.readLine()) != null) {
					String[] word = st.split(":");

					if (word[0].equals(user) && word[1].equals("block")) {
						System.out.println("Usuario bloqueado, por favor contacta con el administrador");
						bloqueado = true;
					}

				}

				if (!bloqueado) {
					usuario.cribaUsuarios(user, pass);
					operacionesLog.registroLoginCorrecto(user);
				}

				br.close();

			} catch (FileNotFoundException e) {
				System.out.println("Error al abrir el archivo");
			} catch (IOException ex) {
				System.out.println("Error de entrada/salida");
			}

		} else {
			usuario.cribaUsuarios(user, pass);
			operacionesLog.registroLoginCorrecto(user);
		}

	}

	// Anade usuarios al documento ficheros\bloqueados.txt
	public void bloquearUsuario(String user, String pass) {
		
		Writer bloqueadorUsuarios;

		System.out.println("La cuenta ha sido bloqueada, contacte con el administrador");
		File bloqueados = new File("ficheros/bloqueados.txt");
		
		if (bloqueados.exists()) {
			
			try {
				bloqueadorUsuarios = new BufferedWriter(new FileWriter("ficheros/bloqueados.txt", true));
				bloqueadorUsuarios.append(user + ":block" + "\n");
				bloqueadorUsuarios.close();
			} catch (FileNotFoundException e) {
				System.out.println("Error al abrir el archivo");
			} catch (IOException ex) {
				System.out.println("Error de entrada/salida");
			}
			
		} else {
			
			try {
				FileOutputStream out = new FileOutputStream("ficheros/bloqueados.txt");
				bloqueadorUsuarios = new BufferedWriter(new FileWriter("ficheros/bloqueados.txt", true));
				bloqueadorUsuarios.append(user + ":block" + "\n");
				bloqueadorUsuarios.close();
			} catch (FileNotFoundException e) {
				System.out.println("Error al abrir el archivo");
			} catch (IOException ex) {
				System.out.println("Error de entrada/salida");
			}
			
		}

	}

}
