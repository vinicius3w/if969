/**
 * @author vcg@cin.ufpe.br
 * http://viniciusgarcia.com/courses/if969
 * @version 07-December-2011
 */
package if969.vcg.cin.ufpe.br.ed.lista;

/**
 * Classe que implementa o TAD Lista Duplamente Encadeada Ordenada
 * @param <Elemento>
 */
public class ListaDupEncOrdenada<Elemento> implements Lista<Elemento> {
	
	/**
	 * NodoDuplo da Lista Duplamente Encadeada
	 */
	private NodoDuplo<Elemento> cabeca;

	/**
	 * Cria uma Lista Encadeada com referencia nula para a cabeca
	 */
	public ListaDupEncOrdenada() {
		this(null);
	}
	
	/**
	 * Cria uma Lista Encadeada com seu elemento cabeca
	 */
	public ListaDupEncOrdenada(NodoDuplo<Elemento> c) {
		cabeca = c;
	}

	/* (non-Javadoc)
	 * @see if969.vcg.cin.ufpe.br.ed.Lista#inserir(java.lang.Object)
	 */
	@Override
	public void inserir(Elemento e) {
		NodoDuplo<Elemento> node = new NodoDuplo<Elemento>(e);
		if (cabeca == null) {
			cabeca = new NodoDuplo<Elemento>(null);
			cabeca.setProximo(node);
			cabeca.setAnterior(node);
			cabeca.getProximo().setAnterior(cabeca);
			cabeca.getProximo().setProximo(cabeca);
			return;
		}
		else {
			if (((Comparable<Elemento>) e).compareTo(cabeca.getAnterior().getElemento()) >= 0) {
				NodoDuplo<Elemento> anterior = cabeca.getAnterior();
				NodoDuplo<Elemento> proximo = cabeca;
				anterior.setProximo(node);
				proximo.setAnterior(node);
				node.setAnterior(anterior);
				node.setProximo(proximo);
				return;
			}
			else {
				NodoDuplo<Elemento> aux = cabeca.getProximo();
				while (aux != cabeca) {
					if (((Comparable<Elemento>) e).compareTo(aux.getElemento()) < 0) {
						NodoDuplo<Elemento> anterior = aux.getAnterior();
						NodoDuplo<Elemento> proximo = aux;
						anterior.setProximo(node);
						proximo.setAnterior(node);
						node.setAnterior(anterior);
						node.setProximo(proximo);
						return;
					}
					aux = aux.getProximo();
				}
			}
		}
	}

	/* (non-Javadoc)
	 * @see if969.vcg.cin.ufpe.br.ed.Lista#imprimir()
	 */
	@Override
	public void imprimir() {
		if (cabeca == null) {
			return;
		}
		NodoDuplo<Elemento> no = cabeca.getProximo();
		while (no != cabeca) {
			System.out.print(no.getElemento());
			no = no.getProximo();
			if(no!=cabeca) System.out.print(" -> ");
		}
	}

	/* (non-Javadoc)
	 * @see if969.vcg.cin.ufpe.br.ed.Lista#remover(java.lang.Object)
	 */
	@Override
	public void remover(Elemento e) {
		if(cabeca == null) {
			return;
		}
		if(cabeca.getProximo().getProximo() == cabeca && 
				cabeca.getProximo().getElemento() == e) {
			cabeca = null;
			return;
		}
		NodoDuplo<Elemento> naux = buscar(e);
		if(naux != null){
			NodoDuplo<Elemento> anterior = naux.getAnterior();
			NodoDuplo<Elemento> proximo = naux.getProximo();
			anterior.setProximo(proximo);
			proximo.setAnterior(anterior);
			naux.setProximo(null);
			naux.setAnterior(null);
			return;
		}
	}

