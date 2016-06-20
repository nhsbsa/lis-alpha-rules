package uk.nhs.nhsbsa.lis.rules.v1.model;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import java.text.ParseException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

import org.junit.Before;
import org.junit.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

public class DataModelTest {
	
	BillPersonaTestData testData;
	
	ObjectMapper jackson = new ObjectMapper();
	
	@Before
	public void setup() {
		jackson.enable(SerializationFeature.INDENT_OUTPUT);
	}
	
	@Test
	public void testAddress(){
		System.out.println("testAddress:");
		assertTrue(BillPersonaTestData.testAddress.getHouseNameNumber().equals("1"));
		assertTrue(BillPersonaTestData.testAddress.getPostcode().equals("NE33 5TY"));
		assertTrue(BillPersonaTestData.testAddress.getAddressLines().equals(BillPersonaTestData.addressLines));
		System.out.println("String Method");
		System.out.println(BillPersonaTestData.testAddress);
	}
	
	@Test
	public void testNINO(){
		System.out.println("testNINO:");
		// NINO with spaces
		BillPersonaTestData.testNino.setNINO("NX 96 33 13 B");
		assertTrue(isValidNINO(BillPersonaTestData.testNino));
		
		// NINO without spaces
		BillPersonaTestData.testNino.setNINO("NX963313B");
		assertTrue(isValidNINO(BillPersonaTestData.testNino));
		
		// Invalid NINO
		BillPersonaTestData.testNino.setNINO("N123456N");
		assertFalse(isValidNINO(BillPersonaTestData.testNino));
		
		System.out.println("String Method");
		System.out.println(BillPersonaTestData.testNino);
	}
	
	@Test
	public void testIncome(){
		System.out.println("testIncome:");
		System.out.println("String Method");
		System.out.println(BillPersonaTestData.testIncomes.get(0));
	}
	
	@Test
	public void testBenefit(){
		System.out.println("testBenefit:");
		System.out.println("String Method");
		System.out.println(BillPersonaTestData.testBenefits.get(0));
	}
	
	@Test
	public void testOutgoings(){
		System.out.println("testOutgoings:");
		System.out.println("String Method");
		System.out.println(BillPersonaTestData.testOutgoings.get(0));
	}
	
	@Test
	public void testBillPersona() throws JsonProcessingException{
		assertTrue(BillPersonaTestData.testPerson.getNino().equals(BillPersonaTestData.personNino));
		try {
			assertTrue(BillPersonaTestData.testPerson.getDob().equals(BillPersonaTestData.dateFormat.parse("01/02/1946")));
		} catch (ParseException e) {
			// Catch null pointers or invalid date
			e.printStackTrace();
			assertTrue(false);
		}
		assertTrue(BillPersonaTestData.testPerson.getName().equals(BillPersonaTestData.testName));
		assertTrue(BillPersonaTestData.testPerson.getType().equals(PersonType.MAIN_APPLICANT));
		assertTrue(BillPersonaTestData.testPerson.getBenefits().equals(BillPersonaTestData.testBenefits));
		assertTrue(BillPersonaTestData.testPerson.getOutgoings().equals(BillPersonaTestData.testOutgoings));
		assertTrue(BillPersonaTestData.testPerson.getIncomes().equals(BillPersonaTestData.testIncomes));
		
		System.out.println("testBillPersona:");
		System.out.println("String Method");
		System.out.println(BillPersonaTestData.testPerson);
	}
	
	/**
	 * TODO find a better place for this
	 * @return
	 */
	public boolean isValidNINO(NationalInsuranceNo nino){
		String NINOPattern = "^\\s*[a-zA-Z]{2}(?:\\s*\\d\\s*){6}[a-zA-Z]?\\s*$";

	    // Create a Pattern object
		if(nino.getNINO()==null||nino.getNINO().length()==0){ return false;}
		try{
			Pattern pattern = Pattern.compile(NINOPattern);
			Matcher m = pattern.matcher(nino.getNINO());
			return m.matches();
		}catch(PatternSyntaxException pe){
			return false;
		}
		
	}
}
