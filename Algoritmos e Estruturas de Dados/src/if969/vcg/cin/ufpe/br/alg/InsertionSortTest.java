/**
 * @author vcg@cin.ufpe.br
 * http://viniciusgarcia.com/courses/if969
 * @version 08-December-2011
 */
package if969.vcg.cin.ufpe.br.alg;

/**
 * Clase que implementa o InsertionSort
 * 
 */
public class InsertionSortTest {
	
	/** Insertion sort de um arranjo de caracteres em ordem crescente*/
	public static char[] insertionSort(char[] a) { 
		int n = a.length;
	    for (int i = 1; i < n; i++) {			// index from the second character in a
	    	char cur = a[i];					// the current character to be inserted
	    	int j = i - 1;						// start comparing with cell left of i
	    	while ((j >= 0) && (a[j] > cur))	// while a[j] is out of order with cur
	    		a[j + 1] = a[j--];				// move a[j] right and decrement j
	    	a[j + 1]=cur;						// this is the proper place for cur
	    }
	    return a;
	}
	
	public static char[] insertionSort2(char[] a) { 
		int n = a.length;
	    for (int i = 1; i < n; i++) {			// index from the second character in a
	    	char cur = a[i];					// the current character to be inserted
	    	int j = i - 1;						// start comparing with cell left of i
	    	//while ((j >= 0) && (a[j] > cur))	// while a[j] is out of order with cur
	    	for(j=i-1;(j >= 0) && (a[j] > cur);j--){
	    		a[j + 1] = a[j];				// move a[j] right and decrement j
	    	a[j]=cur;						// this is the proper place for cur
	    	}
	    }
	    return a;
	}
	
	public static void main(String[] args) {
		char arranjo[] = {'k','b','d','c','f','h','g','e','j','a'};
		//int[] arranjo = {'a','b','c','d','e','f','g','h','j','k'};
		//int[] arranjo = {'k','j','h','g','f','e','d','c','b','a'};
		System.out.println("Algoritmo de Ordenacao Insertionsort");
		System.out.println("-------------------------------");
		System.out.println("arranjo antes:");
		for(int i=0; i<=9; i++){
			System.out.print(arranjo[i] + " ");
		}
		System.out.println("");
		System.out.println("ordenando o arranjo...");
		arranjo = insertionSort(arranjo);
		System.out.println("arranjo ordenado");
		for(int i=0; i<=9; i++){
			System.out.print(arranjo[i] + " ");
		}

	}
	
}
