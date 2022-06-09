package controlador;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Timestamp;

public class Log {

	private String ruta;
	private File f;
	

	public Log(String nombreFichero) {

		this.ruta = "src/log/" + nombreFichero;
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
	
	
	public void escribirLog(String texto) throws IOException {
		
		FileWriter fw = new FileWriter(this.ruta, true);
		BufferedWriter bw = new BufferedWriter(fw);
		
		
		Timestamp timeStamp = new Timestamp(System.currentTimeMillis());
		
		
		bw.write(timeStamp + "\n" + texto + "\n\n\n");
				
		bw.flush();
		
		fw.close();
		bw.close();
	}
}