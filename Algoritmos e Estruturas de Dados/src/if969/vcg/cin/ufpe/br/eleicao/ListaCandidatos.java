package if969.vcg.cin.ufpe.br.eleicao;

public class ListaCandidatos {
	
	Presidente presidentes[];
	Governador governadores[];
	Senador senadores[];
	DeputadoEstadual deputadosEstaduais[];
	DeputadoFederal deputadosFederais[];

	public ListaCandidatos() {
		//5 candidatos
		governadores = new Governador[5];
		governadores[0] = new Governador("Rosalba Ciarlini","25","DEM","RN");
		governadores[1] = new Governador("Carlos Eduardo","12","PDT","RN");
		governadores[2] = new Governador("Ibere","40","PSB","RN");
		governadores[3] = new Governador("Sandro Pimentel","50","PSOL","RN");
		governadores[4] = new Governador("Roberto Ronconi","20","PTC","RN");
		
		senadores = new Senador[4];
		senadores[0] = new Senador("Garibaldi","154","PMDB","RN");
		senadores[1] = new Senador("José Agripino","252","DEM","RN");
		senadores[2] = new Senador("Wilma de Faria","400","PSB","RN");
		senadores[3] = new Senador("Joanilson","277","PSDC","RN");
		
		presidentes = new Presidente[3];
		presidentes[0] = new Presidente("Dilma","13","PT");
		presidentes[1] = new Presidente("José Serra","45","PSDB");
		presidentes[2] = new Presidente("Marina Silva","40","PV");
		
		deputadosEstaduais = new DeputadoEstadual[2];
		deputadosEstaduais[0] = new DeputadoEstadual("Fulano","32212","PWL","RN");
		deputadosEstaduais[1] = new DeputadoEstadual("Sicrano","12212","PGC","RN");
		deputadosFederais = new DeputadoFederal[2];
		deputadosFederais[0] = new DeputadoFederal("Beltrano","1212","OPQ","RN");
		deputadosFederais[1] = new DeputadoFederal("Sicrano Filho","3333","PQC","RN");	
	}
	
	void listarCandidatosPresidente(){
		for (int i = 0; i< this.presidentes.length;i++){
			System.out.println(presidentes[i].Partido + "-"+
					presidentes[i].nome + "-"+ presidentes[i].numero);	
		}
	}
	
	void listarCandidatosGovernador(){
		for (int i = 0; i< this.governadores.length;i++){
			System.out.println(governadores[i].Partido + "-"+
					governadores[i].nome + "-"+ governadores[i].numero);	
		}	
	}
	
	void listarCandidatosSenador(){
		for (int i = 0; i< this.senadores.length;i++){
			System.out.println(senadores[i].Partido + "-"+
					senadores[i].nome + "-"+ senadores[i].numero);	
		}	
	}
	
	void listarCandidatosDeputadoEstadual(){
		for (int i = 0; i< this.deputadosEstaduais.length;i++){
			System.out.println(deputadosEstaduais[i].Partido + "-"+
					deputadosEstaduais[i].nome + "-"+ deputadosEstaduais[i].numero);	
		}	
	}
	
	void listarCandidatosDeputadoFederal(){
		for (int i = 0; i< this.deputadosFederais.length;i++){
			System.out.println(deputadosFederais[i].Partido + "-"+
					deputadosFederais[i].nome + "-"+ deputadosFederais[i].numero);	
		}
	}
}