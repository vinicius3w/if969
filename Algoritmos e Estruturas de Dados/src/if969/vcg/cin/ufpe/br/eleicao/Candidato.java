package if969.vcg.cin.ufpe.br.eleicao;

public abstract class Candidato {
	
	String nome;
	String numero;
	String Partido;
	int votos;
	
	public Candidato(){
		votos = 0;
	}
	public Candidato(String nome, String numero, String partido) {
		super();
		this.nome = nome;
		this.numero = numero;
		Partido = partido;
		votos = 0;
	}

}
