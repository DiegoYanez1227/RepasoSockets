package hoja1.ejercicio2;

public class Ejecutador {

	public static void main(String[] args) {
	
		for (int i = 0; i < 4; i++) {
			new Cliente();
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
