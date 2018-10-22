
public class Mufasa {
			
		public Person createAccount (UserData userData) throws MufasaException {
			Person account = new Person(userData, null);
			return account;
		}
		
		public Person createBankAccount(Person p, BankAccount bankAccount) throws MufasaException {
			p.bankAccount = bankAccount;
			return p;
		}
		
		public boolean refund(Bank bank, Person person) {
			if(!bank.refundToAccount(person.bankAccount)) {
				return false;
			}
			return true;
		}
		
}
