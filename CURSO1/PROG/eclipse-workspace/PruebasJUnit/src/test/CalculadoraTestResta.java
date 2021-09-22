package test;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;


@RunWith(Parameterized.class)
public class CalculadoraTestResta {
	
	private int num1;
	private int num2;
	private int resul;
	
	
	public CalculadoraTestResta (int num1, int num2, int resul) {
		
		this.num1 = num1;
		this.num2 = num2;
		this.resul = resul;
	}
	
	
	@Parameters
	public static Collection<Object[]> numeros() {
		
		return Arrays.asList(new Object[][] {
			{10, 10, 0}, {10, 30, 20}, {5, 8, -3}
		});
	}
	
	@Test
	public void testResta() {
		
		Calculadora calcu = new Calculadora(num1, num2);
		int resultado = calcu.resta();
		assertEquals(resul, resultado);
	}
}
