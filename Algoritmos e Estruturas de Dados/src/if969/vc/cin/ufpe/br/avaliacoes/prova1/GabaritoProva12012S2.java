package if969.vc.cin.ufpe.br.avaliacoes.prova1;

import java.util.Scanner;

import if969.vcg.cin.ufpe.br.ed.lista.Pilha;

public class GabaritoProva12012S2 {
	
	/**
	 * Codigo de resolucao da questao 2 - Insertionsort para arranjo de caracteres
	 */
	public static char[] insertionSort(char[] a) { 
		int n = a.length;
	    for (int i = 1; i < n; i++) {			// index from the second character in a
	    	char cur = a[i];					// the current character to be inserted
	    	int j = i - 1;						// start comparing with cell left of i
	    	while ((j >= 0) && (a[j] > cur))	// while a[j] is out of order with cur
	    		a[j + 1] = a[j--];				// move a[j] right and decrement j
	    	a[j + 1]=cur;						// this is the proper place for cur
	    }
	    return a;
	}
	
	/**
	 * Codigo de resolucao da questao 4 - Maquina de Calcular em notacao polonesa
	 */
	
	public static int valor(char c) { 
		return c-'0';
	}
	
	public static void clear(Pilha<Integer> p){
		while(!p.ehVazia()){
			p.pop();
		}
	}
	
	public static void maquina(String s){
		Pilha<Integer> p = new Pilha<Integer>(); 
		int x,y; 
		int i = 0;
		while(s.length()>i){
			switch(s.charAt(i)) { 
				case 'C':
					clear(p);
					break; 
				case 'E':
					p.push(0);
					break; 
				case '+':
					y = p.pop(); 
					x = p.pop(); 
					p.push(x+y); 
					break;
				case '-': 
					y = p.pop();
					x = p.pop(); 
					p.push(x-y); 
					break;
				case '*': 
					y = p.pop();
					x = p.pop(); 
					p.push(x*y); 
					break;
				case '/': 
					y = p.pop();
					x = p.pop(); 
					p.push(x/y); 
					break;
				default: /* deve ser um digito */
					x = valor(s.charAt(i)); 
					y = p.pop(); 
					p.push(y*10+x);
			}
			System.out.print("["+s.charAt(i)+"] ");
			p.imprimir();
			i++;
		}
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("----- Resolucao da Questao 2 -----");
		char arranjo[] = {'k','b','d','c','f','h','g','e','j','a'};
		//int[] arranjo = {'a','b','c','d','e','f','g','h','j','k'};
		//int[] arranjo = {'k','j','h','g','f','e','d','c','b','a'};
		System.out.println("Algoritmo de Ordenacao Insertionsort");
		System.out.print("arranjo antes: ");
		for(int i=0; i<=9; i++){
			System.out.print(arranjo[i] + " ");
		}
		System.out.println("");
		System.out.println("ordenando o arranjo...");
		arranjo = insertionSort(arranjo);
		System.out.print("arranjo ordenado: ");
		for(int i=0; i<=9; i++){
			System.out.print(arranjo[i] + " ");
		}
		System.out.println("");
		System.out.println("");
		
		System.out.println("----- Resolucao da Questao 3 -----");
		
		System.out.println("----- Resolucao da Questao 4 -----");
		
		/* entrada exemplo */ 
		String ent="E90E20E15E13-*E5+/"; 
		maquina(ent); 
		System.out.println("Fim");
	}
}
