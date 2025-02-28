package hoja1.ejercicio6;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import java.io.*;

public class Servidor {

	public static void main(String[] args) {
		try(
		ServerSocket server = new ServerSocket(5000);
		
		Socket socket = server.accept();
				
		InputStream is= socket.getInputStream();
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br= new BufferedReader(isr);
				
		OutputStream os= socket.getOutputStream();
		OutputStreamWriter osw = new OutputStreamWriter(os);
		PrintWriter pw = new PrintWriter(osw);
		
		){
			
			int numero= (int)Math.random()*10+1;
			String mensajeRecibido;
			int numeroRecibido;
			do {
				mensajeRecibido=br.readLine();
				numeroRecibido = Integer.parseInt(mensajeRecibido);
				if(numeroRecibido > numero) {
					System.out.println("El numero debe de ser menor");
					pw.println("El numero debe de ser menor");
					pw.flush();
				}else if(numeroRecibido< numero) {
					System.out.println("El numero debe de ser mayor");
					pw.println("El numero debe de ser mayor");
					pw.flush();
				}else {
					System.out.println("has acertado");
					pw.println("fin");
					pw.flush();
				}
			}
			while(numeroRecibido!=numero);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
