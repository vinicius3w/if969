/**
 * @author vcg@cin.ufpe.br
 * http://viniciusgarcia.com/courses/if969
 * @version 08-December-2011
 */
package if969.vcg.cin.ufpe.br.ed.arvore;

/**
 * Interface que especifica o TAD Arvore
 * @param <Elemento>
 */
public interface Arvore<Elemento> {

	/**
	 * Metodo para inserir um elemento na Arvore
	 * @param e
	 */
	public void inserir(Elemento e);
	
	/**
	 * Metodo para verificar se um elemento existe na Arvore
	 * @param e
	 * @return boolean Retorna true se existir o elemento e false se nao.
	 */
	public boolean existe(Elemento e);
	
	/**
	 * Metodo para caminhamento pos-ordem (pos-fixado) 
	 */
	public void posOrdem();
	
	/**
	 * Metodo para caminhamento pre-ordem (pre-fixado) 
	 */
	public void preOrdem();
	
	
	/**
	 * Metodo para caminhamento ordem simetrica (interfixado) 
	 */
	public void ordemSimetrica();
	
}
