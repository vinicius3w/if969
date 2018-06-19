/**
 * @author vcg@cin.ufpe.br
 * http://viniciusgarcia.com/courses/if969
 * @version 08-December-2011
 */
package if969.vcg.cin.ufpe.br.ed.arvore;

import if969.vcg.cin.ufpe.br.ed.lista.Fila;
import if969.vcg.cin.ufpe.br.ed.lista.Pilha;

/**
 * Classe que implementa o TAD Arvore AVL (balanceada)
 * @param <Elemento>
 */
public class ArvoreAVL<Elemento> implements Arvore<Elemento> {
	
	/**
	 * Nodo raiz da Arvore AVL
	 */
	private NodoAVL<Elemento> raiz;
	
	/**
	 * 
	 */
	private boolean h;
	
	/**
	 * Controle das posicoes e quantidades dos filhos
	 */
	@SuppressWarnings("unused")
	private int fatorFilhos;
	
	/* (non-Javadoc)
	 * @see if969.vcg.cin.ufpe.br.arvore.Arvore#inserir(java.lang.Object)
	 */
	public void inserir(Elemento x) {
		if(!existe(x)) {
			raiz = inserirInterno(x,raiz);
		}
	}
	
	/**
	 * @param e
	 * @param nodo
	 * @return
	 */
	private NodoAVL<Elemento> inserirInterno(Elemento e, NodoAVL<Elemento> nodo) {
		if(nodo == null) {
			nodo = new NodoAVL<Elemento>(e);
			h = true;
		}
		else {
			
			if(e.equals(nodo.getElemento())) {
				return nodo;
			}
			if( ((Comparable<Elemento>) e).compareTo(nodo.getElemento()) < 0) {
				nodo.esquerda = inserirInterno(e,(NodoAVL<Elemento>) nodo.esquerda);
				if(h == true) {
					switch(nodo.fator) {
						case 1:
							nodo.fator = 0;
							h = false;
							break;
						case 0:
							nodo.fator = -1;
							break;
						case -1:
							nodo = balanceamento1(nodo);
							break;
					}
				}
			}
			else {
				nodo.direita = inserirInterno(e,(NodoAVL<Elemento>) nodo.direita);
				if(h == true) {
					switch(nodo.fator) {
					case -1:
						nodo.fator = 0;
						h = false;
						break;
					case 0:
						nodo.fator = 1;
						break;
					case 1:
						nodo = balanceamento2(nodo);
						break;
					}
				}
			}
		}
		return nodo;
	}

	/**
	 * @param pt
	 * @return
	 */
	private NodoAVL<Elemento> balanceamento1(NodoAVL<Elemento> pt) {
		NodoAVL<Elemento> ptu = (NodoAVL<Elemento>) pt.esquerda;
		if(ptu.fator == -1) {
			pt.esquerda = ptu.direita;
			ptu.direita = pt;
			pt.fator = 0;
			pt = ptu;
		}
		else {
			NodoAVL<Elemento> ptv = (NodoAVL<Elemento>) ptu.direita;
			ptu.direita = ptv.esquerda;
			ptv.esquerda = ptu;
			pt.esquerda = ptv.direita;
			ptv.direita = pt;
			
			if(ptv.fator == -1) pt.fator = 1; else pt.fator = 0;
			if(ptv.fator == 1) ptu.fator = -1; else ptu.fator = 0;
			
			pt = ptv;
		}
		
		pt.fator = 0;
		h = false;
		
		return pt;
	}
	
	/**
	 * @param pt
	 * @return
	 */
	private NodoAVL<Elemento> balanceamento2(NodoAVL<Elemento> pt) {
		NodoAVL<Elemento> ptu = (NodoAVL<Elemento>) pt.direita;
		if(ptu.fator == 1) {
			pt.direita = ptu.esquerda;
			ptu.esquerda = pt;
			pt.fator = 0;
			pt = ptu;			
		}
		else {
			NodoAVL<Elemento> ptv = (NodoAVL<Elemento>) ptu.esquerda;
			ptu.esquerda = ptv.direita;
			ptv.direita = ptu;
			pt.direita = ptv.esquerda;
			ptv.esquerda = pt;
			
			if(ptv.fator == 1) pt.fator = -1; else pt.fator = 0;
			if(ptv.fator == -1) ptu.fator = 1; else ptu.fator = 0;
			
			pt = ptv;
			
		}
		
		pt.fator = 0;
		h = false;
		
		return pt;
		
	}
	
