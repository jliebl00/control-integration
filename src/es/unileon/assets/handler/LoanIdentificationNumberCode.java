package es.unileon.assets.handler;

import java.util.Calendar;
import java.util.Locale;
import java.util.Random;

public class LoanIdentificationNumberCode {

	/**
	 * It's the type of Loan, Mortgage, etc Length 2 characters (letters).
	 */
	private String type;

	/**
	 * Date format MMYYYY
	 */
	private String date;

	/**
	 * It's the country code
	 */
	private String countryCode;

	/**
	 * Letters "I" or "O" will not be used in the assignment. It's a random
	 * alphanumeric string.
	 */
	private String randomCharacters;

	/**
	 * ¿?
	 */
	private int checkDigit;

	public static final String alphanumericCharsAllowed = "0123456789ABCDEFGHJKLMNPQRSTUVWXYZ";
	public enum PermittedTypes{ LN, MG}; //permitted types
	
	
	/**
	 * A el constructor se le pasa el tipo, si es un credito o un prestamo,
	 * y el codigo del pais.
	 * 
	 * @param type
	 * @param countryCode
	 * @throws MalformedExceptionLINC
	 */
	public LoanIdentificationNumberCode(String type, String countryCode)
			throws MalformedExceptionLINC {
		
		StringBuffer error = new StringBuffer();
		
		boolean countryCodeExist = false;
		String[] countries = Locale.getISOCountries();
		for (String country : countries) {
			if (country.equals(countryCode)) {
				countryCodeExist = true;
			}
		}

		if (!countryCodeExist) {
			error.append("Country code not exist.\n");
		}
		
		boolean typeExist = false;
		PermittedTypes[] types = PermittedTypes.values();
		for(PermittedTypes permittedType : types) {
			if(permittedType.toString().equals(type)) {
				typeExist = true;
			}
		}
		
		if (!typeExist) {
			error.append("Type not exist.\n");
		}
		
		if(error.length() > 0){
			throw new MalformedExceptionLINC(error.toString());
		}
		
		this.type = type;
		this.date = String.valueOf(Calendar.getInstance().get(Calendar.MONTH))
				+ String.valueOf(Calendar.getInstance().get(Calendar.YEAR));
		
		this.countryCode = countryCode;
		this.randomCharacters = randomCharacters(5);
		this.checkDigit = doCheckDigit(this.type + this.date + this.countryCode +this.randomCharacters);
	}
	
	/**
	 * Método que devuelve una cadena alfanumerica 
	 * de caracteres de la longitud indicada
	 * @param len
	 * @return
	 */
	public String randomCharacters(int len) {
		Random rnd = new Random();
		StringBuilder sb = new StringBuilder(len);

		for (int i = 0; i < len; i++) {
			sb.append(alphanumericCharsAllowed.charAt(rnd.nextInt(alphanumericCharsAllowed.length())));
		}

		return sb.toString();
	}
	
	/**
	 * Método emleado para calcular el digito de control
	 * @param code
	 * @return digito de control
	 */
	public int doCheckDigit(String code) {
		char[] characters = code.toCharArray();
		int sum = 0;
		
		for(char character : characters){
			try{
				int num = Integer.parseInt(String.valueOf(character));			
				sum = sum + num;
			}catch(NumberFormatException ex){
				int num = Character.valueOf(character);
				sum = sum + num;
			}
		}
		
		return sum%9;
	}
	
	public String getType() {
		return type;
	}
	
	public void setType(String type) {
		this.type = type;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public String getRandomCharacters() {
		return randomCharacters;
	}

	public void setRandomCharacters(String randomCharacters) {
		this.randomCharacters = randomCharacters;
	}

	public int getCheckDigit() {
		return checkDigit;
	}

	public void setCheckDigit(int checkDigit) {
		this.checkDigit = checkDigit;
	}

	@Override
	public String toString() {
		return this.type + "-" + this.date + "-" + this.countryCode + "-" + this.randomCharacters + "-" + this.checkDigit;
	}
}
