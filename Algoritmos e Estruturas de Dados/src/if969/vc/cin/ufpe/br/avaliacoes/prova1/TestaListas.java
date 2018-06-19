/**
 * @author vcg@cin.ufpe.br
 * http://viniciusgarcia.com/courses/if969
 * @version 07-December-2011
 */
package if969.vc.cin.ufpe.br.avaliacoes.prova1;

/**
 * Codigo de resolucao da questao 1 - Especifique e implemente um TAD para uma Lista Simplesmente 
 * Encadeada (LSE) e a classe para o No dessa Lista.
 * 
 * Operacoes basicas em Listas: 
 * 1- Criacao;
 * 2- Insercao;
 * 3- Exclusao;
 * 4 -Busca; 
 * 5- Verificação de Lista Vazia
 */
public class TestaListas {

	public static void main(String[] args) {
		
		ListaSimpEncadeada<Integer> lista1 = new ListaSimpEncadeada<Integer>();
		System.out.println("----------------------------------");
		System.out.println("Lista encadeada: \n");
		System.out.println("Inseridos os numeros 82, 26, 10, 56, 72, 39, 100, 91 e 95");
		lista1.inserir(82);
		lista1.inserir(26);
		lista1.inserir(10);
		lista1.inserir(56);
		lista1.inserir(72);
		lista1.inserir(39);
		lista1.inserir(100);
		lista1.inserir(91);
		lista1.inserir(95);
		lista1.imprimir();
		
		System.out.println("Removendo o 95...");
		lista1.remover(95);
		
		System.out.println("Lista Impressa:");
		lista1.imprimir();
		
		System.out.println("\nExiste o 91? " + lista1.existe(91));
		System.out.println("Existe o 5? " + lista1.existe(5));
				
		System.out.print("----------------------------------");

	}
}
