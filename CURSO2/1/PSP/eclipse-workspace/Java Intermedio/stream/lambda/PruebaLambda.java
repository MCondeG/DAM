package lambda;

public class PruebaLambda {

	public static void main(String[] args) {
		
		
		// Expresion Lambda de tipo consumidor (recibe parámetros, no devuelve nada)
		IFuncionalConsumidor iFuncCons = mensaje -> System.out.println("Imprimir: "+mensaje);

		iFuncCons.imprimir("Hola Mundo Lambda");
		
		
		// Expresion Lambda de tipo proveedor (sin parámetros, devuelve resultado)
		IFuncionalProveedor iFuncProv = () -> {return 5;};
		
		System.out.println("Numero: "+iFuncProv.numero());
		
		
		// Expresion Lambda de tipo función (recibe parámetros, devuelve resultado)
		IFuncionalFuncion iFuncFunc = (x, y) -> {return x*y;};
		
		System.out.println("Multiplica: "+iFuncFunc.multiplica(3, 4));
		
		
		// Expresion Lambda de tipo predicado (recibe parámetros, devuelve un valor booleano)
		IFuncionalPredicado iFuncPred = (cadena) -> {return (cadena.length() > 10);};
		
		System.out.println("Comprueba1: "+iFuncPred.comprueba("Esto es una cadena de longitud > 10"));
		System.out.println("Comprueba2: "+iFuncPred.comprueba("long < 10"));
		
		System.out.println();
		
		
		// Expresion Lambda con método referenciado
		IFuncionalConsumidor iFuncCons2 = System.out::println;
		
		iFuncCons2.imprimir("Imprimir con referencia a método: Hola Mundo");
	}
}