	/**
	 * @param e
	 * @return
	 */
	public NodoAVL<Elemento> busca(Elemento e) {
		if (buscaExterna(e) != null && buscaExterna(e).getElemento().equals(e)) {
			return buscaExterna(e);
		} else {
			return null;
		}
	}

	/**
	 * Metodo que imeplementa a busca externa por um elemento na Arvore AVL a partir 
	 * de seu Nodo raiz
	 * @param e
	 * @return NodoAVL
	 */
	private NodoAVL<Elemento> buscaExterna(Elemento e) {
		NodoAVL<Elemento> node = raiz;
		return buscaInterna(e, node);
	}

	/**
	 * Metodo que imeplementa a busca interna por um elemento em uma subarvore de uma 
	 * Arvore AVL a partir de seu Nodo raiz
	 * @param e
	 * @param nodo
	 * @return Nodo AVL
	 */
	private NodoAVL<Elemento> buscaInterna(Elemento e, NodoAVL<Elemento> nodo) {
		if (nodo == null) {
			fatorFilhos = 0;
		} else {
			if (e.equals(nodo.getElemento())) {
				fatorFilhos = 1;
			} else {
				if (((Comparable<Elemento>) e).compareTo(nodo.getElemento()) < 0) {
					if (nodo.esquerda == null) {
						fatorFilhos = 2;
					} else {
						nodo = (NodoAVL<Elemento>) nodo.esquerda;
						nodo = buscaInterna(e, nodo);
					}
				} else {
					if (nodo.direita == null) {
						fatorFilhos = 3;
					} else {
						nodo = (NodoAVL<Elemento>) nodo.direita;
						nodo = buscaInterna(e, nodo);
					}
				}
			}
		}
		return nodo;
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
	 * Metodo que implementa o caminhamento pos-ordem internamente
	 * @param nodo
	 */
	private void posOrdemInterna(NodoAVL<Elemento> nodo) {
		if (nodo.esquerda != null) {
			posOrdemInterna((NodoAVL<Elemento>) nodo.esquerda);
		}
		if (nodo.direita != null) {
			posOrdemInterna((NodoAVL<Elemento>) nodo.direita);
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
	 * Metodo que implementa o caminhamento ordem simetrica de forma interna
	 * @param nodo
	 */
	private void ordemSimetricaInterna(NodoAVL<Elemento> nodo) {
		if (nodo.esquerda != null) {
			ordemSimetricaInterna((NodoAVL<Elemento>) nodo.esquerda);
		}
		System.out.print(nodo.getElemento() + " ");
		if (nodo.direita != null) {
			ordemSimetricaInterna((NodoAVL<Elemento>) nodo.direita);
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
	 * Metodo que implementa o caminhamento pre-odem de forma intterna
	 * @param nodo
	 */
	private void preOrdemInterna(NodoAVL<Elemento> nodo) {
		System.out.print(nodo.getElemento() + " ");
		if (nodo.esquerda != null) {
			preOrdemInterna((NodoAVL<Elemento>) nodo.esquerda);
		}
		if (nodo.direita != null) {
			preOrdemInterna((NodoAVL<Elemento>) nodo.direita);
		}
	}
	
	/**
	 * Metodo para retornar a Arvore AVL como uma Fila
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
	 * @param nodo
	 * @param fila
	 * @return Fila
	 */
	private Fila<Elemento> retornaFilaInterno(NodoAVL<Elemento> nodo, Fila<Elemento> fila) {
		if (nodo.esquerda != null) {
			retornaFilaInterno((NodoAVL<Elemento>) nodo.esquerda, fila);
		}
		fila.enqueue(nodo.getElemento());
		if (nodo.direita != null) {
			retornaFilaInterno((NodoAVL<Elemento>) nodo.direita, fila);
		}
		return fila;
	}
	
	/**
	 * Metodo para retornar a Arvore AVL como uma Pilha
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
	 * @param nodo
	 * @param pilha
	 * @return Pilha
	 */
	private Pilha<Elemento> retornaFilaInterno(NodoAVL<Elemento> nodo, Pilha<Elemento> pilha) {
		if (nodo.esquerda != null) {
			retornaFilaInterno((NodoAVL<Elemento>) nodo.esquerda, pilha);
		}
		pilha.push(nodo.getElemento());
		if (nodo.direita != null) {
			retornaFilaInterno((NodoAVL<Elemento>) nodo.direita, pilha);
		}
		return pilha;
	}

	@Override
	public boolean existe(Elemento e) {
		if (buscaExterna(e) != null && buscaExterna(e).getElemento().equals(e)) {
			return true;
		} else {
			return false;
		}
	}

}