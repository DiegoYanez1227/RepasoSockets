package hoja1.ejercicio6;

import java.net.Socket;

import java.io.*;
import java.util.Scanner;

public class Cliente {

	public static void main(String[] args) {

		Scanner sc= new Scanner(System.in);
		try(Socket socket= new Socket("localhost",5000);
				InputStream is = socket.getInputStream();
				InputStreamReader isr = new InputStreamReader(is);
				BufferedReader br= new BufferedReader(isr);

				OutputStream os = socket.getOutputStream();
				OutputStreamWriter osw= new OutputStreamWriter(os);
				PrintWriter pw= new PrintWriter(osw);

				){

			String mensajeRecibido="";
			
			while(!((mensajeRecibido=br.readLine()).equalsIgnoreCase("fin"))) {
				System.out.println("Introduce otra opcion");
				String mensajeEnviado= sc.nextLine();
				System.out.println("Cliente envia: "+mensajeEnviado);
				pw.println(mensajeEnviado);
				pw.flush();
			}
			System.out.println("fin del programa del cliente");

		}catch(IOException e) {
			e.printStackTrace();
		}

	}

}
