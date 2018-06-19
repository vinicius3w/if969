package if969.vcg.cin.ufpe.br.eleicao;

public class UrnaEletronica {

	ListaCandidatos lista;

	public UrnaEletronica(ListaCandidatos l) {
		super();
		this.lista = l;
	}

	void mostraVotos(){
		System.out.println("VOTOS DOS CANDIDATOS");
		System.out.println("Presidentes:");
		mostraVotosPresidente();
		System.out.println("Governadores:");
		mostraVotosGovernador();
		System.out.println("Senadores:");
		mostraVotosSenador();
		System.out.println("Deputados Estaduais:");
		mostraVotosDeputadoEstadual();
		System.out.println("Deputados Federais:");
		mostraVotosDeputadoFederal();
	}

	void computarVotos(Eleitor eleitor){

		computaVotoDeputadoEstadual(eleitor.depE);
		computaVotoDeputadoFederal(eleitor.depF);
		computaVotoGovernador(eleitor.gov);
		computaVotoSenador(eleitor.sen1);
		computaVotoSenador(eleitor.sen2);

		computaVotoPresidente(eleitor.pres);
	}
	
	void mostraVotosPresidente(){
		for (int i = 0; i<lista.presidentes.length;i++){
			if (lista.presidentes[i].votos > 0 ){
				System.out.println(lista.presidentes[i].Partido +" - " 
						+lista.presidentes[i].nome+": "+lista.presidentes[i].votos+"\n");		
			}
		}
	}
	
	void mostraVotosGovernador(){
		for (int i = 0; i<lista.governadores.length;i++){
			if (lista.governadores[i].votos > 0 ){
				System.out.println(lista.governadores[i].Partido +" - " 
						+lista.governadores[i].nome+": "+lista.governadores[i].votos+"\n");		
			}
		}
	}
	
	void mostraVotosSenador(){
		for (int i = 0; i<lista.senadores.length;i++){
			if (lista.senadores[i].votos > 0 ){
				System.out.println(lista.senadores[i].Partido +" - " 
						+lista.senadores[i].nome+": "+lista.senadores[i].votos+"\n");		
			}
		}
	}
	
	void mostraVotosDeputadoEstadual(){
		for (int i = 0; i<lista.deputadosEstaduais.length;i++){
			if (lista.deputadosEstaduais[i].votos > 0 ){
				System.out.println(lista.deputadosEstaduais[i].Partido +" - " 
						+lista.deputadosEstaduais[i].nome+": "+lista.deputadosEstaduais[i].votos+"\n");
			}
		}
	}
	
	void mostraVotosDeputadoFederal(){
		for (int i = 0; i<lista.deputadosFederais.length;i++){
			if (lista.deputadosFederais[i].votos > 0 ){
				System.out.println(lista.deputadosFederais[i].Partido +" - " 
						+lista.deputadosFederais[i].nome+": "+lista.deputadosFederais[i].votos+"\n");		
			}
		}
	}

	void computaVotoDeputadoEstadual(String numero){
		for (int i = 0; i<lista.deputadosEstaduais.length;i++){
			if(numero.equals(lista.deputadosEstaduais[i].numero)){
				lista.deputadosEstaduais[i].votos++;
			}
		}
	}
	
	void computaVotoDeputadoFederal(String numero){
		for (int i = 0; i<lista.deputadosFederais.length;i++){
			if(numero.equals(lista.deputadosFederais[i].numero)){
				lista.deputadosFederais[i].votos++;
			}
		}
	}
	
	void computaVotoPresidente(String numero){
		for (int i = 0; i<lista.presidentes.length;i++){
			if(numero.equals(lista.presidentes[i].numero)){
				lista.presidentes[i].votos++;
				System.out.println("adicionou");
			}
		}
	}
	
	void computaVotoGovernador(String numero){
		for (int i = 0; i<lista.governadores.length;i++){
			if(numero.equals(lista.governadores[i].numero)){
				lista.governadores[i].votos++;
			}
		}
	}
	
	void computaVotoSenador(String numero){
		for (int i = 0; i<lista.senadores.length;i++){
			if(numero.equals(lista.senadores[i].numero)){
				lista.senadores[i].votos++;
			}
		}
	}

	void eleitoPresidente(){
		Presidente pSwap = new Presidente();
		for (int i = 0; i<lista.presidentes.length;i++){
			for (int j = i+1; j<lista.presidentes.length;j++)
				if(lista.presidentes[j].votos > lista.presidentes[i].votos){
					pSwap = lista.presidentes[j];
					lista.presidentes[j] = lista.presidentes[i];
					lista.presidentes[i]= pSwap;
				}
		}
		System.out.println("O Presidente eleito e': " + lista.presidentes[0].nome);
	}
	
	void eleitoGovernador(){
		Governador pSwap = new Governador();
		for (int i = 0; i<lista.governadores.length;i++){
			for (int j = i+1; j<lista.governadores.length;j++)
				if(lista.governadores[j].votos > lista.governadores[i].votos){
					pSwap = lista.governadores[j];
					lista.governadores[j] = lista.governadores[i];
					lista.governadores[i]= pSwap;
				}
		}
		System.out.println("O Governador eleito e': " + lista.governadores[0].nome);
	}
	
	void eleitoSenadores(){
		Senador pSwap = new Senador();
		for (int i = 0; i<lista.senadores.length;i++){
			for (int j = i+1; j<lista.senadores.length;j++)
				if(lista.senadores[j].votos > lista.senadores[i].votos){
					pSwap = lista.senadores[j];
					lista.senadores[j] = lista.senadores[i];
					lista.senadores[i]= pSwap;
				}
		}
		System.out.println("O Senadores eleitos são: " + lista.senadores[0].nome + " e "+ lista.senadores[1].nome );
	}

}
