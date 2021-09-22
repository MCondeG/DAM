package binario;

import java.io.*;

public class PruebaBinarios {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String ruta = "ficheros/ficherosbinario/prueba.dat";

		
		File f = new File(ruta);
		
		try {
			creaFichero(f);
			escribirFichero(ruta);
			leerFichero(ruta);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	
	public static void creaFichero(File f) throws IOException {
		
		if (!f.exists()) f.createNewFile();
	}
	
	
	public static void leerFichero(String ruta) throws IOException {
		
		FileInputStream fis = new FileInputStream(ruta);
		DataInputStream entrada = new DataInputStream(fis);
		
		int n = entrada.read();
		
		System.out.println("Datos leídos como binarios:");
		
		while (n != -1) {
			
			System.out.print(n + " ");
			n = entrada.read();		//lee byte a byte. Devuelve -1 al terminar
		}
		
		fis.close();
		entrada.close();
		
		FileInputStream fis2 = new FileInputStream(ruta);
		DataInputStream entrada2 = new DataInputStream(fis2);
		
		try {
			
			System.out.println("\n\n\nDatos leídos como enteros:");
			
			while(true) {	//bucle infinito. Terminará al finalizar el fichero con un EOFException
				
				n = entrada2.readInt();	//lee los datos como números enteros
				System.out.print(n + " ");
			}
			
		} catch (EOFException e) {
			// TODO Auto-generated catch block
			System.out.println("\n\nFin del fichero binario");
		} finally {
			
			fis2.close();
			entrada2.close();
		}
		
	}
	
	
	public static void escribirFichero(String ruta) throws IOException {
		
		FileOutputStream fos = new FileOutputStream(ruta, true); //el parámetro true determina si el fichero ya ha sido creado y escribe a partir del final. Si no se pone, sobreescribe si existe
		DataOutputStream salida = new DataOutputStream(fos);
		
		salida.writeInt(1);		//escribe enteros. Con .write() escribe en binario
		salida.writeInt(2);
		salida.writeInt(3);
		salida.writeInt(4);
		salida.writeInt(5);
		
		salida.flush();
		
		fos.close();
		salida.close();
	}
}