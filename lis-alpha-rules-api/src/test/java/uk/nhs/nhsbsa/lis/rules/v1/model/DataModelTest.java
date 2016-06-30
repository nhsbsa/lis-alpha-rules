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
	
	ObjectMapper jackson = new ObjectMapper();
	
	@Before
	public void setup() {
		jackson.enable(SerializationFeature.INDENT_OUTPUT);
	}
	
	@Test
	public void testAddress(){
		System.out.println("testAddress:");
		BillPersonaTestData billPersonaTestData=new BillPersonaTestData();
		//TODO assertTrue(billPersonaTestData.testAddress.getAddressLine1().equals(billPersonaTestData.addressLine1));

		assertEquals(billPersonaTestData.testAddress.getHouseNameNumber(), "1");
		assertEquals(billPersonaTestData.testAddress.getPostcode(),"NE33 5TY");
		System.out.println("String Method");
		System.out.println(billPersonaTestData.testAddress);
	}
	
	@Test
	public void testNINO(){
		System.out.println("testNINO:");
		// NINO with spaces
		BillPersonaTestData billPersonaTestData=new BillPersonaTestData();
		billPersonaTestData.testNino = "NX963313B";
		assertTrue(isValidNINO(billPersonaTestData.testNino));
		
		// NINO without spaces
		billPersonaTestData.testNino = "NX963313B";
		assertTrue(isValidNINO(billPersonaTestData.testNino));
		
		// Invalid NINO
		billPersonaTestData.testNino = "N123456N";
		assertFalse(isValidNINO(billPersonaTestData.testNino));
		
		System.out.println("String Method");
		System.out.println(billPersonaTestData.testNino);
	}
	
	@Test
	public void testIncome(){
		BillPersonaTestData billPersonaTestData=new BillPersonaTestData();
		System.out.println("testIncome:");
		System.out.println("String Method");
		System.out.println(billPersonaTestData.testIncomes.get(0));
	}
	
	@Test
	public void testBenefit(){
		BillPersonaTestData billPersonaTestData=new BillPersonaTestData();
		System.out.println("testBenefit:");
		System.out.println("String Method");
		System.out.println(billPersonaTestData.testBenefits.get(0));
	}
	
	@Test
	public void testOutgoings(){
		BillPersonaTestData billPersonaTestData=new BillPersonaTestData();
		System.out.println("testOutgoings:");
		System.out.println("String Method");
		System.out.println(billPersonaTestData.testOutgoings.get(0));
	}
	
	@Test
	public void testBillPersona() throws JsonProcessingException{
		BillPersonaTestData billPersonaTestData=new BillPersonaTestData();
		assertTrue(billPersonaTestData.testPerson.getNino().equals(billPersonaTestData.personNino));
		assertTrue(billPersonaTestData.testPerson.getDob().equals(LocalDate.parse("1946-02-01")));
		assertTrue(billPersonaTestData.testPerson.getName().equals(billPersonaTestData.testName));
		assertTrue(billPersonaTestData.testPerson.getType().equals(PersonType.MAIN_APPLICANT));
		assertTrue(billPersonaTestData.testPerson.getBenefits().equals(billPersonaTestData.testBenefits));
		assertTrue(billPersonaTestData.testPerson.getOutgoings().equals(billPersonaTestData.testOutgoings));
		assertTrue(billPersonaTestData.testPerson.getIncomes().equals(billPersonaTestData.testIncomes));
		
		System.out.println("testBillPersona:");
		System.out.println("String Method");
		System.out.println(billPersonaTestData.testPerson);
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
