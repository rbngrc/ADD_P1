package dam2.add.p1;

import java.awt.Desktop;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class OperacionesAdministrador {

	public void menuAdministrador() {
		
		File f = new File("ficheros/bloqueados.txt");
		Desktop desktop = Desktop.getDesktop();
		Scanner sc = new Scanner(System.in);
		String decision;

		if (f.exists()) {

			try {

				FileReader fr = new FileReader(f);
				BufferedReader br = new BufferedReader(fr);
				String st;
				st = null;

				System.out.println("\n" + "Estos son los usuarios bloqueados" + "\n");

				while ((st = br.readLine()) != null) {
					System.out.println(st);
					st = br.readLine();
				}

				System.out.println("\n" + "Desea desbloquear los usuarios? Si/No");
				decision = sc.nextLine();
				if (decision.equalsIgnoreCase("Si")) {
					desktop.open(f);
				} else {
					System.out.println("Los usuarios siguen bloqueados");
				}

			} catch (FileNotFoundException e) {
				System.out.println("Error al abrir el archivo");
			} catch (IOException ex) {
				System.out.println("Error de entrada/salida");
			}

		} else {
			System.out.println("No hay ningun usuario bloqueado");
		}
	
	}

}
