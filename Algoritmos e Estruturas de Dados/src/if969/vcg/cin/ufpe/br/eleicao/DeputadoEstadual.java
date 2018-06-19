package if969.vcg.cin.ufpe.br.eleicao;

public class DeputadoEstadual extends Candidato {

	String estado;
	
	public DeputadoEstadual() {
	}

	public DeputadoEstadual(String nome, String numero, String partido, String estado) {
		super(nome, numero, partido);
		this.estado = estado;
	}

}
