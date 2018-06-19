/**
 * @author vcg@cin.ufpe.br
 * http://viniciusgarcia.com/courses/if969
 * @version 08-December-2011
 */
package if969.vcg.cin.ufpe.br.ed.arvore;

import if969.vcg.cin.ufpe.br.ed.lista.Fila;
import if969.vcg.cin.ufpe.br.ed.lista.Pilha;

/**
 * Classe que implementa o TAD Arvore Binaria
 * @param <Elemento>
 */
public class ArvoreBinaria<Elemento> implements Arvore<Elemento> {

	/**
	 * Nodo raiz da Arvore Binaria
	 */
	private NodoArvoreBinaria<Elemento> raiz;

	/**
	 * Controle das posicoes do filho 
	 */
	private byte posicaoFilho = 0;
	
	public void setRaiz(NodoArvoreBinaria<Elemento> raiz) {
		this.raiz = raiz;
	}

	public NodoArvoreBinaria<Elemento> getRaiz(){
		return this.raiz;
	}
	
	public NodoArvoreBinaria<Elemento> pai(NodoArvoreBinaria<Elemento> _nodo){
		if (_nodo == raiz) return null;
		else return _nodo.pai;
	}

	public int numFilhos(NodoArvoreBinaria<Elemento> _nodo){
		int f=0;
		if( _nodo.esquerda != null) f++;
		if( _nodo.direita != null) f++;
		return f;
	}

	public boolean ehInterno(NodoArvoreBinaria<Elemento> _nodo){
		if (_nodo.direita != null || _nodo.esquerda != null)
			return true;
		else return false;
	}

	public boolean ehExterno(NodoArvoreBinaria<Elemento> _nodo){
		if (_nodo.direita == null && _nodo.esquerda == null)
			return true;
		else return false;
	}

	public boolean ehRaiz(NodoArvoreBinaria<Elemento> _nodo){
		if (raiz == _nodo) return true;
		else return false;
	}
	
	public NodoArvoreBinaria<Elemento> filhoEsquerdo(NodoArvoreBinaria<Elemento> _nodo){
		if (ehExterno(_nodo)){ return null;}
		else return _nodo.esquerda;
	}

	public NodoArvoreBinaria<Elemento> filhoDireito(NodoArvoreBinaria<Elemento> _nodo){
		if (ehExterno(_nodo)){ return null;}
		else return _nodo.direita;
	}
	
	/* (non-Javadoc)
	 * @see if969.vcg.cin.ufpe.br.arvore.Arvore#posOrdem()
	 */
	public void posOrdem() {
		if (raiz != null) {
			posOrdemInterna(raiz);
			System.out.println();
		}
	}

	/**
	 * Metodo que implementa o caminhamento pos-ordem a partir de um Nodo raiz de uma Arvore
	 * @param nodo
	 */
	private void posOrdemInterna(NodoArvoreBinaria<Elemento> nodo) {
		if (nodo.esquerda != null) {
			posOrdemInterna(nodo.esquerda);
		}
		if (nodo.direita != null) {
			posOrdemInterna(nodo.direita);
		}
		System.out.print(nodo.getElemento() + " ");
	}

	/* (non-Javadoc)
	 * @see if969.vcg.cin.ufpe.br.arvore.Arvore#ordemSimetrica()
	 */
	public void ordemSimetrica() {
		if (raiz != null) {
			ordemSimetricaInterna(raiz);
			System.out.println();
		}
	}

	/**
	 * Metodo que implementa  caminhamento ordem simetrica a partir de um Nodo raiz de 
	 * uma Arvore
	 * @param nodo
	 */
	private void ordemSimetricaInterna(NodoArvoreBinaria<Elemento> nodo) {
		if (nodo.esquerda != null) {
			ordemSimetricaInterna(nodo.esquerda);
		}
		System.out.print(nodo.getElemento() + " ");
		if (nodo.direita != null) {
			ordemSimetricaInterna(nodo.direita);
		}
	}

	/* (non-Javadoc)
	 * @see if969.vcg.cin.ufpe.br.arvore.Arvore#preOrdem()
	 */
	public void preOrdem() {
		if (raiz != null) {
			preOrdemInterna(raiz);
			System.out.println();
		}
	}

	/**
	 * Metodo que implementa o caminhamento pre-ordem a partir de um Nodo raiz de
	 * uma Arvore
	 * @param nodo
	 */
	private void preOrdemInterna(NodoArvoreBinaria<Elemento> nodo) {
		System.out.print(nodo.getElemento() + " ");
		if (nodo.esquerda != null) {
			preOrdemInterna(nodo.esquerda);
		}
		if (nodo.direita != null) {
			preOrdemInterna(nodo.direita);
		}
	}

	/* (non-Javadoc)
	 * @see if969.vcg.cin.ufpe.br.arvore.Arvore#busca(java.lang.Object)
	 */
	public NodoArvoreBinaria<Elemento> busca(Elemento e) {
		if (buscaExterna(e) != null && buscaExterna(e).getElemento().equals(e)) {
			return buscaExterna(e);
		} else {
			return null;
		}
	}

	/**
	 * Metodo que implementa a busca externa de um elemento na Arvore Binaria a partir do
	 * Nodo raiz
	 * @param e
	 * @return NodoArvoreBinaria
	 */
	public NodoArvoreBinaria<Elemento> buscaExterna(Elemento e) {
		NodoArvoreBinaria<Elemento> node = raiz;
		return buscaInterna(e, node);
	}

