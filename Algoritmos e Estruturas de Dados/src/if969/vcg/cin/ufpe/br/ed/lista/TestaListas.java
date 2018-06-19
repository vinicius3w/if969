/**
 * @author vcg@cin.ufpe.br
 * http://viniciusgarcia.com/courses/if969
 * @version 07-December-2011
 */
package if969.vcg.cin.ufpe.br.ed.lista;

public class TestaListas {

	public static void main(String[] args) {
		
		ListaSimpEncadeada<Integer> lista1 = new ListaSimpEncadeada<Integer>();
		System.out.println("----------------------------------");
		System.out.println("Lista encadeada: \n");
		System.out.println("Inseridos os numeros 82, 26, 91 e 95");
		lista1.inserir(82);
		lista1.inserir(26);
		lista1.inserir(91);
		lista1.inserir(95);
		lista1.imprimir();
		
		System.out.println("Removendo o 95...");
		lista1.remover(95);
		
		System.out.println("Lista Impressa:");
		lista1.imprimir();
		
		System.out.println("\nExiste o 91? " + lista1.existe(91));
		System.out.println("Existe o 5? " + lista1.existe(5));
		
		Fila<Integer> fila = lista1.retornaFila();
		System.out.println("Imprimindo Fila:");
		Integer n = fila.dequeue();
		while(n != null) {
			System.out.print(n + " ");
			n = fila.dequeue();
		}
		System.out.println();
		
		Pilha<Integer> pilha = lista1.retornaPilha();
		System.out.println("Imprimindo Pilha (topo -> base): ");
		n = pilha.pop();
		while(n != null) {
			System.out.print(n + " ");
			n = pilha.pop();
		}
		
		ListaDupEncOrdenada<Integer> lista2 = new ListaDupEncOrdenada<Integer>();
		System.out.println();
		System.out.println("----------------------------------");
		System.out.println("Lista duplamente encadeada ordenada: \n");
		System.out.println("Inseridos os numeros 68, 49, 25, 1, 27, 99 e 8");
		lista2.inserir(68);
		lista2.inserir(49);
		lista2.inserir(25);
		lista2.inserir(1);
		lista2.inserir(27);
		lista2.inserir(99);
		lista2.inserir(8);
		
		System.out.println("Removendo o 27...");
		lista2.remover(27);
		
		System.out.println("Impressa:");
		lista2.imprimir();
		
		System.out.println("\nExiste o 49? " + lista2.buscar(49));
		System.out.println("Existe o 2? " + lista2.buscar(2));
		
		fila = lista2.retornaFila();
		System.out.println("Imprimindo Fila:");
		n = fila.dequeue();
		while(n != null) {
			System.out.print(n + " ");
			n = fila.dequeue();
		}
		System.out.println();
		
		pilha = lista2.retornaPilha();
		System.out.println("Imprimindo Pilha (topo -> base): ");
		n = pilha.pop();
		while(n != null) {
			System.out.print(n + " ");
			n = pilha.pop();
		}
		
		System.out.println("\nElemento minimo: " + lista2.retornaMinimo());
		System.out.println("Elemento maximo: " + lista2.retornaMaximo());
		
		System.out.print("----------------------------------");

	}
}
