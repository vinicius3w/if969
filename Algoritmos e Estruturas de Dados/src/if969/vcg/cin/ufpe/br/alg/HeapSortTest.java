/**
 * @author vcg@cin.ufpe.br
 * http://viniciusgarcia.com/courses/if969
 * @version 08-December-2011
 */
package if969.vcg.cin.ufpe.br.alg;

/**
 * Clase que implementa o HeapSort
 * 
 */
public class HeapSortTest {
    
    /** Funcao que garante a manutencao do heap maximo */
    private static void maxHeapify(int[] a, int pos, int n) { 
    	int maxi; 
    	int l = 2 * pos + 1;
    	int right = 2 * pos + 2;
    	if ( (l < n) && (a[l] > a[pos]) ) {
    		maxi = l;
    	} else {
    		maxi = pos;
    	}
    	if (right < n && a[right] > a[maxi]) { 
    		maxi = right;
    	}
    	if (maxi != pos) {
    		swap(a, pos, maxi);
    		maxHeapify(a, maxi, n);
    	}
    }
	
	/** Funcao que constroi um heap maximo */
    private static void buildMaxHeap(int[] a){ 
    	// build a heap a from an unsorted array
    	for (int i = a.length/2 - 1; i >= 0; i--)
    		maxHeapify(a, i , a. length );
    }
    
    /** Algoritmo de ordenamento HeapSort */
	public static int[] heapSort(int[] a) {  
		// use a heap to build sorted array from the end 
		buildMaxHeap(a);
		int n = a.length;
		for (int i = a.length - 1; i > 0; i--) { 
			// largest element is a root of heap, put it at the end of array
			swap(a, i , 0);
			// shrink heap size by 1 to get next largest element 
			maxHeapify(a, 0, --n);
		}
		return a;
	}
	
    public static void swap ( int[] a, int j, int aposJ ) {
    	int aux = a[j];
    	a[j] = a[aposJ];
    	a[aposJ] = aux;
    }
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] arranjo = {5,3,2,7,1,9,8,20,22,34};
		//int[] arranjo = {1,2,3,4,5,6,7,8,9,10};
		//int[] arranjo = {10,9,8,7,6,5,4,3,2,1};
		System.out.println("Algoritmo de Ordenacao Heapsort");
		System.out.println("-------------------------------");
		System.out.print("arranjo antes: ");
		for(int i=0; i<=9; i++){
			System.out.print(arranjo[i] + " ");
		}
		System.out.println("\nordenando o arranjo...");
		arranjo = heapSort(arranjo);
		System.out.print("arranjo ordenado: ");
		for(int i=0; i<=9; i++){
			System.out.print(arranjo[i] + " ");
		}

	}

}
