package hilos5;


public class Hilo extends Thread {

private Directorio directorio;
private String text;
	
	
	public Hilo(Directorio directorio) {
		this.directorio = directorio;
		this.text = "";
	}
	
	
	public String getText() {
		return text;
	}
	
	public void setText(String text) {
		this.text = text;
	}
	
	
	@Override
	public void run() {
		
		this.directorio.scan(this.directorio.getRuta());
		this.text = this.directorio.getText();
	}
}