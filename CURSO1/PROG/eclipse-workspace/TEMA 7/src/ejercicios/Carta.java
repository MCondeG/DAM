package ejercicios;

public class Carta {
	
	private Integer randN;
	private Integer randP;
	private static final String[] n = {"as", "dos", "tres", "cuatro", "cinco", "seis", "siete", "sota", "caballo", "rey"};
	private static final String[] p = {"bastos", "copas", "espadas", "oros"};
	private String numero;
	private String palo;
	
	
	public Carta() {
		
		randN = (int)(Math.random()*10);
		randP = (int)(Math.random()*4);
		this.numero = n[randN];
		this.palo = p[randP];
	}


	public Integer getRandN() {
		return randN;
	}

	public Integer getRandP() {
		return randP;
	}

	public String getNumero() {
		return numero;
	}

	public String getPalo() {
		return palo;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public void setPalo(String palo) {
		this.palo = palo;
	}


	public String toString() {
	
		return this.numero + " de " + this.palo;
	}
}