package dam2.add.p1;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Scanner;

public class OperacionesNuevoUsuario {

	public void anadirNuevoUsuario(String user, String pass) {
		
		Scanner sc = new Scanner(System.in);
		String decision;

		System.out.println("Este usuario no existe:");
		System.out.println("¿Desea agregar el nuevo usuario? Si/No");
		decision = sc.nextLine();

		if (decision.equalsIgnoreCase("Si")) {
			System.out.println("Usuario: " + user + " y contrasena: " + pass + " agregado con exito");
			Writer output;
			
			try {
				output = new BufferedWriter(new FileWriter("ficheros/acceso.txt", true));
				output.append(user.toLowerCase() + ":" + pass.toLowerCase() + "\n");
				output.close();
			} catch (FileNotFoundException e) {
				System.out.println("Error al abrir el archivo");
			} catch (IOException ex) {
				System.out.println("Error de entrada/salida");
			}
			
		} else {
			System.out.println("No se ha anadido nuevo usuario");
		}

	}
	
}
