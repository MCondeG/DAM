package texto;

import java.io.*;

public class PruebaFicheros {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String ruta = "ficheros/ficherostexto/prueba.txt";
		String ruta2 = "ficheros/ficherostexto/prueba2.txt";

		
		File f = new File(ruta);
		File f2 = new File(ruta2);
		
		try {
			creaFichero(f);
			creaFichero(f2);
			leerFichero(ruta);
			escribirFichero(ruta2);
			leerFichero(ruta2);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	
	public static void creaFichero(File f) throws IOException {
		
		if (!f.exists()) f.createNewFile();
	}
	
	
	public static void leerFichero(String ruta) throws IOException {
		
		FileReader fr = new FileReader(ruta);
		BufferedReader br = new BufferedReader(fr);
		
		String lectura;
		
		while ((lectura = br.readLine()) != null) {
			
			System.out.println(lectura);
		}
		
		fr.close();
		br.close();
	}
	
	
	public static void escribirFichero(String ruta) throws IOException {
		
		FileWriter fw = new FileWriter(ruta, true); //el parámetro true determina si el fichero ya ha sido creado y escribe a partir del final. Si no se pone, sobreescribe si existe
		BufferedWriter bw = new BufferedWriter(fw);
		
		bw.newLine();
		bw.write("Escritura en fichero");
		bw.newLine();
		bw.write("con BufferedWriter");
		
		bw.flush();		//para actualizar el stream
		
		fw.close();
		bw.close();
	}
}