package if969.vcg.cin.ufpe.br.eleicao;

public class Governador extends Candidato {

	String estado;
	public Governador() {
	}

	public Governador(String nome, String numero, String partido, String estado) {
		super(nome, numero, partido);
		this.estado = estado;
	}

}
