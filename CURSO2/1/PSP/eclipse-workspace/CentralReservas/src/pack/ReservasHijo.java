package pack;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class ReservasHijo {

	public static void main(String[] args) throws IOException {
		
		int n;
		String error = ("No he entendido su mensaje. Introduzca una respuesta válida");
		String line = null;
		BufferedReader br;
		
		ArrayList<String> lista1 = new ArrayList<>();
		ArrayList<String> lista2 = new ArrayList<>();
		
		inicializaListas(lista1, lista2);
				
		
		// PREGUNTA 1 (realizada en ReservasMain)	
		do {
			br = compruebaBuffer();
			line = br.readLine().toUpperCase();
			
			if (!respuesta1(line)) System.err.println(error);
			
		} while (!respuesta1(line));
	
		
		// PREGUNTA 2	
		System.out.println("\nActualmente tenemos en cartelera las siguientes películas:");
		for (String pelicula : lista1) {
			System.out.println(pelicula);
		}
		
		do {
			br = compruebaBuffer();
			line = br.readLine().toUpperCase();
			
			if (!respuesta2(line, lista1)) System.err.println(error);
			
		} while (!respuesta2(line, lista1));
		
	
		// PREGUNTA 3
		System.out.println("\n¿Qué sesión desea? (mañana, mediodía, tarde o noche)");
		do {
			br = compruebaBuffer();
			line = br.readLine().toUpperCase();
			
			if (!respuesta2(line, lista2)) System.err.println(error);
			
		} while (!respuesta2(line, lista2));

		
		// PREGUNTA 4
		System.out.println("\n¿Cuantas entradas desea?");
		do {
			br = compruebaBuffer();
			line = br.readLine();
			n = Integer.parseInt(line);
			
			if (n < 1) System.err.println("Introduzca una cantidad válida");
			
		} while (n < 1);

		
		System.out.println("\n\nEn breve le dirigiremos a la plataforma de pago.\nMuchas gracias por utilizar nuestro servicio");
		
		br.close();
	}
		
	
	private static BufferedReader compruebaBuffer() throws IOException {
		
		int nent = System.in.toString().length();		//para calcular el tamaño del buffer. El método System.in.available() causa problemas
		byte[] buffer = new byte[nent];
		int n = System.in.read(buffer);
		InputStream entrada = new ByteArrayInputStream(buffer, 0, n);
		
		return (new BufferedReader(new InputStreamReader(entrada)));
	}
	
	private static void inicializaListas(ArrayList<String> lista1, ArrayList<String> lista2) {
		
		//PELICULAS
		lista1.add("INTERSTELLAR");
		lista1.add("LA PRINCESA PROMETIDA");
		lista1.add("EL CLUB DE LA LUCHA");
		lista1.add("STAR WARS: EPISODIO IX");
		lista1.add("HARRY POTTER Y EL PRISIONERO DE AZKABAN");
		
		//SESIONES
		lista2.add("MAÑANA");
		lista2.add("MEDIODÍA");
		lista2.add("MEDIODIA");
		lista2.add("TARDE");
		lista2.add("NOCHE");
	}
	
	
	private static boolean respuesta1(String line) {
		
		boolean p = false;
		
		if (line.equals("COMPRAR ENTRADA") || line.equals("COMPRAR ENTRADAS") || line.equals("RESERVAR ENTRADA") || line.equals("RESERVAR ENTRADAS")) p = true;
		
		return p;
	}
	
	private static boolean respuesta2(String line, ArrayList<String> lista) {
		
		boolean p = false;
		
		if (lista.indexOf(line) != -1) p = true;	//busca si la respuesta introducida por teclado coincide con alguna de las opciones válidas
		
		return p;
	}
}