/**
 * @author vcg@cin.ufpe.br
 * http://viniciusgarcia.com/courses/if969
 * @version 08-December-2011
 */
package if969.vcg.cin.ufpe.br.ed.grafo;

/**
 * Classe que implementa um Grafo por Matriz de Adjacencia
 */
public class GrafoMatrixAdjacencia {
	
	private int mat[][]; // pesos do tipo inteiro
	private int numVertices, cnt, ini, fim;
	private int pos[]; // posicao atual ao se percorrer os adjs de um vertice
	private int visitado[];
	private int ordemvisit[];
	private int fila[];

	/**
	 * @param numVertices
	 */
	public GrafoMatrixAdjacencia(int numVertices) {
		this.mat = new int[numVertices][numVertices];
	    this.pos = new int[numVertices];
	    this.visitado = new int[numVertices];
	    this.ordemvisit = new int[numVertices];
	    this.fila = new int[numVertices];
	    this.numVertices = numVertices; 
	    for (int i = 0; i < this.numVertices; i++) {
	      for (int j = 0; j < this.numVertices; j++) this.mat[i][j] = 0;
	      this.pos[i] = -1; 
	    }
	}
	
	/**
	 * @param numVertices
	 * @param numArestas
	 */
	public GrafoMatrixAdjacencia (int numVertices, int numArestas) {
	    this.mat = new int[numVertices][numVertices];
	    this.pos = new int[numVertices]; 
	    this.visitado = new int[numVertices];
	    this.ordemvisit = new int[numVertices];
	    this.fila = new int[numVertices];
	    this.numVertices = numVertices; 
	    for (int i = 0; i < this.numVertices; i++) {
	      for (int j = 0; j < this.numVertices; j++) this.mat[i][j] = 0;
	      this.pos[i] = -1; 
	    }
	}

	/**
	 * @param v1
	 * @param v2
	 * @param peso
	 */
	public void insereAresta (int v1, int v2, int peso) {
	    this.mat[v1][v2] = peso; 
	}
	
	/**
	 * @param v1
	 * @param v2
	 * @return
	 */
	public boolean existeAresta (int v1, int v2) {
		return (this.mat[v1][v2] > 0);
	}

	/**
	 * @param v
	 * @return
	 */
	public boolean listaAdjVazia (int v) {
		for (int i =0; i < this.numVertices; i++)
			if (this.mat[v][i] > 0) return false;
		return true;
	}
  
	/**
	 * Retorna a primeira aresta que o vertice v participa ou
	 * null se a lista de adjacencia de v for vazia
	 * @param v
	 * @return
	 */
	public ArestaGMA primeiroListaAdj (int v) {
		this.pos[v] = -1; return this.proxAdj (v);
	}
	
	/**
	 * Retorna a proxima aresta que o vertice v participa ou
	 * null se a lista de adjacencia de v estiver no fim
	 * @param v
	 * @return
	 */
	public ArestaGMA proxAdj (int v) {
	    this.pos[v] ++;
	    while ((this.pos[v] < this.numVertices) && 
	           (this.mat[v][this.pos[v]] == 0)) this.pos[v]++;
	    if (this.pos[v] == this.numVertices) return null;
	    else return new ArestaGMA (v, this.pos[v], this.mat[v][this.pos[v]]);
	}
	
	/**
	 * @param v1
	 * @param v2
	 * @return
	 */
	public ArestaGMA retiraAresta (int v1, int v2) {
		if (this.mat[v1][v2] == 0) return null; //Aresta nao existe
		else {
			ArestaGMA aresta = new ArestaGMA (v1, v2, this.mat[v1][v2]);
			this.mat[v1][v2] = 0; return aresta;
		}
	}
	

	/**
	 * 
	 */
	public void imprime () {
		System.out.print ("   ");
		for (int i = 0; i < this.numVertices; i++) 
			System.out.print (i + "   "); 
		System.out.println ();
		for (int i = 0; i < this.numVertices; i++) { 
			System.out.print (i + "  ");
			for (int j = 0; j < this.numVertices; j++)
				System.out.print (this.mat[i][j] + "   ");
			System.out.println ();
		}
	}
	
	/**
	 * @return
	 */
	public int numVertices () { 
		return this.numVertices; 
	}
 
	/**
	 * @return
	 */
	public GrafoMatrixAdjacencia grafoTransposto () {
		GrafoMatrixAdjacencia grafoT = new GrafoMatrixAdjacencia (this.numVertices); 
		for (int v = 0; v < this.numVertices; v++)
			if (!this.listaAdjVazia (v)) {
				ArestaGMA adj = this.primeiroListaAdj (v);
				while (adj != null) {
					grafoT.insereAresta (adj.v2 (), adj.v1 (), adj.peso ());
					adj = this.proxAdj (v);
				}
			}
		return grafoT;
	}
	
	public void dfsDigrafo(){  
		int v;       
		for(v = 0; v < this.numVertices; ++v) //ninguŽm foi visitado  
			this.visitado[v] = 0;  
		     
		for(v = 0; v < this.numVertices; ++v){ //roda todos os vŽrtices  
			if(this.visitado[v] == 0 ){ //se ainda n‹o foi visitado  
		    	dfs(v); //faz a busca para esse vŽrtice  
		    }  
		}  
	}
	
	/*
	 * Busca em profundidade (depth-first search - DFS)
	 */
	private void dfs(int origem){   
		int v = origem; //vŽrtice atual  
		this.visitado[v] = 1; //origem est‡ visitada  
		  
		for(int i = 0; i < this.numVertices; ++i){ //rodar todas as poss’veis arestas de v         
			if (this.mat[v][i] == 1 && this.visitado[i] == 0){ //existe aresta e ainda n‹o visitou            
				//Faz aqui o que quiser antes da chamada recursiva...            
				dfs(i); //visita esse vŽrtice            
				//Faz aqui o que quiser ap—s o retorno do backtracking         
		    }
		}   
	}  
	
	/* Busca em largura (breadth first search Ñ BFS)
	 * A funcao bfsDigrafo visita todos os vertices do digrafo G que podem ser alcancados a partir do vertice s. 
	 * A ordem em que os vertices s‹o visitados eh registrada no vetor ordemvisit. 
	 */ 
	public void bfsDigrafo (int s) {   
	   int v, w;  
	   cnt = 0;  
	   for (v = 0; v < this.numVertices; v++) this.ordemvisit[v] = -1;  
	   this.ordemvisit[s] = this.cnt++;  
	   this.ini = this.fim = 0;  
	   fila[this.ini++] = s;   
	   while (this.ini > this.fim) {  
	       v = this.fila[this.fim++];   
	       for (w = 0; w < this.numVertices; w++)  
	           if (this.mat[v][w] == 1)  
	              if (this.ordemvisit[w] == -1) {   
	                 this.ordemvisit[w] = this.cnt++;   
	                 this.fila[this.ini++] = w;   
	             }  
	   }  
	}
}
