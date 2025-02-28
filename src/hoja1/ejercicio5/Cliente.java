package hoja1.ejercicio5;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Cliente {
public static void main(String[] args) {
		
		try (Socket socket = new Socket("localhost", 5000);
				InputStream is = socket.getInputStream();
				InputStreamReader isr = new InputStreamReader(is);
				BufferedReader br= new BufferedReader(isr);
				
				OutputStream os= socket.getOutputStream();
				OutputStreamWriter osw= new OutputStreamWriter(os);
				PrintWriter pw= new PrintWriter(osw)){
			
			int numeroPasado= (int) Math.random()*10+1;
			pw.println(numeroPasado);
			
			String linea="";
			while((linea=br.readLine())!=null) {
				System.out.println(linea);
			}
			System.out.println("FIN");
			
		} catch (Exception e) {
		}

	}
}
