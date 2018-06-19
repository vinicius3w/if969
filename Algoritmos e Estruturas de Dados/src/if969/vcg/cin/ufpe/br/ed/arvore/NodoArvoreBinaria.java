/**
 * @author vcg@cin.ufpe.br
 * http://viniciusgarcia.com/courses/if969
 * @version 08-December-2011
 */
package if969.vcg.cin.ufpe.br.ed.arvore;

/**
 * Classe que implementa o TAD Nodo para Arvore Binaria
 * @param <Elemento>
 */
public class NodoArvoreBinaria<Elemento> {

	/**
	 * Nodo filho a esquerda 
	 */
	NodoArvoreBinaria<Elemento> esquerda;
	
	/**
	 * Nodo filho a direita
	 */
	NodoArvoreBinaria<Elemento> direita;
	
	/**
	 * Nodo que aponta para o pai do nodo
	 */
	NodoArvoreBinaria<Elemento> pai;
	
	/**
	 * Elemento do Nodo 
	 */
	Elemento elemento;
	
	public boolean hasDireita(){
		return (this.direita!=null);
	}
	
	public boolean hasEsquerda(){
		return (this.esquerda!=null);
	}
	
	public boolean hasPai(){
		return (this.pai!=null);
	}
	
	/**
	 * @return filho da esquerda
	 */
	public NodoArvoreBinaria<Elemento> getEsquerda() {
		return esquerda;
	}

	/**
	 * @return filho da direita
	 */
	public NodoArvoreBinaria<Elemento> getDireita() {
		return direita;
	}

	/**
	 * @return o pai
	 */
	public NodoArvoreBinaria<Elemento> getPai() {
		return pai;
	}

	public Elemento getElemento() {
		return elemento;
	}

	/**
	 * Cria um Nodo Arvore Binaria
	 * @param chave
	 */
	public NodoArvoreBinaria(Elemento e) {
		this.esquerda = null;
		this.direita = null;
		this.pai = null;
		this.elemento = e;
	}
	
	/**
	 * Cria um Nodo Arvore Binaria com entrada do elemento e dos nodos direita e esquerda
	 * @param e
	 * @param nodoEsq
	 * @param nodoDir
	 */
	public NodoArvoreBinaria(Elemento e, NodoArvoreBinaria<Elemento> nodoEsq, 
			NodoArvoreBinaria<Elemento> nodoDir){
		this.elemento = e;
		this.esquerda = nodoEsq;
		this.direita = nodoDir;
		this.pai = null;
		this.direita.pai = this;
		this.esquerda.pai =this;
	}
	
	/**
	 * Metodo que retorna o elemento nodo
	 * @return Nodo
	 */
	public NodoArvoreBinaria<Elemento> elemento(){
		return this;	
	}
}
