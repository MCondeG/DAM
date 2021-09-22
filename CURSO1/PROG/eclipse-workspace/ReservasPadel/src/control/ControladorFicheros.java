package control;

import java.io.*;
import java.util.ArrayList;

import modelo.*;

public class ControladorFicheros {		//clase con los métodos para controlar la lectura y escritura de ficheros
	
	private String ruta;
	private File f;
	private static Util u;
	

	public ControladorFicheros(int numPista) {
		
		u = new Util();
		
		this.ruta = "ficheros/pista" + numPista + ".txt";
		
		try {
			creaFichero(this.f, this.ruta);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	// crea los ficheros la primera vez que se ejecute la aplicación
	public static void creaFichero(File f, String ruta) throws IOException {
		
		f = new File(ruta);
		if (!f.exists()) f.createNewFile();
		
	}
	
	// guarda la reserva en el fichero
	public void escribir(Fecha fecha) throws IOException {
		
		FileWriter fw = new FileWriter(this.ruta, true);
		BufferedWriter bw = new BufferedWriter(fw);
		bw.write(fecha.toString());
		bw.newLine();
		
		bw.close();
		fw.close();
	}
	
	// lee las reservas desde cada fichero al iniciar el programa para cargarlas en ram.
	public ArrayList<Fecha> leer() throws IOException {
		
		FileReader fr = new FileReader(this.ruta);
		BufferedReader br = new BufferedReader(fr);
		
		ArrayList<Fecha> reservas = new ArrayList<Fecha>();
		String cad;
		
		while ((cad = br.readLine()) != null) {
			
			Fecha fecha = u.separarFechas(cad);
			reservas.add(fecha);
		}
		
		br.close();
		fr.close();
		
		return reservas;
	}
}