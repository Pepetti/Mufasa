import static org.junit.Assert.*;

import java.text.ParseException;
import org.easymock.EasyMock;

import org.junit.Before;
import org.junit.Test;

public class MufasaTest {
	
	Mufasa mufasa;
	Bank bank;
	BankAccount validBankAccount;
	UserData validUserData;
	BankAccount invalidBankAccount;
	UserData invalidUserData;

	@Before
	public void initialize() throws Exception {
		mufasa = new Mufasa();
		validBankAccount = new BankAccount ("Merikoskentie7", "Oulu", "90520", "Finland", "KissinPissiJokaNurkassaHiihti", "Teppo Tulppa", "20020020202020", "VISA", "02/18" );
		validUserData = new UserData("Teppo", "Tulppa", "TeppoTulppa", "KissaJonkaNimiOliSaapas", "KissaJonkaNimiOliSaapas", "24/10/2000", 044222222, "teppo@gmail.com", "teppo@gmail.com");
		invalidBankAccount = new BankAccount("Merikoskentie7", "Oulu", "90520", "Finland", "KissinPissiJokaNurkassaHiihti", "Teppo Tulppa", "20020020202020", "VISTA", "02/18" );
		invalidUserData = new UserData("Teppo", "Tulppa", "TeppoTulppa", "KissaJonkaNimiOliSaapas", "KissaJonkaNimiOliSaapas23", "24/10/2000", 044222222, "teppo@gmail.com", "teppo@gmail.com");

	}

	BasicDataCollection data = new BasicDataCollection();
	BankAccountAttachment accountAttachment = new BankAccountAttachment();

	@Test (expected = MufasaException.class)
	public void testFirstAndLastName() throws MufasaException{
		//should cause an exception
		data.createFirstAndLastName("Åke", "Lindemann");
	}
	
	@Test (expected = MufasaException.class)
	public void testUserName() throws MufasaException{
		//should cause an exception
		data.createUserName("Åke_Lindemann");
	}
	
	@Test 
	public void testUserName2() throws MufasaException{
		String result = data.createUserName("OokeLindemann");
		String userName = ("OokeLindemann");
		assertEquals(result, userName);
	}
	
	@Test (expected = MufasaException.class)
	public void testPassword() throws MufasaException{
		//should cause an exception
		data.createPassword("ASDASDASD", "ASDASDAS2");
	}
	
	@Test
	public void testPassword2() throws MufasaException{
		String result = data.createPassword("ASDASDASD", "ASDASDASD");
		String password = "ASDASDASD";
		assertEquals(result, password);
		
	}
	
	@Test
	public void testBirthDay() throws MufasaException, ParseException{
		int result = data.createBirthDay("10/06/2000");
		int age = 18;
		assertEquals(result, age);
		
	}
	@Test (expected = MufasaException.class)
	public void testBirthDay2() throws MufasaException, ParseException{
		//should cause an exception
		data.createBirthDay("10/06/2002");
	}
	@Test 
	public void testAddress() throws MufasaException{
		String result = accountAttachment.fullAddress("Kaarnakuja 99", "Kalajoki", "-85100", "Finland");
		String password = "Kaarnakuja 99 Kalajoki -85100 Finland";
		assertEquals(result, password);
	}
	
	@Test (expected = MufasaException.class)
	public void testAddress2() throws MufasaException{
		//Should cause an exception
		accountAttachment.fullAddress("Kaarnakuja 99", "Kalajoki", "ABCDE", "Finland");

	}
	
	@Test
	public void testCard() throws MufasaException{
		String result = accountAttachment.createNewCard("Tauno Toppo", "VISA", "08232131231233", "08/18");
		String card = "Tauno Toppo VISA 08232131231233 08/18";
		assertEquals(result, card);
	}
	
	@Test (expected = MufasaException.class)
 	public void testCard2() throws MufasaException{
		//Should cause an exception
		accountAttachment.createNewCard("Tauno Toppo", "?", "08232131231233", "08/18");
	}
	
	@Test
	public void refundSuccess() {

		Person person = new Person(validUserData, validBankAccount);
		bank = EasyMock.createMock(Bank.class);

		EasyMock.expect(bank.refundToAccount(validBankAccount)).andReturn(true);
		EasyMock.replay(bank);
										
		assertEquals(true, mufasa.refund(bank, person));
	}
	
	@Test
	public void refundFailure() {
		Person person = new Person(validUserData, validBankAccount);
		bank = EasyMock.createMock(Bank.class);
										
		EasyMock.expect(bank.refundToAccount(validBankAccount)).andReturn(false);
		EasyMock.replay(bank);

		assertEquals(false, mufasa.refund(bank, person));
	}
	
}
