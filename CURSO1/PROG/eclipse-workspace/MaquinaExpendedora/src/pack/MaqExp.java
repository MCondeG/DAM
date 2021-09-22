package pack;

public class MaqExp {

	public static void main(String[] args) {
		
		Moneda m = new Moneda();
		Producto p = new Producto();
		Cambio c = new Cambio();
		
		double d = 0.0;			//dinero acumulado
		double precio = 0.0;	//precio de cada producto
		double cambio;			//cambio a devolver
		int mon = 0;			//menor número de monedas devueltas en total
		
		System.out.println("1. Botella de agua pequeña: 0,65 €");		//menú
		System.out.println("2. Botella de agua grande: 1,10 €");
		System.out.println("3. Zumo de Naranja 0,70 €");
		System.out.println("4. Batido 0,75 €");
		
		System.out.println();
		
		d = m.pedir();
		System.out.println("Dinero acumulado: "+d+" €");
		
		precio = p.elegir();
		
		while (d < precio) {
			System.out.println("DINERO INSUFICIENTE");
			System.out.println();
			d = m.aumentar(d);
			System.out.println("Dinero acumulado: "+d+" €");
		}
		
		cambio = (d-precio);
		System.out.println();
		System.out.println("Disfrute de su producto. Cambio a devolver: "+cambio+" €");
		System.out.println("devolviendo cambio...");
		
		while (cambio >= 0.00000001) {			/*tuve que forzar la condición hasta un número tan pequeño 
		* porque en ciertas ocasiones el bucle paraba sin devolver 1 céntimo. Esto se debía a un problema de inexactitud
		* a la hora de resolver las operaciones con double, que provocaba que se restaran más decimales de lo necesario*/
			
			try {					//simula el proceso retardado de devolución de monedas
				Thread.sleep(1500);
			} catch (InterruptedException ex) {
				System.out.println("ERROR");
			}
			cambio = c.devolver(cambio);
			mon++;
		}
		
		System.out.println();
		System.out.println("Un total de "+mon+" monedas devueltas");
	}
}