/**
 * @author vcg@cin.ufpe.br
 * http://viniciusgarcia.com/courses/if969
 * @version 17-May-2011
 */
package if969.vcg.cin.ufpe.br.ed.arvore;


public class TestaCasoExtremo {

	public static void main(String[] args) {
		
		ArvoreAVL<Integer> avl     = new ArvoreAVL<Integer>();
		ArvoreBinaria<Integer> bin = new ArvoreBinaria<Integer>();
		
		int valorExtremo = 9000;
		
		long tempo, inicio, fim;
		
		// Sao inseridos os numeros de 0 ate 'valorExtremo'.
		// A Arvore Binaria fica com o formato de uma lista encadeada.
		for(int i = 0 ; i < valorExtremo ; i++) {
			avl.inserir(i);
			bin.inserir(i);
		}

		inicio = System.nanoTime();
		avl.busca(valorExtremo);
		fim = System.nanoTime();
		tempo = fim - inicio;
		System.out.println("Tempo de busca para a Arvore AVL: " + tempo + " nanosegundos");
		
		inicio = System.nanoTime();
		bin.busca(valorExtremo);
		fim = System.nanoTime();
		tempo = fim - inicio;
		System.out.println("Tempo de busca para a Arvore Binária: " + tempo + " nanosegundos");
	}
}
