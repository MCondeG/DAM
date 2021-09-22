package ejercicios;

public class PrincipalEmpleadoIterator {

	public static void main(String[] args) {

		ListaEmpleado le = new ListaEmpleado();
		
		System.out.println("Lista original:\n");
		le.listar();

		le.eliminarVocal();

		System.out.println("\n\nLista después de eliminar nombres que empiezan por vocal:\n");
		le.listar();
	}
}