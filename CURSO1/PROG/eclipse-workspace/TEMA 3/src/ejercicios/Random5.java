package ejercicios;

import java.lang.Thread;

public class Random5 {

	public static void main(String[] args) {
		// TODO Apéndice de método generado automáticamente

		char n,m,o,p,q,r,s,t;
		
		for (int i = 1;i > 0;i++) {
			n = (char)(int)(Math.random()*95+32);
			m = (char)(int)(Math.random()*95+32);
			o = (char)(int)(Math.random()*95+32);
			p = (char)(int)(Math.random()*95+32);
			q = (char)(int)(Math.random()*95+32);
			r = (char)(int)(Math.random()*95+32);
			s = (char)(int)(Math.random()*95+32);
			t = (char)(int)(Math.random()*95+32);
			
			System.out.println(n+""+""+m+""+""+o+""+p+""+""+q+""+r+""+s+""+t);
		}
	}
}