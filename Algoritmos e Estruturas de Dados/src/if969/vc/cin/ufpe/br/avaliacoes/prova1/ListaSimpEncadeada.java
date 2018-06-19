/**
 * @author vcg@cin.ufpe.br
 * http://viniciusgarcia.com/courses/if969
 * @version 07-December-2011
 */
package if969.vc.cin.ufpe.br.avaliacoes.prova1;

/**
 * Classe que implementa o TAD Lista Encadeada
 * @param <Elemento>
 */
public class ListaSimpEncadeada<Elemento> implements Lista<Elemento> {
	
	/**
	 * Nodo sentinela para a cabeca da Lista Encadeada
	 */
	private Nodo<Elemento> cabeca;
	
	/**
	 * Nodo sentinela para a cauda da Lista Encadeada 
	 */
	private Nodo<Elemento> cauda;

	/**
	 * Cria uma Lista Encadeada com referencias nulas para
	 * seus elementos cabeca e cauda.
	 */
	public ListaSimpEncadeada() {
		this(null, null);
	}
	
	/**
	 * Cria uma Lista Encadeada com seus elementos cabeca e cauda
	 * @param cabeca
	 * @param cauda
	 */
	public ListaSimpEncadeada(Nodo<Elemento> cabeca, Nodo<Elemento> cauda) {
		this.cabeca = cabeca;
		this.cauda = cauda;
	}

	/* (non-Javadoc)
	 * @see if969.vcg.cin.ufpe.br.ed.Lista#inserir(java.lang.Object)
	 */
	@Override
	public void inserir(Elemento e) {
		Nodo<Elemento> newNodo = new Nodo<Elemento>(e);
		if(cabeca == null) {
			cabeca = new Nodo<Elemento>(null);
			cabeca.setProximo(newNodo);
			this.cauda = newNodo;
		}
		else {
			cauda.setProximo(newNodo);
			this.cauda = this.cauda.getProximo();
		}
	}

	/* (non-Javadoc)
	 * @see if969.vcg.cin.ufpe.br.ed.Lista#imprimir()
	 */
	@Override
	public void imprimir() {
		if(cabeca == null) {
			return;
		}		
		Nodo<Elemento> node = cabeca.getProximo();
		while(node != null) {
			System.out.print(node.getElemento());
			node = node.getProximo();
			if(node!=null) System.out.print(" -> ");
		}
		System.out.print("\n");
	}

	/* (non-Javadoc)
	 * @see if969.vcg.cin.ufpe.br.ed.Lista#remover(java.lang.Object)
	 */
	@Override
	public void remover(Elemento e) {
		if(cabeca == null) {
			return;
		}
		Nodo<Elemento> atual = cabeca.getProximo();
		Nodo<Elemento> antes = cabeca;
		while(atual != null) {
			if(atual.getElemento().equals(e)) {
				if(atual.equals(cauda)) {
					cauda = antes;
					antes.setProximo(null);
					return;
				}
				else {
					antes.setProximo(atual.getProximo());
					return;
				}
			}
			else {
				atual = atual.getProximo();
				antes = antes.getProximo();
			}
		}
	}

	/* (non-Javadoc)
	 * @see if969.vcg.cin.ufpe.br.ed.Lista#buscar(java.lang.Object)
	 */
	@Override
	public boolean existe(Elemento e){
		if(cabeca == null) {
			return false;
		}
		Nodo<Elemento> node = cabeca.getProximo();
		while(node != null) {
			if(node.getElemento().equals(e)) {
				return true;
			}
			node = node.getProximo();
		}
		return false;
	}
	
	/**
	 * Metodo para buscar um elemento na lista
	 * @param e
	 * @return Nodo<Elemento> retorna o nodo se ele existir e null se nao.
	 */
	public Nodo<Elemento> buscar(Elemento e) {
		if(cabeca == null) {
			return null;
		}
		Nodo<Elemento> node = cabeca.getProximo();
		while(node != null) {
			if(node.getElemento().equals(e)) {
				return node;
			}
			node = node.getProximo();
		}
		return null;
	}

	/* (non-Javadoc)
	 * @see if969.vcg.cin.ufpe.br.ed.Lista#ehVazia()
	 */
	@Override
	public boolean ehVazia() {
		return (this.tamanho() == 0);
	}

	/* (non-Javadoc)
	 * @see if969.vcg.cin.ufpe.br.ed.Lista#tamanho()
	 */
	@Override
	public int tamanho() {
		Nodo<Elemento> n = cabeca;
		int i = 0;
		while(n!=null){
			i++;
			n = n.getProximo();
		}
		return i-1;
	}

	/* (non-Javadoc)
	 * @see if969.vcg.cin.ufpe.br.ed.Lista#get(int)
	 */
	@Override
	public Elemento get(int i) {
		Nodo<Elemento> n = cabeca;
		if(i>=this.tamanho()) return null;
		else {
			while(n!=null && i<0){
				i--;
				n = n.getProximo();
				if(n == null) return null;
			}
			return n.getElemento();
		}
	}

	/* (non-Javadoc)
	 * @see if969.vcg.cin.ufpe.br.ed.Lista#set(int, java.lang.Object)
	 */
	@Override
	public Elemento set(int i, Elemento e) {
		Elemento oldE = this.get(i);
		if(oldE != null){
			Nodo<Elemento> n = cabeca;
			while(n!=null){
				i--;
				n = n.getProximo();
				if(i==0) 
					n.setElemento(oldE);
			}
		}
		return oldE;
	}

}
