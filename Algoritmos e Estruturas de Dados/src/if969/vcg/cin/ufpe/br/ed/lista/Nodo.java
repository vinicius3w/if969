/**
 * @author vcg@cin.ufpe.br
 * http://viniciusgarcia.com/courses/if969
 * @version 07-December-2011
 */
package if969.vcg.cin.ufpe.br.ed.lista;

/**
 * Classe que implementa o TAD Nodo
 * @param <Elemento>
 */
public class Nodo<Elemento> {

	/**
	 * Ponteiro para o proximo nodo
	 */
	private Nodo<Elemento> proximo;
	
	/**
	 * Elemento do Nodo 
	 */
	private Elemento elemento;

	/**
	 * Cria um nodo com seu elemento e proximo nodo
	 * @param e
	 * @param p
	 */
	public Nodo(Elemento e, Nodo<Elemento> p) {
		this.proximo = p;
		this.elemento = e;
	}
	
	/**
	 * Cria um nodo com seu elemento
	 * @param e
	 */
	public Nodo(Elemento e) {
		this(e, null);
	}
	
	/**
	 * Cria um nodo com referencias nulas para seu elemento e o proximo nodo.
	 */
	public Nodo() {
		this(null, null);
	}
	
	/**
	 * Metodo de acesso ao proximo nodo
	 * @return o proximo nodo
	 */
	public Nodo<Elemento> getProximo() {
		return proximo;
	}

	/**
	 * Metodo modificador do proximo nodo
	 * @param proximo o novo proximo nodo
	 */
	public void setProximo(Nodo<Elemento> newNext) {
		this.proximo = newNext;
	}

	/**
	 * Metodo de acesso ao elemento do nodo
	 * @return o elemento
	 */
	public Elemento getElemento() {
		return elemento;
	}

	/**
	 * Metodo modificador do elemento do nodo
	 * @param e o novo elemento
	 */
	public void setElemento(Elemento e) {
		this.elemento = e;
	}
	
}
