package ejercicios;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class Condicionales13Calendar {

	public static void main(String[] args) {
		// TODO Apéndice de método generado automáticamente
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Introduce la hora, minutos y segundos");
		int h = sc.nextInt();
		int m = sc.nextInt();
		int s = sc.nextInt();
		
		Calendar cal = new GregorianCalendar(); //crea el objeto Calendar asociado a la variable cal
		GregorianCalendar.getInstance(); //inicializa el Calendar a la fecha y hora del sistema
		
		cal.set(Calendar.HOUR_OF_DAY, h); //fija hora, minutos y segundos en variable cal, respetando fecha
		cal.set(Calendar.MINUTE, m);
		cal.set(Calendar.SECOND, (s+1));
		
		System.out.println(""+cal.getTime()); //muestra la variable cal en formato calendario

	}

}