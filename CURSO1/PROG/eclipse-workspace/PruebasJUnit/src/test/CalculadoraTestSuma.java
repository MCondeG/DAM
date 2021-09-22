package test;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;


@RunWith(Parameterized.class)
public class CalculadoraTestSuma {
	
	private int num1;
	private int num2;
	private int resul;
	
	
	public CalculadoraTestSuma (int num1, int num2, int resul) {
		
		this.num1 = num1;
		this.num2 = num2;
		this.resul = resul;
	}
	
	
	@Parameters
	public static Collection<Object[]> numeros() {
		
		return Arrays.asList(new Object[][] {
			{20, 10, 30}, {10, -2, 8}, {5, 2, 52}
		});
	}
	
	@Test
	public void testSuma() {
		
		Calculadora calcu = new Calculadora(num1, num2);
		int resultado = calcu.suma();
		assertEquals(resul, resultado);
	}
}
