package ejercicio2;

import java.io.*;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {
	public static void main(String[] args) {
		
		InputStream is= null;
		InputStreamReader isr= null;
		BufferedReader br= null;
		
		
		
		try {
			ServerSocket server = new ServerSocket(5000);
			Socket socket1= aceptarPeticion(server);
			escribirCadena(socket1, "Hola Socket 1");
			
			Socket socket2= aceptarPeticion(server);
			escribirCadena(socket2, "Hola Socket 2");
			
			Socket socket3= aceptarPeticion(server);
			escribirCadena(socket3, "Hola Socket 3");
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	
	public static void escribirCadena(Socket socket, String mensaje) throws IOException {
		OutputStream os= socket.getOutputStream();
		OutputStreamWriter osw= new OutputStreamWriter(os);
		PrintWriter pw= new PrintWriter(osw);
		
		pw.println();
		pw.flush();
		
		pw.close();
		osw.close();
		os.close();
	}
	
	public static Socket aceptarPeticion(ServerSocket server) throws IOException {
		Socket socket= server.accept();
		
		return socket;
	}
}
