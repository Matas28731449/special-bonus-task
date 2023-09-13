// palindrominės datos užduotis
import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {
	public static void main(String[] args) {
		printBonusDatesBetween(1670, 2010);
	}

	public static void printBonusDatesBetween(int fromYear, int toYear) {
		// naudoju Java kalbos klasę SimpleDateFormat su jos metodais
		SimpleDateFormat inputDateFormat = new SimpleDateFormat("yyyyMMdd");
		SimpleDateFormat outputDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();

		for(int year = fromYear; year <= toYear; year ++) {
			for(int month = 1; month <= 12; month ++) {

				int daysInMonth;
				// tikrinama ar vasario mėnuo
				if(month == 2) {
					// vasario mėnuo turi 28 d nekeliamaisiais metais
					if(year % 4 != 0 || (year % 100 == 0 && year % 400 != 0)) {
						daysInMonth = 28;
					}
					// ir 29 d keliamaisiais metais
					else {
						daysInMonth = 29;
					}
				}
				// tikrinama ar tai mėnuo, kuris turi 30 dienų
				else if(month == 4 || month == 6 || month == 9 || month == 11) {
					daysInMonth = 30;
				}
				// galutiniu atveju priskiriama 31 diena
				else {
					daysInMonth = 31;
				}

				for(int day = 1; day <= daysInMonth; day ++) {

					String dateStr = String.format("%04d%02d%02d", year, month, day);
					try {
						// išskaidoma data į date objektą (atskirai į metus, į mėnesius, į dienas)
						date = inputDateFormat.parse(dateStr);

						// sukuriama atvirkštinė data ir išskaidoma į date objektą
						String reverseDateStr = new StringBuilder(dateStr).reverse().toString();
						Date reverseDate = inputDateFormat.parse(reverseDateStr);

						// patikrinama ar data ir jos atvirkštinė data sutampa
						if(date.equals(reverseDate)) {
							System.out.println(outputDateFormat.format(date));
						}
					} catch(Exception e) {
						System.out.println("Error: Parsing error");
					}
				}
			}
		}
	}
}