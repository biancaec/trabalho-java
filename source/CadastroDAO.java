import java.util.ArrayList;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class CadastroDAO {
	private static ArrayList<Pessoa> cadastros = new ArrayList<Pessoa>();
	private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

	public static void cadastrar() {
		String nome;
		String dataNascimento;
		String telefone;
		String aluno = "nao";
		nome = InteracaoUsuario.receberString("Nome: ");
		dataNascimento = InteracaoUsuario.receberData("Nascimento:");
		telefone = InteracaoUsuario.receberTelefone("Telefone (apenas numeros):");		
		aluno = InteracaoUsuario.receberString("\nDeseja cadastrar uma nota? [sim/nao]");

		Pessoa pes;      		
		
		if (aluno.equalsIgnoreCase("sim")) {
			float nota = InteracaoUsuario.receberFloat("Nota: ");
			pes = new Aluno(nota);
		} else {
			pes = new Pessoa();
		}

		pes.setNome(nome);
		pes.setDataNascimento(dataNascimento);
		pes.setTelefone(telefone);
		pes.setDataCadastro(LocalDate.now().format(formatter));
		pes.setUltimaAlteracao(LocalDate.now().format(formatter));
		cadastros.add(pes);
	}

	public static void listar() {
		if (cadastros.isEmpty()) {
			InteracaoUsuario.mostrarTexto("\nNao ha cadastros.\n");
		} else {
			String listar;
			InteracaoUsuario.mostrarTexto("\nCadastros:\n");
			for(Pessoa p:cadastros) {
				InteracaoUsuario.mostrarTexto(p.getNome());
			}
			listar = InteracaoUsuario.receberString("\nVisualizar um cadastro?[sim/nao]");
			if (listar.equalsIgnoreCase("sim")) {
				String nome = InteracaoUsuario.receberString("\nNome:");
				for(Pessoa p:cadastros) {
					if (p.getNome().equalsIgnoreCase(nome)) {
						InteracaoUsuario.mostrarTexto("\nNome: "+p.getNome());
						InteracaoUsuario.mostrarTexto("Telefone: "+p.getTelefone());
						InteracaoUsuario.mostrarTexto("Nascimento: "+p.getDataNascimento());
						if (p.getClass().getName().equals("Aluno")) {
							Aluno aluno = (Aluno) p;
							InteracaoUsuario.mostrarTexto("Nota: "+aluno.getNota());
						}
						InteracaoUsuario.mostrarTexto("Data de cadastro: "+p.getDataCadastro());
						InteracaoUsuario.mostrarTexto("Ultima alteracao: "+p.getUltimaAlteracao()+"\n");
					}
				}
			}
		}
	}

	public static void atualizar() {
		if (cadastros.isEmpty()) {
			InteracaoUsuario.mostrarTexto("\nNao ha cadastros.\n");
		} else {
			String nome = InteracaoUsuario.receberString("\nNome: ");
			for(Pessoa p:cadastros) {
				if (p.getNome().equals(nome)) {
					String fim = "nao";
					int op = 0;
					while(fim.equals("nao")) {
						op = InteracaoUsuario.receberInt("\nOpcoes:\r\n1: Atualizar nome;\r\n"
						+"2: Atualizar telefone;\r\n"
						+"3: Atualizar nascimento;\r\n"
						+"4: Atualizar nota;\r\n"
						+"5: Encerrar atualizacao.");
						switch(op) {
							case 1:
								String nNome = InteracaoUsuario.receberString("\nNovo nome: ");
								p.setNome(nNome);
								break;
							case 2:
								String nTel = InteracaoUsuario.receberTelefone("\nNovo telefone (apenas numeros):");
								p.setTelefone(nTel);
								break;
							case 3:
								String nData = InteracaoUsuario.receberData("\nNova data de nascimento:");
								p.setDataNascimento(nData);
								break;
							case 4:
								Aluno alu = (Aluno) p;
								float nNota = InteracaoUsuario.receberFloat("\nNova nota:");
								alu.setNota(nNota);
								break;
							case 5:
								 fim = InteracaoUsuario.receberString("\nFinalizar atualizacao? [sim/nao]");
								 break;
							default:
								InteracaoUsuario.mostrarTexto("Opcao invalida.");
						}
						p.setUltimaAlteracao(LocalDate.now().format(formatter));	
					}
					break;
				}
			}				
		}
	}

	public static void deletar() {
		if (cadastros.isEmpty()) {
			InteracaoUsuario.mostrarTexto("\nNao ha cadastros.\n");
		} else {
			String nome = InteracaoUsuario.receberString("Nome: ");
			for(Pessoa p:cadastros) {
				if (p.getNome().equals(nome)) {
					cadastros.remove(p);
					break;
				}
			}		
		}
	}	
}