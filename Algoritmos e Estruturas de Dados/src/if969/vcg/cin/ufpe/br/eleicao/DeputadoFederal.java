package if969.vcg.cin.ufpe.br.eleicao;

public class DeputadoFederal extends Candidato {

	String estado;
	
	public DeputadoFederal() {
	}

	public DeputadoFederal(String nome, String numero, String partido, String estado) {
		super(nome, numero, partido);
		this.estado = estado;
	}

}
