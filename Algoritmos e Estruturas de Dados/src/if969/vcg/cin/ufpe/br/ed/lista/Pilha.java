/**
 * @author vcg@cin.ufpe.br
 * http://viniciusgarcia.com/courses/if969
 * @version 07-December-2011
 */
package if969.vcg.cin.ufpe.br.ed.lista;

/**
 * Classe que implementa o TAD Pilha
 * @param <Elemento	>
 */
public class Pilha<Elemento> {
	/**
	 * Nodo sentinela para o topo da Pilha
	 */
	private Nodo<Elemento> topo;
	
	/**
	 * Metodo para inserir (push) um elemento na Pilha
	 * @param e
	 */
	public void push(Elemento e) {
		Nodo<Elemento> no = new Nodo<Elemento>(e);
		no.setProximo(topo);
		topo = no;
	}
	
	/**
	 * Metodo para remover um elemento (pop) da pilha
	 * @return Elemento
	 */
	public Elemento pop() {
		if(topo != null) {
			Nodo<Elemento> no = topo;
			topo = topo.getProximo();
			return no.getElemento();
		} else {
			return null;
		}
	}
	
	/**
	 * Metodo para retornar o elemento do topo da Pilha
	 * @return Elemento
	 */
	public Elemento top() {
		if(topo != null)
			return topo.getElemento();
		else
			return null;
	}
	
	public boolean ehVazia(){
		return topo==null;
	}
	
	public void imprimir(){
		if (topo == null) {
			System.out.println("Fila vazia!");
			return;
		} else {
			Nodo<Elemento> naux = topo;
			while(naux != null) {
				System.out.print(naux.getElemento());
				naux = naux.getProximo();
				if(naux!=null) System.out.print(" -> ");
			}
			System.out.print("\n");
		}
	}
}
