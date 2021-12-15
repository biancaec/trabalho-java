import java.util.ArrayList;
import java.time.MonthDay;

public class CadastroDAO {
	private static ArrayList<Pessoa> cads = new ArrayList<Pessoa>();

	public static void cadastrar() {
		String nome;
		String al = "nao";
		nome = InteracaoUsu.receberString("Nome: ");
		InteracaoUsu.mostrarTexto("Nascimento (dd/mm/aaaa):");
		int dd = InteracaoUsu.receberInt("dia:");
		int mm = InteracaoUsu.receberInt("mes:");
		int aa = InteracaoUsu.receberInt("ano:");
		MonthDay date = MonthDay.of(mm,dd);
		System.out.println(date.isValidYear(aa));
		al = InteracaoUsu.receberString("Deseja cadastrar uma nota? [sim/nao]");
		Pessoa pes;      		
		
		if (al.equalsIgnoreCase("sim")) {
			float nota = InteracaoUsu.receberFloat("Nota: ");
			pes = new Aluno(nota);
		} else {
			pes = new Pessoa();
		}

		pes.setNome(nome);
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