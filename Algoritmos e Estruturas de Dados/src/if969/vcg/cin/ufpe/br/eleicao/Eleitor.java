package if969.vcg.cin.ufpe.br.eleicao;

public class Eleitor {
	
	String nome;
	String titulo;
	
	String pres;
	String gov;
	String sen1;
	String sen2;
	String depE;
	String depF;

	public Eleitor(String nome, String titulo) {
		super();
		this.nome = nome;
		this.titulo = titulo;
	}

	public Eleitor() {
	}
	
	void votoGovernador(String numero){
		this.gov = numero;
	}
	void votoSenador1(String numero){
		this.sen1 = numero;
	}
	void votoSenador2(String numero){
		this.sen2 = numero;
	}
	void votoDeputadoEstadual(String numero){
		this.depE = numero;
	}
	void votoDeputadoFederal(String numero){
		this.depF = numero;
	}
	void votoPresidente(String numero){
		this.pres = numero;
	}

}
