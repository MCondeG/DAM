package ejercicios;

import java.util.ArrayList;

public class ArrayList1 {

	public static void main(String[] args) {
		// TODO Ap�ndice de m�todo generado autom�ticamente

		ArrayList<String> a = new ArrayList<String>();
		
		for (int i = 1; i <= 6; i++) {
			a.add("Alumno "+i);
		}
		
		for (String alumno: a) {
			System.out.println(alumno);
		}	
	}
}