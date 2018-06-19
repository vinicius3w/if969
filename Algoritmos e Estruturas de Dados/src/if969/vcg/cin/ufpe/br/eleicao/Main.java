package if969.vcg.cin.ufpe.br.eleicao;

import java.util.Scanner;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		//leitura do teclado
		Scanner sc = new Scanner(System.in);  

		ListaCandidatos lc = new ListaCandidatos();
		Eleitor eleitor = new Eleitor("Raul","2314311");
		UrnaEletronica urna = new UrnaEletronica(lc);
		while (true){
			try {
				System.out.println("URNA ELETRONICA -- INICIE SUA VOTACAO\n");
				System.out.println("Digite o numero do seu Deputado Estadual");
				lc.listarCandidatosDeputadoEstadual();
				eleitor.votoDeputadoEstadual( sc.next());

				System.out.println("Digite o numero do seu Deputado Federal");
				lc.listarCandidatosDeputadoFederal();
				eleitor.votoDeputadoFederal( sc.next());
				
				System.out.println("Digite o numero do seu Senador (1ª escolha)");
				lc.listarCandidatosSenador();
				String numSenador1 = sc.next();
				String numSenador2;
				eleitor.votoSenador1(numSenador1);
				while(true){//nao deixa que o mesmo senador receba o voto 2 vezes
					System.out.println("Digite o numero do seu Senador (2ª escolha)");
					numSenador2 = sc.next();
					if(numSenador1.equals(numSenador2)){
						System.out.println("Escolha um candidato a Senador diferente do primeiro");
					}
					else{
						break;
					}
				}
				eleitor.votoSenador2(numSenador2);
				System.out.println("Digite o numero do seu Governador");
				lc.listarCandidatosGovernador();
				eleitor.votoGovernador( sc.next());

				System.out.println("Digite o numero do seu Presidente");
				lc.listarCandidatosPresidente();
				eleitor.votoPresidente( sc.next());


				urna.computarVotos(eleitor);
				urna.mostraVotos();
				
				System.out.println("Nova votacao? S/N");
				if (!sc.next().toLowerCase().equals("s")){
					System.out.println("Votacao encerrada!");
					urna.mostraVotos();
					urna.eleitoPresidente();
					urna.eleitoGovernador();
					urna.eleitoSenadores();
					break;				
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