	/**
	 * Metodo para buscar um elemento na Lista.  
	 * @param e
	 * @return NodoDuplo<Elemento> Retorna o nodo se existir e null se nao.
	 */
	public NodoDuplo<Elemento> buscar(Elemento e) {
		if(cabeca == null) {
			return null;
		}
		if( ((Comparable<Elemento>) e).compareTo(cabeca.getAnterior().getElemento()) > 0 ) {
			return null;
		}
		else if(e.equals(cabeca.getAnterior().getElemento()) ) {
			return cabeca.getAnterior();
		}
		else {
			NodoDuplo<Elemento> no = cabeca.getProximo();
			while(no != cabeca) {
				if(e.equals(no.getElemento())) {
					return no;
				}
				no = no.getProximo();
			}
		}
		return null;
	}

	/* (non-Javadoc)
	 * @see if969.vcg.cin.ufpe.br.ed.Lista#ehVazia()
	 */
	@Override
	public boolean ehVazia() {
		return (cabeca == null);
	}

	/* (non-Javadoc)
	 * @see if969.vcg.cin.ufpe.br.ed.Lista#tamanho()
	 */
	@Override
	public int tamanho() {
		int i=0;
		NodoDuplo<Elemento> n = cabeca;
		while(n!=null){
			i++;
			n = n.getProximo();
		}
		return i;
	}

	/* (non-Javadoc)
	 * @see if969.vcg.cin.ufpe.br.ed.Lista#get(int)
	 */
	@Override
	public Elemento get(int i) {
		int cont=0;
		NodoDuplo<Elemento> n = cabeca;
		while(n!=null && cont<i){
			cont++;
			n = n.getProximo();
			if(n==null) return null;
		}
		return n.getElemento();
	}

	/* (non-Javadoc)
	 * @see if969.vcg.cin.ufpe.br.ed.Lista#set(int, java.lang.Object)
	 */
	@Override
	public Elemento set(int i, Elemento e) {
		Elemento oldE = this.get(i);
		if(oldE!=null){
			NodoDuplo<Elemento> n = cabeca;
			while(n!=null){
				i--;
				n = n.getProximo();
				if(i==0) 
					n.setElemento(oldE);
			}
		}
		return oldE;
	}

	/* (non-Javadoc)
	 * @see if969.vcg.cin.ufpe.br.ed.Lista#existe(java.lang.Object)
	 */
	@Override
	public boolean existe(Elemento e) {
		if(cabeca == null) {
			return false;
		}
		if( ((Comparable<Elemento>) e).compareTo(cabeca.getAnterior().getElemento()) > 0 ) {
			return false;
		}
		else if(e.equals(cabeca.getAnterior().getElemento()) ) {
			return true;
		}
		else {
			NodoDuplo<Elemento> no = cabeca.getProximo();
			while(no != cabeca) {
				if(e.equals(no.getElemento())) {
					return true;
				}
				no = no.getProximo();
			}
		}
		return false;
	}
	
	/**
	 * Metodo que retorna Lista Encadeada Ordenada como uma Pilha
	 * @return Pilha
	 */
	public Pilha<Elemento> retornaPilha() {
		Pilha<Elemento> p = new Pilha<Elemento>();
		if(cabeca == null) {
			return p;
		}
		NodoDuplo<Elemento> aux = cabeca.getProximo();
		while (aux != cabeca) {
			p.push(aux.getElemento());
			aux = aux.getProximo();
		}
		return p;
	}
	
	/**
	 * Metodo que retorna Lista Encadeada Ordenada como uma Fila
	 * @return
	 */
	public Fila<Elemento> retornaFila() {
		Fila<Elemento> fila = new Fila<Elemento>();
		if(cabeca == null) {
			return fila;
		}
		NodoDuplo<Elemento> aux = cabeca.getProximo();
		while (aux != cabeca) {
			fila.enqueue(aux.getElemento());
			aux = aux.getProximo();
		}
		return fila;
	}
	
	/**
	 * Retorna o elemento com valor minimo
	 * @return Elemento
	 */
	public Elemento retornaMinimo() {
		return cabeca.getProximo().getElemento();
	}
	
	/**
	 * Retorna o elemento com valor maximo
	 * @return Elemento
	 */
	public Elemento retornaMaximo() {
		return cabeca.getAnterior().getElemento();
	}
	
}
