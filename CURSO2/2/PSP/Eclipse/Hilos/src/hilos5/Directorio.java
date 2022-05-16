package hilos5;

import java.io.File;


public class Directorio {
	
	private String ruta;
	private File file;
	private String text;

	
	public Directorio() {
		
	}
	
	public Directorio(String ruta) {
		this.ruta = ruta;
		this.file = new File(this.ruta);
		this.text = "";
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
	
	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	
	public void scan(String rutaActual) {
		
		this.file = new File(rutaActual);
		
		if (this.file.listFiles() != null) {
			for(File f : this.file.listFiles()){
				
				if (!f.isDirectory()) this.text = this.text + "\n" + f.getName();
				else {
					rutaActual = rutaActual + File.separator + f.getName();
					this.text = this.text + "\n\n" + rutaActual;
					this.scan(rutaActual);
					rutaActual = this.ruta;
				}
	        }
		}
	}
}