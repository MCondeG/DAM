package hilos3;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


public class Ficheros {
	
	
	private String ruta;
	private File f;
	

	public Ficheros(String nombreFichero) {

		this.ruta = "src/hilos3/ficheros/" + nombreFichero;
		this.f = new File(ruta);
		
		try {
			creaFichero(this.f);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	
	public static void creaFichero(File f) throws IOException {
		
		if (!f.exists()) f.createNewFile();
	}
	
	
	public void escribirNum() throws IOException {
		
		FileWriter fw = new FileWriter(this.ruta, true);
		BufferedWriter bw = new BufferedWriter(fw);
		
		for (int i = 0; i <= 10000; i++) {
			bw.write(Integer.toString(i) + " ");
		}
				
		bw.flush();
		
		fw.close();
		bw.close();
	}
}