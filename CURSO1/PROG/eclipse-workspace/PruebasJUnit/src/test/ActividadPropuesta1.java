package test;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class ActividadPropuesta1 {

	
	private static Calculadora calcu;
	
	@BeforeClass
	public static void creaCalculadora() {
		calcu = new Calculadora(10, 30);
	}
	
	@AfterClass
	public static void borraCalculadora() {
		calcu = null;
	}
	
	@Test
	public void testResta() {
		
		int resultado = calcu.resta();
		assertEquals(20, resultado);
	}

	@Test
	public void testResta2() {
		
		boolean resultado = calcu.resta2();
		assertFalse(resultado);
	}

	@Test
	public void testDivide2() {
		
		Integer resultado = calcu.divide2();
		assertNotNull(resultado);
	}

}
