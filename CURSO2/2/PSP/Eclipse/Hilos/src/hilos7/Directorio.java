package hilos7;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class Directorio {

	private String ruta;
	private File file;
	private int cont;
	
	public Directorio() {
		
	}
	
	public Directorio(String ruta) {
		this.ruta = ruta;
		this.file = new File(this.ruta);
		this.cont = 0;
	}
	
	
	public String getRuta() {
		return ruta;
	}

	public void setRuta(String ruta) {
		this.ruta = ruta;
	}

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}
	
	public int getCont() {
		return cont;
	}

	public void setCont(int cont) {
		this.cont = cont;
	}

	
	public synchronized void scan(String palabra, String rutaActual) throws FileNotFoundException {
		
		this.file = new File(rutaActual);
		
		if (this.file.listFiles() != null) {
			for(File f : this.file.listFiles()){
				
				if (!f.isDirectory()) {
					Scanner sc = new Scanner(f);
					if (sc.findWithinHorizon(palabra, 0) != null) this.cont++;
					
				}
				else {
					rutaActual = rutaActual + File.separator + f.getName();
					this.scan(palabra, rutaActual);
					rutaActual = this.ruta;
				}
	        }
		}
	}
}