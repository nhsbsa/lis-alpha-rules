package uk.nhs.nhsbsa.lis.rules.v1.builder;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import org.junit.Test;

import uk.nhs.nhsbsa.lis.rules.v1.model.Address;
import uk.nhs.nhsbsa.lis.rules.v1.model.Name;
import uk.nhs.nhsbsa.lis.rules.v1.model.NationalInsuranceNo;
import uk.nhs.nhsbsa.lis.rules.v1.model.Person;
import uk.nhs.nhsbsa.lis.rules.v1.model.PersonType;

public class DataModelTest {
	// date format to use in testing
	private static SimpleDateFormat dateFormat;
	// test data
	private static Address testAddress;
	private static NationalInsuranceNo personNino;
	private static NationalInsuranceNo testNino;
	private static ArrayList<String>addressLines;
	private static Person testPerson;
	private static Name testName;
	
	// create some test data
	static{
		dateFormat=new SimpleDateFormat("dd/mm/yyyy");
		testAddress=new Address();
		testAddress.setHouseNameNumber("1");
		addressLines=new ArrayList<String>();
		addressLines.add("22 Accacia Avenue");
		addressLines.add("New Hamlington");
		addressLines.add("Northumberland");
		testAddress.setAddressLines(addressLines);
		testAddress.setPostcode("NE33 5TY");
		
		testNino=new NationalInsuranceNo("NX 96 22 13 B");
		personNino=new NationalInsuranceNo("NX 96 22 13 B");
		
		testName=new Name();
		testName.setTitle("Mr");
		testName.setForenames("John");
		testName.setForenames("Smith");
		
		testPerson=new Person();
		try {
			testPerson.setDob(dateFormat.parse("01/02/1940"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		testPerson.setName(testName);
		
		testPerson.setNino(personNino);
		testPerson.setType(PersonType.MAIN_APPLICANT);
	}
	
	@Test
	public void testAddress(){
		assertSame(DataModelTest.testAddress.getHouseNameNumber(),"1");
		assertSame(DataModelTest.testAddress.getPostcode(),"NE33 5TY");
		assertSame(DataModelTest.testAddress.getAddressLines(),addressLines);
	}
	
	@Test
	public void testNINO(){
		// NINO with spaces
		testNino.setNINO("NX 96 22 13 B");
		assertTrue(testNino.isValidNINO());
		
		// NINO without spaces
		testNino.setNINO("NX962213B");
		assertTrue(testNino.isValidNINO());
		
		// Invalid NINO
		testNino.setNINO("N123456N");
		assertFalse(testNino.isValidNINO());
	}
	
	@Test
	public void testPerson(){
		assertTrue(testPerson.getNino().equals(personNino));
		try {
			assertTrue(testPerson.getDob().equals(dateFormat.parse("01/02/1940")));
		} catch (ParseException e) {
			// Catch null pointers or invalid date
			e.printStackTrace();
			assertTrue(false);
		}
		assertTrue(testPerson.getName().equals(testName));
		assertTrue(testPerson.getType().equals(PersonType.MAIN_APPLICANT));
	}
}
