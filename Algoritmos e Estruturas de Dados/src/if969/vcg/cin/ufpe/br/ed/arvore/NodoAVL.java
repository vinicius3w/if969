/**
 * @author vcg@cin.ufpe.br
 * http://viniciusgarcia.com/courses/if969
 * @version 08-December-2011
 */
package if969.vcg.cin.ufpe.br.ed.arvore;

/**
 * Classe que implementa o TAD Nodo para Arvores AVL (balanceadas)
 * @param <Elemento>
 */
public class NodoAVL<Elemento> extends NodoArvoreBinaria<Elemento> {
	
	/**
	 * Fator de balanceamento (controle)
	 */
	int fator;
	
	/**
	 * Cria um Nodo para Arvores AVL
	 * @param e
	 */
	public NodoAVL(Elemento e) {
		super(e);
		this.fator = 0;		
	}
}
