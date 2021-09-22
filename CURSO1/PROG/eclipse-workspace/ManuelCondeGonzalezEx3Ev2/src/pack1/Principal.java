package pack1;

public class Principal {

	public static void main(String[] args) {

		ConjPersona conj1 = new ConjPersona();
		ConjPersona conj2 = new ConjPersona();
		ConjPersona conj3 = new ConjPersona();

		conj1.inicializar1();
		System.out.println(conj1);
		conj2.inicializar2();
		System.out.println(conj2);
		conj3.inicializar3();
		
		conj3.mezclaConjuntos(conj1, conj2, conj3);
		
		System.out.println(conj3);
	}
}