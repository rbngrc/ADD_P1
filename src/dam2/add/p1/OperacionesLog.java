package dam2.add.p1;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.time.LocalDateTime;

public class OperacionesLog {
	
	// Anade al registro cuando hay exito al logearse
	public void registroLoginCorrecto(String user) {
		
		Writer userLog;
		File log = new File("ficheros/login.log");
		LocalDateTime horaLocal = LocalDateTime.now();
		int horas = horaLocal.getHour();
		int minutos = horaLocal.getMinute();
		int dia = horaLocal.getDayOfMonth();
		int mes = horaLocal.getMonthValue();

		if (log.exists()) {
			
			try {
				userLog = new BufferedWriter(new FileWriter("ficheros/login.log", true));
				userLog.append(horas + ":" + minutos + " " + dia + "/" + mes + " Inicio de sesion de: "
						+ user.toLowerCase() + "\n");
				userLog.close();
			} catch (FileNotFoundException e) {
				System.out.println("Error al abrir el archivo");
			} catch (IOException ex) {
				System.out.println("Error de entrada/salida");
			}
			
		} else {
			
			try {
				FileOutputStream out = new FileOutputStream("ficheros/login.log");
				userLog = new BufferedWriter(new FileWriter("ficheros/login.log", true));
				userLog.append(horas + ":" + minutos + " " + dia + "/" + mes + " Inicio de sesion de: "
						+ user.toLowerCase() + "\n");
				userLog.close();
			} catch (FileNotFoundException e) {
				System.out.println("Error al abrir el archivo");
			} catch (IOException ex) {
				System.out.println("Error de entrada/salida");
			}
			
		}

	}

	// Anade al registro cuando no hay existo, solo intento
	public void registroLoginIncorrecto(String user) {
		
		Writer userLog;
		File log = new File("ficheros/login.log");
		LocalDateTime horaLocal = LocalDateTime.now();
		int horas = horaLocal.getHour();
		int minutos = horaLocal.getMinute();
		int dia = horaLocal.getDayOfMonth();
		int mes = horaLocal.getMonthValue();

		if (log.exists()) {
			
			try {
				userLog = new BufferedWriter(new FileWriter("ficheros/login.log", true));
				userLog.append(horas + ":" + minutos + " " + dia + "/" + mes + " Intento de acceso: "
						+ user.toLowerCase() + "\n");
				userLog.close();
			} catch (FileNotFoundException e) {
				System.out.println("Error al abrir el archivo");
			} catch (IOException ex) {
				System.out.println("Error de entrada/salida");
			}
			
		} else {
			
			try {
				FileOutputStream out = new FileOutputStream("ficheros/login.log");
				userLog = new BufferedWriter(new FileWriter("ficheros/login.log", true));
				userLog.append(horas + ":" + minutos + " " + dia + "/" + mes + " Intento de acceso: "
						+ user.toLowerCase() + "\n");
				userLog.close();
			} catch (FileNotFoundException e) {
				System.out.println("Error al abrir el archivo");
			} catch (IOException ex) {
				System.out.println("Error de entrada/salida");
			}
			
		}
		
	}
	
}
