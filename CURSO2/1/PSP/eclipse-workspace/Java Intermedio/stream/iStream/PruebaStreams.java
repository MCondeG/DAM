package iStream;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PruebaStreams {

	public static void main(String[] args) {
		
		boolean existe = false;
		
		String[] arr = new String[]{"a", "b", "c"};
		ArrayList<String> list = new ArrayList<>();
		list.add("a");
		list.add("b");
		list.add("c");
		
		Stream<String> stream1 = Arrays.stream(arr);
		Stream<String> stream2 = list.stream();
		
		
		existe = stream2.anyMatch(element -> element.contains("a"));

		if (existe) System.out.println("Éxito!");
		else System.out.println("Nope");
		
		
		ArrayList<Persona> list2 = new ArrayList<>();

		list2.add(new Persona("Ana"));
		list2.add(new Persona("Pepe"));
		list2.add(new Persona("Alberto"));
		list2.add(new Persona("Juan"));
		list2.add(new Persona("Ana"));
		list2.add(new Persona("Antonio"));
		list2.add(new Persona("María"));
		
		List<String> nombrePersonas = list2.stream().map(Persona::getNombre).filter(nombre -> nombre.startsWith("A")).collect(Collectors.toList());
		
		System.out.println(nombrePersonas.toString());
	}

}
