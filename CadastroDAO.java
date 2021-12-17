import java.util.ArrayList;

public class CadastroDAO {
	private static ArrayList<Pessoa> cads = new ArrayList<Pessoa>();

	public static void cadastrar() {
		String nome;
		String aniv;
		String tel;
		String al = "nao";
		nome = InteracaoUsu.receberString("Nome: ");
		aniv = InteracaoUsu.receberData("Nascimento:");
		tel = InteracaoUsu.receberTel();		
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
		cads.add(pes);
	}

	public static void listar() {
		InteracaoUsu.mostrarTexto("Cadastros:");
		for(Pessoa p:cads) {
			InteracaoUsu.mostrarTexto(p.getNome());
		}
	}

	public static void atualizar() {
		String nome = InteracaoUsu.receberString("Nome: ");
		for(Pessoa p:cads) {
			if (p.getNome().equals(nome)) {
				String nNome = InteracaoUsu.receberString("Novo nome: ");
				p.setNome(nNome);
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