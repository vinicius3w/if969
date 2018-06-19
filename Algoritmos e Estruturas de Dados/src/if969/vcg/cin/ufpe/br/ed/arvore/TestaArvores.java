/**
 * @author vcg@cin.ufpe.br
 * http://viniciusgarcia.com/courses/if969
 * @version 08-december-2011
 */
package if969.vcg.cin.ufpe.br.ed.arvore;

import if969.vcg.cin.ufpe.br.ed.lista.Fila;
import if969.vcg.cin.ufpe.br.ed.lista.Pilha;

public class TestaArvores {

	public static void main(String[] args) {
		
		ArvoreBinaria<Integer> bin = new ArvoreBinaria<Integer>();
		ArvoreAVL<Integer> avl = new ArvoreAVL<Integer>();
		
		System.out.println("Arvore Binaria:");
		System.out.println("Inserindo os numeros 15, 30, 20, 42, 12, 1, 98 e 63");
		bin.inserir(15);
		bin.inserir(30);
		bin.inserir(20);
		bin.inserir(42);
		bin.inserir(12);
		bin.inserir(1);
		bin.inserir(98);
		bin.inserir(63);
		
		System.out.println("Ordem Simetrica:");
		bin.ordemSimetrica();
		System.out.println("Pre-Ordem:");
		bin.preOrdem();
		System.out.println("Pos-Ordem:");
		bin.posOrdem();
		System.out.print("Altura do nodo 15: ");
		System.out.println(bin.altura(15));
		System.out.print("Altura do nodo 1: ");
		System.out.println(bin.altura(1));
		System.out.print("Altura do nodo 20: ");
		System.out.println(bin.altura(20));
		System.out.print("Altura do nodo 42: ");
		System.out.println(bin.altura(42));
		System.out.print("Altura do nodo 69: ");
		System.out.println(bin.altura(69));
		
		System.out.println("Existe o 63? " + bin.busca(63));
		System.out.println("Existe o 12? " + bin.busca(12));
		
		System.out.println("Imprimindo Fila:");
		Fila<Integer> fila = bin.retornaFila();
		Integer n = fila.dequeue();
		while(n != null) {
			System.out.print(n + " ");
			n = fila.dequeue();
		}
		System.out.println();
		
		System.out.println("Imprimindo Pilha:");
		Pilha<Integer> pilha = bin.retornaPilha();
		n = pilha.pop();
		while(n != null) {
			System.out.print(n + " ");
			n = pilha.pop();
		}
		System.out.println("\n--------------------------");
		System.out.println("Arvore AVL:");
		System.out.println("Inserindo os numeros 15, 30, 20, 42, 12, 1, 98 e 63");
		avl.inserir(15);
		avl.inserir(30);
		avl.inserir(20);
		avl.inserir(42);
		avl.inserir(12);
		avl.inserir(1);
		avl.inserir(98);
		avl.inserir(63);
		
		System.out.println("Ordem Simetrica:");
		avl.ordemSimetrica();
		System.out.println("Pre-Ordem:");
		avl.preOrdem();
		System.out.println("Pos-Ordem:");
		avl.posOrdem();
		
		System.out.println("Existe o 63? " + avl.busca(63));
		System.out.println("Existe o 12? " + avl.busca(12));
		
		System.out.println("Imprimindo Fila:");
		fila = avl.retornaFila();
		n = fila.dequeue();
		while(n != null) {
			System.out.print(n + " ");
			n = fila.dequeue();
		}
		System.out.println();
		
		System.out.println("Imprimindo Pilha:");
		pilha = avl.retornaPilha();
		n = pilha.pop();
		while(n != null) {
			System.out.print(n + " ");
			n = pilha.pop();
		}
		System.out.print("\n--------------------------");
	}
}
