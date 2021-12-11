public class Principal {
	
	public static void main (String args[]) {
		Pessoa pes = new Pessoa();

		String nome = System.console().readLine();

		pes.setNome(nome);

		System.out.println("Nome: "+pes.getNome());
	}
}