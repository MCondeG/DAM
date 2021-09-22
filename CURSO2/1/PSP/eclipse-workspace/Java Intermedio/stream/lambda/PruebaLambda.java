package lambda;

public class PruebaLambda {

	public static void main(String[] args) {
		
		
		// Expresion Lambda de tipo consumidor (recibe par�metros, no devuelve nada)
		IFuncionalConsumidor iFuncCons = mensaje -> System.out.println("Imprimir: "+mensaje);

		iFuncCons.imprimir("Hola Mundo Lambda");
		
		
		// Expresion Lambda de tipo proveedor (sin par�metros, devuelve resultado)
		IFuncionalProveedor iFuncProv = () -> {return 5;};
		
		System.out.println("Numero: "+iFuncProv.numero());
		
		
		// Expresion Lambda de tipo funci�n (recibe par�metros, devuelve resultado)
		IFuncionalFuncion iFuncFunc = (x, y) -> {return x*y;};
		
		System.out.println("Multiplica: "+iFuncFunc.multiplica(3, 4));
		
		
		// Expresion Lambda de tipo predicado (recibe par�metros, devuelve un valor booleano)
		IFuncionalPredicado iFuncPred = (cadena) -> {return (cadena.length() > 10);};
		
		System.out.println("Comprueba1: "+iFuncPred.comprueba("Esto es una cadena de longitud > 10"));
		System.out.println("Comprueba2: "+iFuncPred.comprueba("long < 10"));
		
		System.out.println();
		
		
		// Expresion Lambda con m�todo referenciado
		IFuncionalConsumidor iFuncCons2 = System.out::println;
		
		iFuncCons2.imprimir("Imprimir con referencia a m�todo: Hola Mundo");
	}
}