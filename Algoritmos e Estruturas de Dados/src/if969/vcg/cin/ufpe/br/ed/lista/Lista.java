/**
 * @author vcg@cin.ufpe.br
 * http://viniciusgarcia.com/courses/if969
 * @version 07-December-2011
 */
package if969.vcg.cin.ufpe.br.ed.lista;

/**
 * Interface que especifica o TAD Lista
 * @param <Elemento>
 */
public interface Lista<Elemento> {
	
	/**
	 * Metodo para inserir um elemento na Lista
	 * @param e
	 */
	public void inserir(Elemento e);
	
	/**
	 * Metodo para imprimir a Lista 
	 */
	public void imprimir();
	
	/**
	 * Metodo para remover um elemento da Lista
	 * @param e
	 */
	public void remover(Elemento e);
	
	/**
	 * Metodo para verificar se um elemento existe na Lista.  
	 * @param e
	 * @return boolean Retorna true se o elemento existir, 
	 * e false se nao existir.
	 */
	public boolean existe(Elemento e);
	
	/**
	 * Retorna true se a lista estiver vazia e false se nao.
	 * @return boolean
	 */
	public boolean ehVazia();
	
	/**
	 * Retorna o tamanho da lista
	 * @return int
	 */
	public int tamanho();
	
	/** 
	 * Retorna o elemento no indice i, sem remove-lo. 
	 * @param i
	 * @return Elemento
	 */
	public Elemento get(int i);
	
	/** 
	 * Substitui o elemento do indice i por e, retornando o elemento anterior em i. 
	 * @param i
	 * @param e
	 * @return Elemento
	 */
	public Elemento set(int i, Elemento e);

}
