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
}