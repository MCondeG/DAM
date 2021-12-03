package utilidades;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class Fichero {

	
	public Fichero (String ruta) {
		
		File f = new File(ruta);
		
		try {
			creaFichero(f);
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}


	public static void creaFichero(File f) throws IOException {
		
		if (!f.exists()) f.createNewFile();
	}


	public void leerFichero(String ruta) throws IOException {
	
		FileReader fr = new FileReader(ruta);
		BufferedReader br = new BufferedReader(fr);
		
		String lectura;
		
		while ((lectura = br.readLine()) != null) {
			
			System.out.println(lectura);
		}
		
		fr.close();
		br.close();
	}


	public void escribirFichero(String ruta, String mensaje) throws IOException {
	
		FileWriter fw = new FileWriter(ruta, true); //el parámetro true determina si el fichero ya ha sido creado y escribe a partir del final. Si no se pone, sobreescribe si existe
		BufferedWriter bw = new BufferedWriter(fw);
		
		bw.write(mensaje + "\n");
		
		bw.flush();		//para actualizar el stream
		
		fw.close();
		bw.close();
	}
}