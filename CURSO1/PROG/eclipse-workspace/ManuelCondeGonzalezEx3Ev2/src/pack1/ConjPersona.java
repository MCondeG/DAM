package pack1;

public class ConjPersona {

	private Persona[] conjP = new Persona[20];
	
	public ConjPersona() {
		
	}
	
	public ConjPersona(Persona[] conjP) {
		this.conjP = conjP;
	}

	public Persona[] getConjP() {
		return conjP;
	}

	public void setConjP(Persona[] conjP) {
		this.conjP = conjP;
	}
	
	
	@Override
	public String toString() {
		
		String c = "";
		
		for (int i = 0; i < 20; i++) {
			c += ("\nNombre: "+this.conjP[i].getNombreApellido()+"\nDni: "+this.conjP[i].getDni());
		}
		return c;
	}
	
	public void inicializar1() {
		
		Persona p0 = new Persona();
		this.conjP[0] = p0;
		this.conjP[0].setNombreApellido("Elvira Funes");
		this.conjP[0].setDni("00000000B");
		
		Persona p1 = new Persona();
		this.conjP[1] = p1;
		this.conjP[1].setNombreApellido("Noemi Huertas");
		this.conjP[1].setDni("11111111K");
		
		Persona p2 = new Persona();
		this.conjP[2] = p2;
		this.conjP[2].setNombreApellido("Izan Carrasco");
		this.conjP[2].setDni("22222222O");
		
		Persona p3 = new Persona();
		this.conjP[3] = p3;
		this.conjP[3].setNombreApellido("Leo Gomez");
		this.conjP[3].setDni("33333333K");
		
		Persona p4 = new Persona();
		this.conjP[4] = p4;
		this.conjP[4].setNombreApellido("Jaime Morales");
		this.conjP[4].setDni("44444444E");
		
		Persona p5 = new Persona();
		this.conjP[5] = p5;
		this.conjP[5].setNombreApellido("Guillermo Ortiz");
		this.conjP[5].setDni("55555555S");
		
		Persona p6 = new Persona();
		this.conjP[6] = p6;
		this.conjP[6].setNombreApellido("Ines Roelas");
		this.conjP[6].setDni("66666666W");
		
		Persona p7 = new Persona();
		this.conjP[7] = p7;
		this.conjP[7].setNombreApellido("Lourdes Cabañas");
		this.conjP[7].setDni("77777777X");
		
		Persona p8 = new Persona();
		this.conjP[8] = p8;
		this.conjP[8].setNombreApellido("Elena Baños");
		this.conjP[8].setDni("88888888I");
		
		Persona p9 = new Persona();
		this.conjP[9] = p9;
		this.conjP[9].setNombreApellido("Teresa Fernandez");
		this.conjP[9].setDni("99999999T");
		
		Persona p = new Persona();
		
		for (int i = 10; i < 20; i++) {
			this.conjP[i] = p;
		}
	}
	
	public void inicializar2() {
		
		
		Persona p0 = new Persona();
		this.conjP[0] = p0;
		this.conjP[0].setNombreApellido("Esther Arroyo");
		this.conjP[0].setDni("11111000K");
	
		Persona p1 = new Persona();
		this.conjP[1] = p1;
		p1.setNombreApellido("Isabel Fernandez");
		p1.setDni("22222000R");
		this.conjP[1] = p1;
		
		Persona p2 = new Persona();
		this.conjP[2] = p2;
		p2.setNombreApellido("Leo Gomez");
		p2.setDni("33333333K");
		this.conjP[2] = p2;
		
		Persona p3 = new Persona();
		this.conjP[3] = p3;
		p3.setNombreApellido("Fernando Mora");
		p3.setDni("44444000M");
		this.conjP[3] = p3;
		
		Persona p4 = new Persona();
		this.conjP[4] = p4;
		p4.setNombreApellido("Guillermo Ortiz");
		p4.setDni("55555555S");
		this.conjP[4] = p4;
			
		Persona p5 = new Persona();
		this.conjP[5] = p5;
		p5.setNombreApellido("Elvira Perez");
		p5.setDni("66666000K");
		this.conjP[5] = p5;
		
		Persona p6 = new Persona();
		this.conjP[6] = p6;
		p6.setNombreApellido("Lourdes Cabañas");
		p6.setDni("77777777X");
		this.conjP[6] = p6;
		
		Persona p7 = new Persona();
		this.conjP[7] = p7;
		p7.setNombreApellido("Clara Mesa");
		p7.setDni("44444444E");
		this.conjP[7] = p7;
		
		Persona p8 = new Persona();
		this.conjP[8] = p8;
		p8.setNombreApellido("Teresa Rodriguez");
		p8.setDni("99999000T");
		this.conjP[8] = p8;
		
		Persona p9 = new Persona();
		this.conjP[9] = p9;
		p9.setNombreApellido("Erika Ortiz");
		p9.setDni("12345678W");
		this.conjP[9] = p9;
		
		Persona p = new Persona();
		
		for (int i = 10; i < 20; i++) {
			this.conjP[i] = p;
		}
	}
	
	public void inicializar3() {
		
		Persona p = new Persona();
		
		for (int i = 0; i < 20; i++) {
			this.conjP[i] = p; 
		}
	}
	
	public Persona acceder(int i) {
		
		return this.conjP[i];
	}
	
	public void introducir(Persona p, int i) {
		this.conjP[i] = p;
	}
	
	public void introducirSinRep(Persona p, int i) {
		
		boolean rep = false;
		
		for (int k = 0; k < i; k++) {
			
			if (this.conjP[k].equals(p)) {
				rep = true;
			}
		}
		if (!rep) this.conjP[i] = p;
	}
	
	public void mezclaConjuntos(ConjPersona conj1, ConjPersona conj2, ConjPersona conj3) {
		
		for (int i = 0; i < 10; i++) {
			conj3.introducir(conj1.acceder(i), i);
		}
		
		for (int i = 10; i < 20; i++) {
			conj3.introducirSinRep(conj2.acceder(i), i);
		}
	}
	
	public void ordenar () {
		
		Persona aux = new Persona();
		
		for(int i = 0; i < 20 - 1; i++) {
            for(int j = 0; j < 20 - 1; j++) {
                if (this.conjP[j].getDni().compareToIgnoreCase(this.conjP[j+1].getDni()) > 0) {
                    aux = this.conjP[j+1];
                    this.conjP[j+1] = this.conjP[j];
                    this.conjP[j] = aux;
                }
            }
        }
	}
}