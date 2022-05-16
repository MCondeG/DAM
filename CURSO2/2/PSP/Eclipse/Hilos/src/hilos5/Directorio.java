package hilos5;

import java.io.File;

import javax.swing.JTextArea;

public class Directorio {
	
	private String ruta;
	private File file;
	private JTextArea text;

	
	public Directorio() {
		
	}
	
	public Directorio(String ruta) {
		this.ruta = ruta;
		this.file = new File(this.ruta);
		this.text = new JTextArea();
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
	
	public JTextArea getText() {
		return text;
	}

	public void setText(JTextArea text) {
		this.text = text;
	}

	
	public void scan(String rutaActual) {
		
		this.file = new File(rutaActual);
		
		for(File f : this.file.listFiles()){
			
			if (!f.isDirectory()) {
				this.text.append(f.getName());
			}
			else {
				rutaActual = rutaActual + "/" + f.getName();
				this.text.append(rutaActual);
				this.scan(rutaActual);
				rutaActual = this.file.getParent();
			}
        }
	}
}