package ejercicio5;

import java.net.ServerSocket;
import java.net.Socket;
import java.io.*;

public class Servidor {

	public static void main(String[] args) {
		
		try (ServerSocket server = new ServerSocket(5000);
				Socket socket = server.accept();
				InputStream is = socket.getInputStream();
				InputStreamReader isr = new InputStreamReader(is);
				BufferedReader br= new BufferedReader(isr);
				
				OutputStream os= socket.getOutputStream();
				OutputStreamWriter osw= new OutputStreamWriter(os);
				PrintWriter pw= new PrintWriter(osw)){
			
			String numeroMaximo= br.readLine();
			int numeroCaracter= Integer.parseInt(numeroMaximo);
			for (int i = numeroCaracter; i >= 0; i--) {
				pw.println(i);
				pw.flush();
				System.out.println(i);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

}
