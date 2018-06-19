/**
 * @author vcg@cin.ufpe.br
 * http://viniciusgarcia.com/courses/if969
 * @version 08-December-2011
 */
package if969.vcg.cin.ufpe.br.ed.grafo;

/**
 * Classe que implementa uma Aresta de um Grafo por Matriz de Adjacencia
 */
public class ArestaGMA {
	
	private int v1, v2, peso;
	
    /**
     * @param v1
     * @param v2
     * @param peso
     */
    public ArestaGMA (int v1, int v2, int peso) {
      this.v1 = v1; this.v2 = v2; this.peso = peso;
    }
    
    /**
     * @return
     */
    public int peso () { return this.peso; }
    
    /**
     * @return
     */
    public int v1 () { return this.v1; }
    
    /**
     * @return
     */
    public int v2 () { return this.v2; }

}
