package pack;

public class Pregunta4 {

	public static void main(String[] args) {
		// TODO Apéndice de método generado automáticamente

		
		String[] v = {"arboleda", "bandera", "juliana", "paella", "pitote", "sal", "tapadera"};
		String[] v2 = new String[v.length+1];
		String Staux;
		
		for (int i = 0;i < v.length;i++) {
			v2[i] = v[i];
		}
		
		v2[v2.length-1] = "patata";
		
		for (int i = 0;i < v2.length;i++) {
			for (int j = 0;j < v2.length;j++) {
				if ((j < v2.length-1) && (v2[j].compareTo(v2[j+1]) > 0)) {
					Staux = v2[j];
					v2[j] = v2[j+1];
					v2[j+1] = Staux;
				}
			}
		}
		
		System.out.println("Ordenado alfabéticamente:\n");
		
		for (int i = 0;i < v2.length;i++) {
			System.out.println(v2[i]);
		}
	}

}
