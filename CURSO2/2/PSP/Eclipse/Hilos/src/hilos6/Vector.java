package hilos6;

import java.util.Arrays;

public class Vector {
	
	
	private long[] vector;
	private int size;
	
	
	public Vector(int size) {
		
		this.size = size;
		this.vector = new long[this.size];
		
		long n;
		
		for (int i = 0; i < this.size; i++) {
			
			n = (long) (Math.random() * Math.pow(this.size, 2));
			
			vector[i] = n;
		}
	}
	
	public Vector(long[] mitad, int size) {
		
		this.size = size;
		this.vector = mitad;
	}
	
	
	public Vector dividirVector(int caso) {
		
		long[] mitad = new long[this.size/2];
		
		switch(caso) {
			case 1:
				mitad = Arrays.copyOfRange(this.vector, 0, this.size/2);
				break;
			case 2:
				mitad = Arrays.copyOfRange(this.vector, this.size/2, this.size);
				break;
			default:
				break;
		}
		
		return new Vector(mitad, this.size/2);
	}
	
	public long mayor() {
		
		long n = 0;
		
		for (int i = 0; i < this.size; i++) {
			
			if (n < vector[i]) n = vector[i];
		}
		
		return n;
	}
}