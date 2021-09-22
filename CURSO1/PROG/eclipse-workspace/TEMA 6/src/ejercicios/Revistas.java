package ejercicios;

public class Revistas extends Publicacion {
	
	private int id;
	
	Revistas () {
		
	}
	
	Revistas (int i, int codigo, String titulo, int año) {
		
		super(codigo, titulo, año);
		this.id = i;
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Revistas [id=" + id + "]";
	}
	
	

}
