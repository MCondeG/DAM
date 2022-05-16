package hilos5;

import javax.swing.JTextArea;


public class Hilo extends Thread {

private Directorio directorio;
private JTextArea text;
	
	
	public Hilo(Directorio directorio) {
		this.directorio = directorio;
		this.text = new JTextArea();
	}
	
	
	public JTextArea getText() {
		return text;
	}
	
	public void setText(JTextArea text) {
		this.text = text;
	}
	
	
	@Override
	public void run() {
		
		this.directorio.scan(this.directorio.getFile().getPath());
		this.text = this.directorio.getText();
	}
}