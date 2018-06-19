/**
 * @author vcg@cin.ufpe.br
 * http://viniciusgarcia.com/courses/if969
 * @version 08-December-2011
 */
package if969.vcg.cin.ufpe.br.ed.arvore;

public class ComparaArvores {

	public static void main(String[] args) throws InterruptedException {
		
		long quantidade  = 10;
		long random = 3000000;
		
		ArvoreBinaria<Integer> binaria = new ArvoreBinaria<Integer>();
		ArvoreAVL<Integer> avl = new ArvoreAVL<Integer>();
		long x,y;
		double tempoAVL,tempoBIN;
		
		while(true) {
			//-------------------------------------------
			x = System.nanoTime();
			for(int i = 0 ; i < quantidade ; i++) {
				binaria.inserir((int)(Math.random()*random));
			}
			y = System.nanoTime();
			tempoBIN = (y-x) / Math.pow(10, 9);
			//-------------------------------------------
			
			//-------------------------------------------
			x = System.nanoTime();
			for(int i = 0 ; i < quantidade ; i++) {
				avl.inserir((int)(Math.random()*random));
			}
			y = System.nanoTime();
			tempoAVL = (y-x) / Math.pow(10, 9);
			//-------------------------------------------
			
			
			System.out.println("--------------------");
			System.out.println("Quantidade: " + quantidade);
			System.out.println("Tempo BIN:  " + tempoBIN);
			System.out.println("Tempo AVL:  " + tempoAVL);
			System.out.println("--------------------");
			quantidade *=2;
			binaria = new ArvoreBinaria<Integer>();
			avl = new ArvoreAVL<Integer>();
		}
	}
}
