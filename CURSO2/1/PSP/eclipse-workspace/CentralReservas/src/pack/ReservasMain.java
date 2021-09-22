package pack;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class ReservasMain {
	
	public static void main(String[] args) throws IOException {
                		
        ProcessBuilder pb = ejecuta(ReservasHijo.class, args);
        
		pb.redirectErrorStream(true);
		Process proc = pb.start();
				
		InputStream salida = proc.getInputStream();		//salida del proceso hijo
		OutputStream entrada = proc.getOutputStream();	//entrada del proc hijo

		bienvenida();
		
		do {
			compruebaBuffer(entrada, salida);
		} while (vivo(proc));
		
	}
	
	
	private static ProcessBuilder ejecuta(Class<?> procHijo, String[] args) {
		//método para encontrar el path de la clase hija y devolver un ProcessBuilder creado con dicha ruta (sin usar .jar e independiente del SO)
		
		String javaHome = System.getProperty("java.home");
		String javaBin = javaHome + File.separator + "bin" + File.separator + "java";
		String env = "-cp";
		String classpath = System.getProperty("java.class.path");
		String className = procHijo.getName();
		
		LinkedList<String> command = new LinkedList<>();
		command.add(javaBin);
		command.add(env);
		command.add(classpath);
		command.add(className);
		if (args != null) {
			List<String> listaArgs = new LinkedList<>(Arrays.asList(args));
			command.addAll(listaArgs);
		}
		
		//System.out.println(command);      //(muestra por pantalla el comando del ProcessBuilder para hacer seguimiento)
		
		return (new ProcessBuilder(command));
	}
	
	private static boolean vivo(Process proc) {
		//si el proceso hijo ha terminado devuelve falso, si no ha terminado lanza una excepción y devuelve true
		try {
			proc.exitValue(); 
			return false;
		}
		catch (IllegalThreadStateException e) {
			return true;
		}
	}
	
	private static void compruebaBuffer(OutputStream entrada, InputStream salida) throws IOException {
		
		//se comprueba si hay información para enviar al proceso hijo
		int nent = System.in.available();
		if (nent > 0) {
			//si existe información se envía al proceso hijo
			byte[] buffer = new byte[nent];
			int n = System.in.read(buffer);
			entrada.write(buffer, 0, n);
			entrada.flush();
		}

		try {
			Thread.sleep(10);	//pequeño retardo para que se ejecute el flush
		}
		catch (InterruptedException e) {
			e.printStackTrace();
			Thread.currentThread().interrupt();
		}
		
		//se comprueba el stream de salida del proceso hijo
		int nsal = salida.available();
		if (nsal > 0) {
			//si el stream de salida del proceso hijo tiene información se muestra por pantalla
			byte[] buffer = new byte[nsal];        //buffer de comunicación entre procesos
			int n = salida.read(buffer);
			System.out.println(new String(buffer, 0, n));
		}
	}
	
	private static void bienvenida() {
		
		System.out.println("\t\t\t**************************************");
		System.out.println("\t\t\t*                                    *");
		System.out.println("\t\t\t*     CENTRAL DE RESERVAS - CINE     *");
		System.out.println("\t\t\t*                                    *");
		System.out.println("\t\t\t**************************************");
		
		System.out.println("\n\n");
		System.out.println("Bienvenido a la central de venta de entradas. ¿Cómo puedo ayudarle?");
	}
}