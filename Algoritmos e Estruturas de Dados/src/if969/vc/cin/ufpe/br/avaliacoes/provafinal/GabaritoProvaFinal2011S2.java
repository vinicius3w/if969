/**
 * @author vcg@cin.ufpe.br
 * http://viniciusgarcia.com/courses/if969
 * @version 07-December-2011
 */
package if969.vc.cin.ufpe.br.avaliacoes.provafinal;

import if969.vcg.cin.ufpe.br.ed.lista.Fila;
import if969.vcg.cin.ufpe.br.ed.lista.Pilha;
import if969.vcg.cin.ufpe.br.ed.arvore.ArvoreBinaria;
import if969.vcg.cin.ufpe.br.ed.arvore.NodoArvoreBinaria;

/**
 * @author viniciusgarcia
 *
 */
public class GabaritoProvaFinal2011S2 {

	public static NodoArvoreBinaria<Character> buildExpTreePostFix(String postfixExp){
		//novoNodo eh uma referencia a raiz das subarvores criadas
		// e novoEsq/novoDir sao seus filhos
		NodoArvoreBinaria<Character> novoNodo, novoEsq, novoDir;
		char token;
		int i = 0, n = postfixExp.length();
		Pilha<NodoArvoreBinaria<Character>> p = new Pilha<NodoArvoreBinaria<Character>>();
		while (i!=n){
			while(postfixExp.charAt(i) == ' ' || postfixExp.charAt(i) == '\t')
				i++;
			
			if(i == n)
				break;
			
			token = postfixExp.charAt(i);
			i++;
			
			if(token =='+' || token =='-' || token =='*' || token =='/') {
				novoEsq = p.pop();
				novoDir = p.pop();
				
				novoNodo = new NodoArvoreBinaria<Character>(token, novoEsq, novoDir);
				p.push(novoNodo);
			} else {
				novoNodo = new NodoArvoreBinaria<Character>(token);
				p.push(novoNodo);
			}
		}
		
		if(p.top() != null)
			return p.pop();
		else
			return null;	
	}
	
	
	/**
	 * Codigo de resolucao da questao 1 - Mergesort recursivo 
	 */
	private static int[] mergesort(int[] a, int inicio, int fim) {
		if (inicio < fim) {
	        int meio = (inicio + fim) / 2;
	        a = mergesort(a, inicio, meio);
	        a = mergesort(a, meio + 1, fim);
	        a = mesclar(a, inicio, meio, fim);
        }
		return a;
	}
 
	/* 
	 * Ordena dois trechos ordenados e adjacente de vetores e ordena-os
	 * conjuntamente
	 */
	private static int[] mesclar(int[] a, int inicio, int meio, int fim) {
        int tamanho = fim - inicio + 1;
 
        /*
         * Inicialização de um vetor temporario para auxiliar na ordenação O
         * vetor temporário é uma cópia do trecho que será ordenado
         */
        int[] temp = new int[tamanho];
        System.arraycopy(a, inicio, temp, 0, tamanho);
 
        /*
         * Laço para ordenação do vetor, utilizando o vetor temporário, usando
         * índices i e j para cada trecho de vetor da mesclagem
         */
        int i = 0;
        int j = meio - inicio + 1;
 
        //A depender das condições, recebe um elemento de um trecho ou outro
        for (int posicao = 0; posicao < tamanho; posicao++) {
        	if (j <= tamanho - 1) {
        		if (i <= meio - inicio) {
        			if (temp[i] < temp[j]) {
        				a[inicio + posicao] = temp[i++];
                    } else {
                    	a[inicio + posicao] = temp[j++];
                    }
                } else {
                	a[inicio + posicao] = temp[j++];
                }
            } else {
            	a[inicio + posicao] = temp[i++];
            }
        }
        return a;
	}
	
	/**
	 * Codigo de resolucao da questao 2 - Ordenacao de filas
	 * Poderia ser resolvido reutilizando o mergesort, desenvolvido na questao 1 ou fazendo uma ordenacao nao
	 * inteligente
	 */
	public static Fila<Integer> ordenar(Fila<Integer> f1, Fila<Integer> f2){
		Fila<Integer> f3 = new Fila<Integer>();
		while (!(f1.ehVazia() && f2.ehVazia())){
			while (!(f2.ehVazia()))
				f1.enqueue(f2.dequeue());
			int menor = f1.dequeue();
			while(f1.front()!=null){
				if(f1.front() <= menor){
					f2.enqueue(menor);
					menor = f1.dequeue();
				} else {
					f2.enqueue(f1.dequeue());
				}
			}
			f3.enqueue(menor);
		}
		return f3;
	}
	
	/**
	 * Codigo de resolucao da questao 3 - Palindromo
	 */
	public static boolean palindromo(String palavra){
		boolean ehpalindromo = true;
		Pilha<Character> p = new Pilha<Character>();
		for(int i = 0; i < palavra.length(); i++)
			p.push(palavra.charAt(i));
		for(int i = 0; i < palavra.length(); i++)
			if(p.pop() != palavra.charAt(i)){
				ehpalindromo = false;
			}
		return ehpalindromo;
	}
	
