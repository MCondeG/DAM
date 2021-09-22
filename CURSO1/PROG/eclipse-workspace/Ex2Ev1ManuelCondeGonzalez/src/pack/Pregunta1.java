package pack;

public class Pregunta1 {

	public static void main(String[] args) {
		// TODO Apéndice de método generado automáticamente

		String[] pais = {"Australia", "Nueva Zelanda", "Perú", "Groenlandia", "Jordania"};
		
		long[] hab = {25169000, 4930000, 32162184, 57500, 9986114};
		
		long numaux;
		String Staux;
		
		for (int i = 0;i < pais.length;i++) {
			for (int j = 0;j < pais.length;j++) {
				if ((j < pais.length-1) && (pais[i].charAt(0) < pais[j].charAt(0))) {
					Staux = pais[j];
					numaux = hab[j];
					pais[j] = pais[j+1];
					pais[j+1] = Staux;
					hab[j] = hab[j+1];
					hab[j+1] = numaux;
				}
			}
		}
		
		System.out.println("Ordenado alfabéticamente:\n");
		
		for (int i = 0;i < pais.length;i++) {
			if (pais[i].equals("Perú")) System.out.println(pais[i]+"\t\t\t"+hab[i]);
			else System.out.println(pais[i]+"\t\t"+hab[i]);
		}
		
		
		for (int i = 0;i < hab.length;i++) {
			for (int j = 0;j < hab.length;j++) {
				if ((j < hab.length-1) && (hab[i] > hab[j])) {
					Staux = pais[j];
					numaux = hab[j];
					pais[j] = pais[j+1];
					pais[j+1] = Staux;
					hab[j] = hab[j+1];
					hab[j+1] = numaux;
				}
			}
		}
		
		System.out.println("\n\nOrdenado por número de habitantes:\n");
		
		for (int i = 0;i < pais.length;i++) {
			if (pais[i].equals("Perú")) System.out.println(pais[i]+"\t\t\t"+hab[i]);
			else System.out.println(pais[i]+"\t\t"+hab[i]);
		}
	}

}
