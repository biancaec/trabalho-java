public class Principal {
	
	public static void main (String args[]) {
		String fim = "nao";
		int op = 0;

		while (fim.equalsIgnoreCase("nao")) {
			op = InteracaoUsu.receberInt("Opcoes:\r\n1: Cadastrar pessoa;\r\n"
				+"2: Mostrar cadastros;\r\n"
				+"3: Atualizar cadastro;\r\n"
				+"4: Deletar cadastro;\r\n"
				+"5: Finalizar programa.");
			switch(op) {
				case 1: 
					CadastroDAO.cadastrar();
					break;
				case 2: 
					CadastroDAO.listar();
					break;
				case 3:
					CadastroDAO.atualizar();
					break;
				case 4:
					CadastroDAO.deletar();
					break;
				case 5: 
					fim = InteracaoUsu.receberString("Finalizar programa? [sim/nao]");
					break;
				default:
					InteracaoUsu.mostrarTexto("Opcao invalida.");
			}
		}

		/*Pessoa pes = new Pessoa();

		String nome = System.console().readLine();

		pes.setNome(nome);

		System.out.println("Nome: "+pes.getNome());*/
	}
}