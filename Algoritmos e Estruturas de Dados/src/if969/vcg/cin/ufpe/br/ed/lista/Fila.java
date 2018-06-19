/**
 * @author vcg@cin.ufpe.br
 * http://viniciusgarcia.com/courses/if969
 * @version 07-December-2011
 */
package if969.vcg.cin.ufpe.br.ed.lista;

/**
 * Clase que implementa o TAD Fila
 * @param <Elemento>
 */
public class Fila<Elemento> {
	
	/**
	 * Nodo sentinela para o inicio da Fila
	 */
	private Nodo<Elemento> inicio;
	
	/**
	 * Nodo sentinela para o fim da Fila
	 */
	private Nodo<Elemento> fim;

	/**
	 * Metodo para inserir (enqueue) um elemento na fila
	 * @param e
	 */
	public void enqueue(Elemento e) {

		Nodo<Elemento> n = new Nodo<Elemento>(e);

		n.setProximo(null);
		if (fim != null) {
			fim.setProximo(n);
		} else {
			inicio = n;
		}
		fim = n;
	}

	/**
	 * Metodo para retirar (dequeue) um elemento da fila
	 * @return
	 */
	public Elemento dequeue() {
		if (inicio != null) {
			Nodo<Elemento> n = inicio;
			inicio = inicio.getProximo();
			if (inicio == null) {
				fim = null;
			}
			return n.getElemento();
		} else {
			return null;
		}
	}
	
	/**
	 * Metodo para retornar o elemento do inicio da Fila
	 * @return Elemento
	 */
	public Elemento front(){
		if (inicio != null) {
			return inicio.getElemento();
		} else {
			return null;
		}
	}
	
	public boolean ehVazia(){
		return inicio==null;
	}
	
	public void imprimir(){
		if (inicio == null) {
			System.out.println("Fila vazia!");
			return;
		} else {
			Nodo<Elemento> naux = inicio;
			while(naux != null) {
				System.out.print(naux.getElemento());
				naux = naux.getProximo();
				if(naux!=null) System.out.print(" -> ");
			}
			System.out.print("\n");
		}
	}

}
