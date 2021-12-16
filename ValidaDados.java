import java.time.MonthDay;

public class ValidaDados {
	
	public static boolean validarData(int dia, int mes, int ano) {
		try {
			MonthDay date = MonthDay.of(mes,dia);
			return date.isValidYear(ano);
		} catch(Exception e) {
			return false;
		}
	}
}