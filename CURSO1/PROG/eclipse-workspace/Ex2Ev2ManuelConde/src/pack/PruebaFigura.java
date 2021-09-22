package pack;

public class PruebaFigura {

	public static void main(String[] args) {

		Figura[] f = new Figura[10];
		
		int nElem = 0;
		
		nElem = creaFigura(f, nElem);
		
		mostrarDatos(f, nElem);
	}
	
	public static int creaFigura (Figura[] f, int nElem) {
		
		Circulo c = new Circulo(0, 3);
		c.setArea(c.calculaArea(c.getRadio()));
		c.setCirculosTotales(c.getCirculosTotales() + 1);
		nElem++;
		
		
		CuadradoColoreado cc = new CuadradoColoreado(0, 9, "verde");
		cc.setArea(cc.calculaArea(cc.getLado()));
		cc.setCuadradosTotales(cc.getCuadradosTotales() + 1);
		nElem++;
		
		Rectangulo r = new Rectangulo(0, 4, 3);
		r.setArea(r.calculaArea(r.getBase(), r.getAltura()));
		r.setRectangulosTotales(r.getRectangulosTotales() + 1);
		nElem++;
		
		f[0] = c;
		f[1] = cc;
		f[2] = r;
		
		return nElem;
	}
	
	public static void mostrarDatos(Figura[] f, int nElem) {
		
		for (int i = 0; i < nElem; i++) {
			System.out.println(f[i]);
			System.out.println();
		}
	}
}