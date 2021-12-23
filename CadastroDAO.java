import java.util.ArrayList;
import java.time.LocalDate;

public class CadastroDAO {
	private static ArrayList<Pessoa> cads = new ArrayList<Pessoa>();

	public static void cadastrar() {
		String nome;
		String aniv;
		String tel;
		String al = "nao";
		nome = InteracaoUsu.receberString("Nome: ");
		aniv = InteracaoUsu.receberData("Nascimento:");
		tel = InteracaoUsu.receberTel("Telefone (apenas numeros):");		
		al = InteracaoUsu.receberString("Deseja cadastrar uma nota? [sim/nao]");

		Pessoa pes;      		
		
		if (al.equalsIgnoreCase("sim")) {
			float nota = InteracaoUsu.receberFloat("Nota: ");
			pes = new Aluno(nota);
		} else {
			pes = new Pessoa();
		}

		pes.setNome(nome);
		pes.setNasc(aniv);
		pes.setTel(tel);
		pes.setCad(LocalDate.now().toString());
		pes.setAlt(LocalDate.now().toString());
		cads.add(pes);
	}

	public static void listar() {
		String vis;
		InteracaoUsu.mostrarTexto("Cadastros:");
		for(Pessoa p:cads) {
			InteracaoUsu.mostrarTexto(p.getNome());
		}
		vis = InteracaoUsu.receberString("Visualizar um cadastro?[sim/nao]");
		if (vis.equalsIgnoreCase("sim")) {
			String nome = InteracaoUsu.receberString("Nome:");
			for(Pessoa p:cads) {
				if (p.getNome().equalsIgnoreCase(nome)) {
					InteracaoUsu.mostrarTexto("Nome: "+p.getNome());
					InteracaoUsu.mostrarTexto("Telefone: "+p.getTel());
					InteracaoUsu.mostrarTexto("Nascimento: "+p.getNasc());
					InteracaoUsu.mostrarTexto("Data de cadastro: "+p.getCad());
					if (p.getClass().getName().equals("Aluno")) {
						Aluno alu = (Aluno) p;
						InteracaoUsu.mostrarTexto("Nota: "+alu.getNota());
						//InteracaoUsu.mostrarTexto("oii");
					}
					InteracaoUsu.mostrarTexto("Ultima alteracao: "+p.getAlt());
				}
			}
		}
	}

	public static void atualizar() {
		String nome = InteracaoUsu.receberString("Nome: ");
		for(Pessoa p:cads) {
			if (p.getNome().equals(nome)) {
				String fim = "nao";
				int op = 0;
				while(fim.equals("nao")) {
					op = InteracaoUsu.receberInt("Opcoes:\r\n1: Atualizar nome;\r\n"
					+"2: Atualizar telefone;\r\n"
					+"3: Atualizar nascimento;\r\n"
					+"4: Atualizar nota;\r\n"
					+"5: Encerrar atualizacao.");
					switch(op) {
						case 1:
							String nNome = InteracaoUsu.receberString("Novo nome: ");
							p.setNome(nNome);
							break;
						case 2:
							String nTel = InteracaoUsu.receberTel("Novo telefone (apenas numeros):");
							p.setTel(nTel);
							break;
						case 3:
							String nData = InteracaoUsu.receberData("Nova data de nascimento:");
							p.setNasc(nData);
							break;
						case 4:
							Aluno alu = (Aluno) p;
							float nNota = InteracaoUsu.receberFloat("Nova nota:");
							alu.setNota(nNota);
							break;
						case 5:
							 fim = InteracaoUsu.receberString("Finalizar atualizacao? [sim/nao]");
							 break;
						default:
							InteracaoUsu.mostrarTexto("Opcao invalida.");
					}
					p.setAlt(LocalDate.now().toString());
					
				}
				break;
			}
		}				
	}

	public static void deletar() {
		String nome = InteracaoUsu.receberString("Nome: ");
		for(Pessoa p:cads) {
			if (p.getNome().equals(nome)) {
				cads.remove(p);
				break;
			}
		}		
	}
}