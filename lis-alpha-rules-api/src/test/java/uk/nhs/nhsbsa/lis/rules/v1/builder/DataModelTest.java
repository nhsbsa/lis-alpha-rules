package uk.nhs.nhsbsa.lis.rules.v1.builder;

import static org.junit.Assert.*;

import java.text.ParseException;

import org.junit.Test;

import uk.nhs.nhsbsa.lis.rules.v1.model.PersonType;

public class DataModelTest {
	
	TestData testData;
	
	/** End Create Test Data **/
	
	@Test
	public void testAddress(){
		assertSame(TestData.testAddress.getHouseNameNumber(),"1");
		assertSame(TestData.testAddress.getPostcode(),"NE33 5TY");
		assertSame(TestData.testAddress.getAddressLines(),TestData.addressLines);
		System.out.println(TestData.testAddress);
	}
	
	@Test
	public void testNINO(){
		// NINO with spaces
		TestData.testNino.setNINO("NX 96 22 13 B");
		assertTrue(TestData.testNino.isValidNINO());
		
		// NINO without spaces
		TestData.testNino.setNINO("NX962213B");
		assertTrue(TestData.testNino.isValidNINO());
		
		// Invalid NINO
		TestData.testNino.setNINO("N123456N");
		assertFalse(TestData.testNino.isValidNINO());
	}
	
	@Test
	public void testBillPersona(){
		assertTrue(TestData.testPerson.getNino().equals(TestData.personNino));
		try {
			assertTrue(TestData.testPerson.getDob().equals(TestData.dateFormat.parse("01/02/1946")));
		} catch (ParseException e) {
			// Catch null pointers or invalid date
			e.printStackTrace();
			assertTrue(false);
		}
		assertTrue(TestData.testPerson.getName().equals(TestData.testName));
		assertTrue(TestData.testPerson.getType().equals(PersonType.MAIN_APPLICANT));
		assertTrue(TestData.testPerson.getBenefits().equals(TestData.testBenefits));
		assertTrue(TestData.testPerson.getOutgoings().equals(TestData.testOutgoings));
		assertTrue(TestData.testPerson.getIncomes().equals(TestData.testIncomes));
		System.out.println(TestData.testPerson);
	}
}
