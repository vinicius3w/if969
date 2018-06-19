/**
 * @author vcg@cin.ufpe.br
 * http://viniciusgarcia.com/courses/if969
 * @version 07-December-2011
 */
package if969.vcg.cin.ufpe.br.ed.lista;

/**
 * Classe que implementa o TAD NodoDuplo para Listas Duplamente Encadeadas
 * @param <Elemento>
 */
public class NodoDuplo<Elemento> {

	/**
	 * Ponteiro para o proximo Nodo
	 */
	NodoDuplo<Elemento> proximo;
	
	/**
	 * Ponteiro para o Nodo anterior 
	 */
	NodoDuplo<Elemento> anterior;
	
	/**
	 * Elemento do NodoDuplo 
	 */
	Elemento elemento;
	
	/**
	 * Cria um NodoDuplo com referencia nula para seu elemento, nodod proximo e
	 * nodo anterior
	 */
	public NodoDuplo() {
		this(null, null, null);
	}
	
	/**
	 * Cria um NodoDuplo com seu elementp
	 * @param e
	 */
	public NodoDuplo(Elemento e) {
		this(e, null, null);
	}
	
	/**
	 * Cria um NodoDuplo com seu elemento e os nodos proximo e anterior
	 * @param e
	 * @param p
	 * @param a
	 */
	public NodoDuplo(Elemento e, NodoDuplo<Elemento> p, NodoDuplo<Elemento> a) {
		this.proximo = p;
		this.anterior = a;
		this.elemento = e;
	}

	/**
	 * @return o proximo nodo
	 */
	public NodoDuplo<Elemento> getProximo() {
		return proximo;
	}

	/**
	 * Modifica o novo proximo nodo
	 * @param p 
	 */
	public void setProximo(NodoDuplo<Elemento> p) {
		this.proximo = p;
	}

	/**
	 * @return o nodo anterior
	 */
	public NodoDuplo<Elemento> getAnterior() {
		return anterior;
	}

	/**
	 * Modifica o nodo anterior
	 * @param a
	 */
	public void setAnterior(NodoDuplo<Elemento> a) {
		this.anterior = a;
	}

	/**
	 * @return o elemento do nodo
	 */
	public Elemento getElemento() {
		return elemento;
	}

	/**
	 * Modifica o elemento do nodo
	 * @param e
	 */
	public void setElemento(Elemento e) {
		this.elemento = e;
	}
}
