package ejercicio4;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.io.*;

public class Server {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		final String ruta="";
		
		try (ServerSocket server = new ServerSocket(5000);
				Socket socket =server.accept();
				InputStream is= new FileInputStream(ruta);
				InputStreamReader isr= new InputStreamReader(is);
				BufferedReader br= new BufferedReader(isr);
				
				OutputStream os = new FileOutputStream(ruta);
				OutputStreamWriter osw= new OutputStreamWriter(os);
				PrintWriter pw = new PrintWriter(osw)
				){
			System.out.println("Introduce el texto que quieras. Introduce 'salir' para acabar");
			String linea="";
			while(linea.equalsIgnoreCase("salir")) {
				linea=sc.nextLine();
				pw.println(linea);
				pw.flush();
			}
			
			System.out.println("Has terminado de escribir en el fichero");
			
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

}
