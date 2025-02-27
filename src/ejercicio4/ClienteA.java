package ejercicio4;

import java.io.*;
import java.net.Socket;

public class ClienteA {

	public static void main(String[] args) {

		final String ruta="";

		try (Socket socket = new Socket("localhost", 5000);
				InputStream is= new FileInputStream(ruta);
				InputStreamReader isr= new InputStreamReader(is);
				BufferedReader br= new BufferedReader(isr);

				OutputStream os = new FileOutputStream(ruta);
				OutputStreamWriter osw= new OutputStreamWriter(os);
				PrintWriter pw = new PrintWriter(osw)
				){

			String linea;

			System.out.println("Lectura del fichero");
			while((linea=br.readLine())!=null) {
				System.out.println(linea);
			}

			System.out.println("se ha terminado de leer todo el fichero");
			socket.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	

	}

}
