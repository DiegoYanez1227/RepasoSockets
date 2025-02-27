package ejercicio2;

import java.io.IOException;
import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;

public class Cliente {
	
	public static void main(String[] args) {
		try {
			Socket socketCliente= new Socket("localhost",5000);
			InputStream is= socketCliente.getInputStream();
			InputStreamReader isr= new InputStreamReader(is);
			BufferedReader br= new BufferedReader(isr);
			
			String mensajeRecibido;
			while((mensajeRecibido=br.readLine())!=null) {
				System.out.println(mensajeRecibido);
			}
			br.close();
			isr.close();
			is.close();
			
			socketCliente.close();
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
