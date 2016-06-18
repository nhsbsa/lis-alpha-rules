package uk.nhs.nhsbsa.lis.rules.v1.model;

import static org.junit.Assert.*;

import java.text.ParseException;

import org.junit.Test;



import uk.nhs.nhsbsa.lis.rules.v1.model.PersonType;

public class DataModelTest {
	
	BillPersonaTestData testData;
	
	@Test
	public void testAddress(){
		System.out.println("testAddress:");
		assertSame(BillPersonaTestData.testAddress.getHouseNameNumber(),"1");
		assertSame(BillPersonaTestData.testAddress.getPostcode(),"NE33 5TY");
		assertSame(BillPersonaTestData.testAddress.getAddressLines(),BillPersonaTestData.addressLines);
		System.out.println("String Method");
		System.out.println(BillPersonaTestData.testAddress);
		System.out.println("JSON String Method");
		System.out.println(BillPersonaTestData.testAddress.toJSONString());
	}
	
	@Test
	public void testNINO(){
		System.out.println("testNINO:");
		// NINO with spaces
		BillPersonaTestData.testNino.setNINO("NX 96 22 13 B");
		assertTrue(BillPersonaTestData.testNino.isValidNINO());
		
		// NINO without spaces
		BillPersonaTestData.testNino.setNINO("NX962213B");
		assertTrue(BillPersonaTestData.testNino.isValidNINO());
		
		// Invalid NINO
		BillPersonaTestData.testNino.setNINO("N123456N");
		assertFalse(BillPersonaTestData.testNino.isValidNINO());
		
		System.out.println("String Method");
		System.out.println(BillPersonaTestData.testNino);
		System.out.println("JSON String Method");
		System.out.println(BillPersonaTestData.testNino.toJSONString());
	}
	
	@Test
	public void testIncome(){
		System.out.println("testIncome:");
		System.out.println("String Method");
		System.out.println(BillPersonaTestData.testIncomes.get(0));
		System.out.println("JSON String Method");
		System.out.println(BillPersonaTestData.testIncomes.get(0).toJSONString());
	}
	
	@Test
	public void testBenefit(){
		System.out.println("testBenefit:");
		System.out.println("String Method");
		System.out.println(BillPersonaTestData.testBenefits.get(0));
		System.out.println("JSON String Method");
		System.out.println(BillPersonaTestData.testBenefits.get(0).toJSONString());
	}
	
	@Test
	public void testOutgoings(){
		System.out.println("testOutgoings:");
		System.out.println("String Method");
		System.out.println(BillPersonaTestData.testOutgoings.get(0));
		System.out.println("JSON String Method");
		System.out.println(BillPersonaTestData.testOutgoings.get(0).toJSONString());
	}
	
	@Test
	public void testBillPersona(){
		assertTrue(BillPersonaTestData.testPerson.getNino().equals(BillPersonaTestData.personNino));
		try {
			assertTrue(BillPersonaTestData.testPerson.getDob().equals(BillPersonaTestData.dateFormat.parse("01/02/1946")));
		} catch (ParseException e) {
			// Catch null pointers or invalid date
			e.printStackTrace();
			assertTrue(false);
		}
		assertSame(BillPersonaTestData.testPerson.getName(),BillPersonaTestData.testName);
		assertSame(BillPersonaTestData.testPerson.getType(),PersonType.MAIN_APPLICANT);
		assertSame(BillPersonaTestData.testPerson.getBenefits(),BillPersonaTestData.testBenefits);
		assertSame(BillPersonaTestData.testPerson.getOutgoings(),BillPersonaTestData.testOutgoings);
		assertSame(BillPersonaTestData.testPerson.getIncomes(),BillPersonaTestData.testIncomes);
		
		System.out.println("testBillPersona:");
		System.out.println("String Method");
		System.out.println(BillPersonaTestData.testPerson);
		System.out.println("JSON String Method");
		System.out.println(BillPersonaTestData.testPerson.toJSONString());
	}
}
