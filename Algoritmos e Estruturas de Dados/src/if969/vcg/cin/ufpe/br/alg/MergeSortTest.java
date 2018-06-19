/**
 * @author vcg@cin.ufpe.br
 * http://viniciusgarcia.com/courses/if969
 * @version 08-December-2011
 */
package if969.vcg.cin.ufpe.br.alg;

/**
 * Clase que implementa o MergeSort
 * 
 */
public class MergeSortTest {
	
	private static int[] mergesort(int[] a, int inicio, int fim) {
		if (inicio < fim) {
	        int meio = (inicio + fim) / 2;
	        a = mergesort(a, inicio, meio);
	        a = mergesort(a, meio + 1, fim);
	        a = mesclar(a, inicio, meio, fim);
        }
		return a;
	}
 
	/* 
	 * Ordena dois trechos ordenados e adjacente de vetores e ordena-os
	 * conjuntamente
	 */
	private static int[] mesclar(int[] a, int inicio, int meio, int fim) {
        int tamanho = fim - inicio + 1;
 
        /*
         * Inicializa‹o de um vetor temporario para auxiliar na ordena‹o O
         * vetor tempor‡rio Ž uma c—pia do trecho que ser‡ ordenado
         */
        int[] temp = new int[tamanho];
        System.arraycopy(a, inicio, temp, 0, tamanho);
 
        /*
         * Lao para ordena‹o do vetor, utilizando o vetor tempor‡rio, usando
         * ’ndices i e j para cada trecho de vetor da mesclagem
         */
        int i = 0;
        int j = meio - inicio + 1;
 
        //A depender das condi›es, recebe um elemento de um trecho ou outro
        for (int posicao = 0; posicao < tamanho; posicao++) {
        	if (j <= tamanho - 1) {
        		if (i <= meio - inicio) {
        			if (temp[i] < temp[j]) {
        				a[inicio + posicao] = temp[i++];
                    } else {
                    	a[inicio + posicao] = temp[j++];
                    }
                } else {
                	a[inicio + posicao] = temp[j++];
                }
            } else {
            	a[inicio + posicao] = temp[i++];
            }
        }
        return a;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] arranjo = {3,5,7,2,8,10,99,65,3,1};
		//int[] arranjo = {1,2,3,4,5,6,7,8,9,10};
		//int[] arranjo = {10,9,8,7,6,5,4,3,2,1};
		System.out.println("Algoritmo de Ordenacao Mergesort");
		System.out.println("-------------------------------");
		System.out.print("arranjo antes: ");
		for(int i=0; i<=9; i++){
			System.out.print(arranjo[i] + " ");
		}
		System.out.println("\nordenando o arranjo...");
		arranjo = mergesort(arranjo, 0, arranjo.length-1);
		System.out.print("arranjo ordenado: ");
		for(int i=0; i<=9; i++){
			System.out.print(arranjo[i] + " ");
		}

	}

}
