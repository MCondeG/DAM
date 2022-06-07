package utilidades;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class Ficheros {
	
	
	private String ruta;
	private File f;
	

	public Ficheros(String ruta, String nombreFichero) {

		this.ruta = ruta + File.separator + nombreFichero;
		this.f = new File(this.ruta);
		
		try {
			creaFichero(this.f);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	
	public static void creaFichero(File f) throws IOException {
		
		if (!f.exists()) f.createNewFile();
	}
	
	public void imprimirLinea(int inicio, int ultima) throws IOException {
		
		FileReader fr = new FileReader(this.ruta);
		BufferedReader br = new BufferedReader(fr);
		
		String lectura;
		int cont = 1;
		
		
		while (((lectura = br.readLine()) != null) && (cont <= ultima)) {
			
			if (cont >= inicio) System.out.println(lectura);
			
			cont++;
		}
		
		br.readLine();
		
		fr.close();
		br.close();
	}
	
	public void escribirNum(int num) throws IOException {
		
		FileWriter fw = new FileWriter(this.ruta, true);
		BufferedWriter bw = new BufferedWriter(fw);
		
		bw.write(Integer.toString(num) + " ");
		
				
		bw.flush();
		
		fw.close();
		bw.close();
	}
}