	/**
	 * Codigo de resolucao da questao 4 - Avaliacao de expressoes com Arvore Binaria
	 */

	public static Double avalia(NodoArvoreBinaria<Character> exp){
		Double op1, op2, result = 0.0;
		//NodoArvoreBinaria<Character> nodo = exp.getRaiz();
		if(!exp.hasDireita())
			//return Integer.parseInt((exp.getChave().toString()));
			return Double.valueOf(exp.getElemento().toString().trim()).doubleValue();
		else {
			op1 = avalia(exp.getEsquerda());
			op2 = avalia(exp.getDireita());
			switch (exp.getElemento()) {
			case '-':
				result = op1 - op2;
				break;
			case '*':
				result = op1 * op2;
				break;
			case '/':
				result = op1 / op2;
				break;
			case '^':  result = Math.pow (op1, op2);  
				break;
			// NOTE:  allow fall-through from default to case '+'
			default: 
				System.out.println ("Unrecognized operator " + exp.getElemento() + " treated as +.");
			case '+':
				result = op1 + op2;
				break;
			}
		}
		// Return either the leaf's value or the one we just calculated.
		return result;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("----- Resolucao da Questao 1 -----");
		int[] arranjo = new int[10];
		arranjo[0] = 3;
		arranjo[1] = 5;
		arranjo[2] = 7;
		arranjo[3] = 2;
		arranjo[4] = 8;
		arranjo[5] = 10;
		arranjo[6] = 99;
		arranjo[7] = 65;
		arranjo[8] = 3;
		arranjo[9] = 1;
		System.out.print("arranjo antes: ");
		for(int i=0; i<=9; i++){
			System.out.print(arranjo[i] + " ");
		}
		System.out.println("\nordenando o arranjo...");
		arranjo = mergesort(arranjo, 0, arranjo.length-1);
		System.out.print("arranjo ordenado: ");
		  for(int i=0; i<=9; i++){
			  System.out.print(arranjo[i] + " ");
		  }
		
		System.out.println("\n----- Resolucao da Questao 2 -----");
		Fila<Integer> fila1 = new Fila<Integer>();
		fila1.enqueue(30);
		fila1.enqueue(3);
		fila1.enqueue(95);
		fila1.enqueue(-7);
		System.out.println("Imprimindo a fila 1");
		fila1.imprimir();
		Fila<Integer> fila2 = new Fila<Integer>();
		fila2.enqueue(25);
		fila2.enqueue(23);
		fila2.enqueue(0);
		fila2.enqueue(-30);
		System.out.println("Imprimindo a fila 2");
		fila2.imprimir();
		Fila<Integer> fila3 = new Fila<Integer>();
		System.out.println("Gerando a fila 3 a partir da ordenação de fila 1 e fila 2");
		fila3 = ordenar(fila1, fila2);
		System.out.println("Imprimindo a fila 3");
		fila3.imprimir();
		
		System.out.println("\n----- Resolucao da Questao 3 -----");
		System.out.println("Palindromo para: arara(s), raiar(s), hanah(s), arar(n)");
		System.out.println("arara eh palindromo: " + palindromo("arara"));
		System.out.println("raiar eh palindromo: " + palindromo("raiar"));
		System.out.println("hanah eh palindromo: " + palindromo("hanah"));
		System.out.println("arar eh palindromo: " + palindromo("arar"));
		
		System.out.println("\n----- Resolucao da Questao 4 -----");
		//criacao da arvore binaria
		ArvoreBinaria<Character> bin = new ArvoreBinaria<Character>();
		ArvoreBinaria<Character> bin2 = new ArvoreBinaria<Character>();
		//criacao dos nodos com a expressao (((1-2)-3) + (4*(5+6)))
		NodoArvoreBinaria<Character> raiz = new NodoArvoreBinaria<Character>('+', 
				new NodoArvoreBinaria<Character>('-', 
				new NodoArvoreBinaria<Character>('-', new NodoArvoreBinaria<Character>('1'), 
				new NodoArvoreBinaria<Character>('2')), new NodoArvoreBinaria<Character>('3')), 
				new NodoArvoreBinaria<Character>('*', new NodoArvoreBinaria<Character>('4'), 
				new NodoArvoreBinaria<Character>('+', new NodoArvoreBinaria<Character>('5'), 
				new NodoArvoreBinaria<Character>('6'))));
		bin.setRaiz(raiz);
		bin.ordemSimetrica();
		System.out.println("Resultado: " + avalia(bin.getRaiz()));
		NodoArvoreBinaria<Character> exp = buildExpTreePostFix("123*4/+5-");
		bin2.setRaiz(exp);
		bin2.ordemSimetrica();
	}

}
