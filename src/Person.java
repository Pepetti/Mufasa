
public class Person {
	
	UserData userData;
	BankAccount bankAccount;
	
	public Person(UserData userData, BankAccount bankAccount) {
		this.userData = userData;
		this.bankAccount = bankAccount;
	}

	public UserData getBasicData() {
		return userData;
	}

	public BankAccount getBankingDetails() {
		return bankAccount;
	}

	public void setBasicData(UserData userData) {
		this.userData = userData;
	}

	public void setBankingDetails(BankAccount bankAccount) {
		this.bankAccount = bankAccount;
	}
}
