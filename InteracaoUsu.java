public class InteracaoUsu {
	
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

	public static String receberData(String txt) {
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
		
		return dd+"/"+mm+"/"+aa;
	}
}