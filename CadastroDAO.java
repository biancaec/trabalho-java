import java.util.ArrayList;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class CadastroDAO {
	private static ArrayList<Pessoa> cads = new ArrayList<Pessoa>();
	private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

	public static void cadastrar() {
		String nome;
		String aniv;
		String tel;
		String al = "nao";
		nome = InteracaoUsu.receberString("Nome: ");
		aniv = InteracaoUsu.receberData("Nascimento:");
		tel = InteracaoUsu.receberTel("Telefone (apenas numeros):");		
		al = InteracaoUsu.receberString("\nDeseja cadastrar uma nota? [sim/nao]");

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
		pes.setCad(LocalDate.now().format(formatter));
		pes.setAlt(LocalDate.now().format(formatter));
		cads.add(pes);
	}

	public static void listar() {
		if (cads.isEmpty()) {
			InteracaoUsu.mostrarTexto("\nNao ha cadastros.\n");
		} else {
			String vis;
			InteracaoUsu.mostrarTexto("\nCadastros:\n");
			for(Pessoa p:cads) {
				InteracaoUsu.mostrarTexto(p.getNome());
			}
			vis = InteracaoUsu.receberString("\nVisualizar um cadastro?[sim/nao]");
			if (vis.equalsIgnoreCase("sim")) {
				String nome = InteracaoUsu.receberString("\nNome:");
				for(Pessoa p:cads) {
					if (p.getNome().equalsIgnoreCase(nome)) {
						InteracaoUsu.mostrarTexto("\nNome: "+p.getNome());
						InteracaoUsu.mostrarTexto("Telefone: "+p.getTel());
						InteracaoUsu.mostrarTexto("Nascimento: "+p.getNasc());
						if (p.getClass().getName().equals("Aluno")) {
							Aluno alu = (Aluno) p;
							InteracaoUsu.mostrarTexto("Nota: "+alu.getNota());
						}
						InteracaoUsu.mostrarTexto("Data de cadastro: "+p.getCad());
						InteracaoUsu.mostrarTexto("Ultima alteracao: "+p.getAlt()+"\n");
					}
				}
			}
		}
	}

	public static void atualizar() {
		if (cads.isEmpty()) {
			InteracaoUsu.mostrarTexto("\nNao ha cadastros.\n");
		} else {
			String nome = InteracaoUsu.receberString("\nNome: ");
			for(Pessoa p:cads) {
				if (p.getNome().equals(nome)) {
					String fim = "nao";
					int op = 0;
					while(fim.equals("nao")) {
						op = InteracaoUsu.receberInt("\nOpcoes:\r\n1: Atualizar nome;\r\n"
						+"2: Atualizar telefone;\r\n"
						+"3: Atualizar nascimento;\r\n"
						+"4: Atualizar nota;\r\n"
						+"5: Encerrar atualizacao.");
						switch(op) {
							case 1:
								String nNome = InteracaoUsu.receberString("\nNovo nome: ");
								p.setNome(nNome);
								break;
							case 2:
								String nTel = InteracaoUsu.receberTel("\nNovo telefone (apenas numeros):");
								p.setTel(nTel);
								break;
							case 3:
								String nData = InteracaoUsu.receberData("\nNova data de nascimento:");
								p.setNasc(nData);
								break;
							case 4:
								Aluno alu = (Aluno) p;
								float nNota = InteracaoUsu.receberFloat("\nNova nota:");
								alu.setNota(nNota);
								break;
							case 5:
								 fim = InteracaoUsu.receberString("\nFinalizar atualizacao? [sim/nao]");
								 break;
							default:
								InteracaoUsu.mostrarTexto("Opcao invalida.");
						}
						p.setAlt(LocalDate.now().format(formatter));	
					}
					break;
				}
			}				
		}
	}

	public static void deletar() {
		if (cads.isEmpty()) {
			InteracaoUsu.mostrarTexto("\nNao ha cadastros.\n");
		} else {
			String nome = InteracaoUsu.receberString("Nome: ");
			for(Pessoa p:cads) {
				if (p.getNome().equals(nome)) {
					cads.remove(p);
					break;
				}
			}		
		}
	}	
}