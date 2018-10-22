
public class BankAccountAttachment {
	
	public String fullAddress(String streetAddress, String city, String postalCode, String country) throws MufasaException {
		String fullAddr;
		String strAddr = streetAddress;
		String cty = city;
		String code = postalCode;
		String cntry = country;
		
		if (!cntry.matches("[a-zA-Z]*") || !cty.matches("[a-zA-Z]*") || !code.matches("[\\-0-9]*") || !strAddr.matches("[\\sa-zA-Z0-9]*")) {
			throw new MufasaException();
		}else {
			return fullAddr = strAddr + " " + cty + " " + code + " " + cntry;
		}
	}
	
	public String createNewPassword (String password) throws MufasaException {
		String Password = password;
		if (Password.length() > 8) {
			throw new MufasaException();
		}
		else {
			return Password;
		}
	}
	
	public String createNewCard (String holderName, String cardType, String cardNumber, String expirationDate) throws MufasaException {
		String name = holderName;
		String number = cardNumber;
		String type = cardType;
		String expDate = expirationDate;
		
		if (!type.equals("VISA") && !type.equals("Mastercard") && !type.equals("Discover")) {
			throw new MufasaException();
		}
		String wholeCard = name + " " + type + " " + number + " " + expDate;
		return wholeCard;
	}
}
