package ejercicios;

public class Enumerados1 {
	public enum DiasSemana {LUNES,MARTES,MIERCOLES,JUEVES,VIERNES,SABADO,DOMINGO}

	public static void main(String[] args) {
		// TODO Ap�ndice de m�todo generado autom�ticamente
		DiasSemana un_dia = DiasSemana.MARTES;
		System.out.println("El primer d�a de la semana es: "+DiasSemana.LUNES);
		System.out.println("El �ltimo d�a de la semana es: "+DiasSemana.DOMINGO);
		System.out.println("El d�a de la semana elegido es: "+un_dia);
	}
}