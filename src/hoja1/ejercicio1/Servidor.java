package hoja1.ejercicio1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {
	
	public static void main(String[] args) {
		
		InputStream is=null;
		InputStreamReader isr= null;
		BufferedReader br= null;
		
		OutputStream os= null;
		OutputStreamWriter osw=null;
		PrintWriter pw= null;
		
		
		
		try {
			System.out.println("Iniciando el servidor");
			ServerSocket serverSocket = new ServerSocket(5000);
			System.out.println("Acceptando al servidor");
			Socket socketCliente = serverSocket.accept();
			
			
			String mensajeRecibido= null;
			String mensajeEnviado= null;
			
			while ((mensajeRecibido=br.readLine())!= null) {
				
				mensajeEnviado="ECO->"+mensajeRecibido;
				
				System.out.println("Mensaje Recibido : "+mensajeEnviado);
				pw.println(mensajeEnviado);
				pw.flush();
			}
			
		} catch (IOException e) {
			
			e.printStackTrace();
			
		}
		
		
	}
	
}
