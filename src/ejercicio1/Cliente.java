package ejercicio1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

public class Cliente {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		InputStream is=null;
		InputStreamReader isr= null;
		BufferedReader br= null;
		
		OutputStream os= null;
		OutputStreamWriter osw= null;
		PrintWriter pw=null;
		
		
		try {
			
			System.out.println("Creando el socket Cliente");
			Socket clienteSocket= new Socket();
			System.out.println("Estableciendo conexion");
			clienteSocket.connect(new InetSocketAddress("localhost", 5000));
            System.out.println("Cliente Conectado al servidor.");
            
            
            is= clienteSocket.getInputStream();
            isr= new InputStreamReader(is);
            br= new BufferedReader(isr);
            
            os= clienteSocket.getOutputStream();
            osw= new OutputStreamWriter(os);
            pw= new PrintWriter(osw);
            
			String mensaje= "";
			
			String mensajeRecibido="";
			
			do {
				System.out.println("introduce el texto a pasarle al servidor");
				mensaje= sc.nextLine();
				
				pw.println(mensaje);
				pw.flush();
				
				mensajeRecibido=br.readLine();
				
				System.out.println("cliente: "+mensajeRecibido);
			}while(!mensajeRecibido.equalsIgnoreCase("salir"));
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
