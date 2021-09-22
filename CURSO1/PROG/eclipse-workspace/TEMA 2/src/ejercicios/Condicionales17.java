package ejercicios;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class Condicionales17 {

	public static void main(String[] args) {
		// TODO Apéndice de método generado automáticamente
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Introduce el dia,la hora y minutos actuales");
		String dia = sc.nextLine();
		int h = sc.nextInt();
		int m = sc.nextInt();
		
		int d = 1;
		
		switch (dia) {
		case "lunes" :
			d = 2;
			break;
		case "martes" :
			d = 3;
			break;
		case "miercoles" :
			d = 4;
			break;
		case "jueves" :
			d = 5;
			break;
		case "viernes" :
			d = 6;
			break;
		case "sabado" :
			d = 7;
			break;
		case "domingo" :
			d = 1;
			break;
		default :
			System.out.println("ERROR");
			break;
		}
		
		Calendar cal = new GregorianCalendar();
		Calendar fin = new GregorianCalendar();
		GregorianCalendar.getInstance();
		
		cal.set(Calendar.DAY_OF_WEEK, d);
		cal.set(Calendar.HOUR_OF_DAY, h);
		cal.set(Calendar.MINUTE, m);
		
		fin.set(Calendar.DAY_OF_WEEK, 6);
		fin.set(Calendar.HOUR_OF_DAY, 15);
		fin.set(Calendar.MINUTE, 0);
		fin.set(Calendar.SECOND, 0);
		
		int difd;
		int difm;
		
		difd = fin.get(Calendar.DAY_OF_WEEK)-cal.get(Calendar.DAY_OF_WEEK);
		difm = (((difd*24*60)+(24-h)*60)-(24-15)*60)-m;
		
		System.out.println("Quedan "+difm+" minutos para la libertad");
		
	}

}
