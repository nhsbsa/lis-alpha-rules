package uk.nhs.nhsbsa.lis.rules.v1.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.time.LocalDate;
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
		assertEquals(BillPersonaTestData.testAddress.getHouseNameNumber(), "1");
		assertTrue(BillPersonaTestData.testAddress.getPostcode().equals("NE33 5TY"));
		//TODO assertTrue(BillPersonaTestData.testAddress.getAddressLine1().equals(BillPersonaTestData.addressLine1));
		System.out.println("String Method");
		System.out.println(BillPersonaTestData.testAddress);
	}
	
	@Test
	public void testNINO(){
		System.out.println("testNINO:");
		// NINO with spaces
		BillPersonaTestData.testNino = "NX963313B";
		assertTrue(isValidNINO(BillPersonaTestData.testNino));
		
		// NINO without spaces
		BillPersonaTestData.testNino = "NX963313B";
		assertTrue(isValidNINO(BillPersonaTestData.testNino));
		
		// Invalid NINO
		BillPersonaTestData.testNino = "N123456N";
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
		assertTrue(BillPersonaTestData.testPerson.getDob().equals(LocalDate.parse("1946-02-01")));
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
	public boolean isValidNINO(String nino){
		String NINOPattern = "^\\s*[a-zA-Z]{2}(?:\\s*\\d\\s*){6}[a-zA-Z]?\\s*$";

	    // Create a Pattern object
		if(nino==null||nino.length()==0){ return false;}
		try{
			Pattern pattern = Pattern.compile(NINOPattern);
			Matcher m = pattern.matcher(nino);
			return m.matches();
		}catch(PatternSyntaxException pe){
			return false;
		}
		
	}
}