	/**
	 * Metodo que implementa a busca interna de um elemento na Arvore Binaria a partir 
	 * de um Nodo
	 * @param e
	 * @param nodo
	 * @return NodoArvoreBinaria<Elemento>
	 */
	private NodoArvoreBinaria<Elemento> buscaInterna(Elemento e, NodoArvoreBinaria<Elemento> nodo) {
		if (nodo == null) {
			posicaoFilho = 0;
		} else {
			if (e.equals(nodo.getElemento())) {
				posicaoFilho = 1;
			} else {
				if (((Comparable<Elemento>) e).compareTo(nodo.getElemento()) < 0) {
					if (nodo.esquerda == null) {
						posicaoFilho = 2;
					} else {
						nodo = nodo.esquerda;
						nodo = buscaInterna(e, nodo);
					}
				} else {
					if (nodo.direita == null) {
						posicaoFilho = 3;
					} else {
						nodo = nodo.direita;
						nodo = buscaInterna(e, nodo);
					}
				}
			}
		}
		return nodo;
	}

	/* (non-Javadoc)
	 * @see if969.vcg.cin.ufpe.br.arvore.Arvore#inserir(java.lang.Object)
	 */
	public void inserir(Elemento e) {
		NodoArvoreBinaria<Elemento> node = buscaExterna(e);
		if (posicaoFilho == 1) {
			return;
		} else {
			NodoArvoreBinaria<Elemento> no = new NodoArvoreBinaria<Elemento>(e);
			if (posicaoFilho == 0) {
				raiz = no;
			} else {
				if (posicaoFilho == 2) {
					node.esquerda = no;
				} else {
					node.direita = no;
				}
			}
		}
	}
	
	/**
	 * Metodo para retornar a Arvore Binaria como uma Fila
	 * @return Fila
	 */
	public Fila<Elemento> retornaFila() {
		Fila<Elemento> fila = new Fila<Elemento>();
		if (raiz != null) {
			return retornaFilaInterno(raiz, fila);
		}
		return fila;
	}

	/**
	 * Metodo para retornar uma subarvore de uma Arvore Binaria como uma Fila
	 * a partir do seu Nodo raiz
	 * @param nodo
	 * @param fila
	 * @return Fila<Elemento>
	 */
	private Fila<Elemento> retornaFilaInterno(NodoArvoreBinaria<Elemento> nodo, Fila<Elemento> fila) {
		if (nodo.esquerda != null) {
			retornaFilaInterno(nodo.esquerda, fila);
		}
		fila.enqueue(nodo.getElemento());
		if (nodo.direita != null) {
			retornaFilaInterno(nodo.direita, fila);
		}
		return fila;
	}
	
	/**
	 * Metodo para retornar a Arvore Binaria como uma Pilha
	 * @return Pilha
	 */
	public Pilha<Elemento> retornaPilha() {
		Pilha<Elemento> pilha = new Pilha<Elemento>();
		if (raiz != null) {
			return retornaFilaInterno(raiz, pilha);
		}
		return pilha;
	}

	/**
	 * Metodo para retornar uma subarvore de uma Arvore Binaria como uma Pilha
	 * a partir do seu Nodo raiz
	 * @param nodo
	 * @param pilha
	 * @return Pilha<Elemento>
	 */
	private Pilha<Elemento> retornaFilaInterno(NodoArvoreBinaria<Elemento> nodo, Pilha<Elemento> pilha) {
		if (nodo.esquerda != null) {
			retornaFilaInterno(nodo.esquerda, pilha);
		}
		pilha.push(nodo.getElemento());
		if (nodo.direita != null) {
			retornaFilaInterno(nodo.direita, pilha);
		}
		return pilha;
	}

	/**
	 * @param a
	 * @param b
	 * @return
	 */
	private int maximo(int a, int b){
		if (a>b)
			return a;
		else
			return b;
	}
	
	/**
	 * Metodo para calcular a altura de um nodo a partir de seu elemento
	 * @param e Elemento do nodo
	 * @return Altura do nodo
	 */
	public int altura(Elemento e){
		//NodoArvoreBinaria<Dado> nodo = raiz;
		if(raiz == null) {return -1;}
		else {
			if(existe(e)){
				return alturaInterna(buscaExterna(e));
			} else {
				return 0;
			}
		}
	}
	
	/**
	 * Metodo para calcular a altura interna de um nodo da arvore
	 * @param nodo
	 * @return int Altura do nodo
	 */
	private int alturaInterna(NodoArvoreBinaria<Elemento> nodo) {
		int alt = 0; //o nodo tem altura 1
		//NodoArvoreBinaria<Dado> nodoRaiz = raiz;
		if (nodo == null){return 0;}
		else{
			alt = 1 + maximo(alturaInterna(nodo.esquerda), alturaInterna(nodo.direita));			
		}
		return alt;
	}

	/* (non-Javadoc)
	 * @see if969.vcg.cin.ufpe.br.ed.arvore.Arvore#existe(java.lang.Object)
	 */
	@Override
	public boolean existe(Elemento e) {
		if (buscaExterna(e) != null && buscaExterna(e).getElemento().equals(e)) {
			return true;
		} else {
			return false;
		}
	}
}
