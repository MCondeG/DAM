package pack;

public class Pregunta3 {

	public static void main(String[] args) {
		
		String [] v1 = {"a", "b", "c"};
		String [] v2 = {"a", "b", "c"};
		
		if (igual(v1, v2)) {
			
			System.out.println("Son iguales");
			
		}
		
		else {
			
			System.out.println("No son iguales");
			
		}

	}
	
	public static boolean igual (String [] c1, String [] c2) {
		
		if (c1.length == c2.length) {
			
			for (int i = 0; i < c1.length; i ++) {
				
				if (c1[i].compareTo(c2[i]) != 0) {
					
					return false;
					
				}
				
			}
			
			return true;
			
		}
		
		else {
			
			return false;
			
		}
		
	}
 	
}	
