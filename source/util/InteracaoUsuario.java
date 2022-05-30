package util;

import java.time.LocalDate;

public class InteracaoUsuario {
	
	public static int receberInt(String txt) {
		System.out.println(txt);
		String num = System.console().readLine();
		int inum = Integer.parseInt(num);
		return inum;
	}

	public static float receberFloat(String txt) {
		System.out.println(txt);
		String num = System.console().readLine();
		float fnum = Float.parseFloat(num);
		return fnum;
	}	

	public static String receberString(String txt) {
		System.out.println(txt);
		String rtxt = System.console().readLine();
		return rtxt;
	} 

	public static void mostrarTexto(String txt) {
		System.out.println(txt);
	}

	public static LocalDate receberData(String txt) {
		boolean ok;
		int dd;
		int mm;
		int aa;
		do {
			System.out.println(txt);
			dd = receberInt("Dia:");
			mm = receberInt("Mes:");
			aa = receberInt("Ano:");
			ok = ValidaDados.validarData(dd,mm,aa);
			if (ok==false) {
				mostrarTexto("Data invalida.");
			}
		}while(ok==false);
		
		return LocalDate.of(aa,mm,dd);
	}

	public static String receberTelefone(String txt) {
		boolean ok;
		String telefone;
		do {
			telefone = receberString(txt);
			ok = ValidaDados.validarTelefone(telefone);
			if (ok==false) {
				mostrarTexto("Telefone invalido.");
			}
		}while(ok==false);

		if (telefone.length() == 9) {
			return telefone.substring(0,1)
					+" "+telefone.substring(1,5)
					+" "+telefone.substring(5);
		}else {
			return telefone.substring(0,2)
					+" "+telefone.substring(2,3)
					+" "+telefone.substring(3,7)
					+" "+telefone.substring(7);
		}

	}
}