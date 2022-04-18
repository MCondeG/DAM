package controlador;

import java.io.*;

import modelo.Usuario;


public class Ficheros {
	
	
	private String ruta;
	private File f;
	

	public Ficheros() {

		this.ruta = "src/modelo/usuarios/usuarios.txt";
		this.f = new File(ruta);
		
		try {
			creaFichero(this.f);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	public static void creaFichero(File f) throws IOException {
		
		if (!f.exists()) f.createNewFile();
	}
	
	
	public void guardarUsuario(Usuario user) throws IOException {
		
		FileWriter fw = new FileWriter(this.ruta, true);
		BufferedWriter bw = new BufferedWriter(fw);
		
		bw.write(user.toString());
		bw.newLine();
		
		bw.flush();
		
		fw.close();
		bw.close();
	}
}