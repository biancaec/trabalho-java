import java.time.MonthDay;
import java.util.regex.*;

public class ValidaDados {
	
	public static boolean validarData(int dia, int mes, int ano) {
		try {
			MonthDay date = MonthDay.of(mes,dia);
			return date.isValidYear(ano);
		} catch(Exception e) {
			return false;
		}
	}

	public static boolean validarTele(String tel) {
		Pattern p = Pattern.compile("[0-9]+");
		Matcher m = p.matcher(tel);
		if (m.matches()) {
			int len = m.group().length();
			if(len > 11 || len < 9) {
				return false;
			}
			return true;
		}

		return false;
	}
}