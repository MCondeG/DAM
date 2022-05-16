package hilos7;


public class Hilo implements Runnable {
	
	private Directorio directorio;
	
	
	public Hilo(Directorio directorio) {
		this.directorio = directorio;
	}
	
	
	@Override
	public void run() {
		
		this.directorio.scan(this.directorio.getFile().getPath());
        
	}
}