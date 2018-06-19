package if969.vcg.cin.ufpe.br.eleicao;

public class Senador extends Candidato{

	String estado;
	public Senador() {
	}
	
	public Senador(String nome, String numero, String partido, String estado) {
		super(nome, numero, partido);
		this.estado = estado;
	}

}
