package hilos7;

import java.io.File;

public class Directorio {

	private String ruta;
	private File file;
	
	
	public Directorio() {
		
	}
	
	public Directorio(String ruta) {
		this.ruta = ruta;
		this.file = new File(this.ruta);
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

	
	public void scan(String rutaActual) {
		
		this.file = new File(rutaActual);
		
		for(File f : this.file.listFiles()){
            //System.out.println(f.getName());
			
			if (!f.isDirectory()) {
				System.out.println(f.getName());
			}
			else {
				rutaActual = rutaActual + "/" + f.getName();
				System.out.println(rutaActual);
				this.scan(rutaActual);
				rutaActual = this.file.getParent();
			}
        }
	}
}