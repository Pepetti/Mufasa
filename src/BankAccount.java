
public class BankAccount {
	
	String streetAddress;
	String city;
	String postalCode;
	String country;
	String password;
	String holderName;
	String cardNumber;
	String cardType;
	String expirationDate;
	
	
	public BankAccount(String streetAddress, String city, String postalCode, String country,
			String password, String holderName, String cardNumber, String cardType, String expirationDate) {
	
		this.streetAddress = streetAddress;
		this.city = city;
		this.postalCode = postalCode;
		this.country = country;
		this.password = password;
		this.holderName = holderName;
		this.cardNumber = cardNumber;
		this.cardType = cardType;
		this.expirationDate = expirationDate;
	}

}
