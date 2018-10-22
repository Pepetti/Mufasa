import java.text.ParseException;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class BasicDataCollection {
	
	public String createFirstAndLastName(String fname, String lname) throws MufasaException {
		String FirstName = fname;
		String LastName = lname;
		if (!FirstName.equals("[a-zA-Z+]") || !LastName.equals("[a-zA-Z+]")) {
			throw new MufasaException();
		}
		String wholeName = FirstName + " " + LastName;
		return wholeName;
	}
	
	public String createUserName (String userName) throws MufasaException {
		String UserName = userName;
		if (UserName.length() > 15) {
			throw new MufasaException();
		}
		else if (UserName.indexOf("_", UserName.indexOf("_") + 1) != -1) {
			throw new MufasaException();
		}
		else if (!UserName.matches("[a-zA-Z]*")) {
			throw new MufasaException();
		}else {
			return UserName;
		}
	}
	
	public String createPassword (String password, String password2) throws MufasaException {
		String Password = password;
		String Password2 = password2;
		if (Password.length() < 8 || !Password2.matches(Password)) {
			throw new MufasaException();
		}else{
			return Password;
		}
	}
	
	public int createBirthDay (String birthDay) throws ParseException, MufasaException {
		int age = 0;
		
		DateTimeFormatter formatter =  DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate parsedDate = LocalDate.parse(birthDay, formatter);
		LocalDate currentDate = LocalDate.now();
		if ((birthDay != null) && (currentDate != null)) {
			age = Period.between(parsedDate, currentDate).getYears();
			if (age < 18) {
            	throw new MufasaException();
				}
			}
		return age;
	}  
	
	public int createPhoneNumber(int phoneNumber) {
		int pNumber = phoneNumber;
		return pNumber;
	}
	
	public String createEmail (String emailAddress, String emailAddress2) throws MufasaException {
		String email = emailAddress;
		String email2 = emailAddress2;
		if (!email2.matches(email)) {
			throw new MufasaException();
		}else{
			return email;
		}
	}
}