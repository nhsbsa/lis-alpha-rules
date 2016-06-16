package uk.nhs.nhsbsa.lis.rules.v1.builder;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import org.junit.Test;

import uk.nhs.nhsbsa.lis.rules.v1.model.Address;
import uk.nhs.nhsbsa.lis.rules.v1.model.Benefit;
import uk.nhs.nhsbsa.lis.rules.v1.model.BenefitType;
import uk.nhs.nhsbsa.lis.rules.v1.model.Income;
import uk.nhs.nhsbsa.lis.rules.v1.model.Name;
import uk.nhs.nhsbsa.lis.rules.v1.model.NationalInsuranceNo;
import uk.nhs.nhsbsa.lis.rules.v1.model.Outgoing;
import uk.nhs.nhsbsa.lis.rules.v1.model.OutgoingType;
import uk.nhs.nhsbsa.lis.rules.v1.model.Person;
import uk.nhs.nhsbsa.lis.rules.v1.model.PersonType;
import uk.nhs.nhsbsa.lis.rules.v1.model.ValueState;

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
	private static ArrayList<Income> testIncomes;
	private static ArrayList<Benefit> testBenefits;
	private static ArrayList<Outgoing> testOutgoings;
	
	/** create test data **/
	static{
		dateFormat=new SimpleDateFormat("dd/mm/yyyy");
		createAddress();
		createNINO();
		createBillName();
		createBillIncomeAndExpenditure();
		createBillPersona();
	}
	
	private static void createAddress(){
		testAddress=new Address();
		testAddress.setHouseNameNumber("1");
		addressLines=new ArrayList<String>();
		addressLines.add("22 Accacia Avenue");
		addressLines.add("New Hamlington");
		addressLines.add("Northumberland");
		testAddress.setAddressLines(addressLines);
		testAddress.setPostcode("NE33 5TY");
	}
	
	private static void createNINO(){
		testNino=new NationalInsuranceNo("NX 96 22 13 B");
		personNino=new NationalInsuranceNo("NX 96 22 13 B");
	}
	
	private static void createBillName(){
		testName=new Name();
		testName.setTitle("Mr");
		testName.setForenames("Bill");
		testName.setForenames("Smith");
	}
	
	private static void createBillIncomeAndExpenditure(){
		testIncomes=new ArrayList<Income>();
		
		testBenefits=new ArrayList<Benefit>();
		
		Benefit testBenefit=new Benefit();
		testBenefit.setBenefitState(ValueState.SET);
		testBenefit.setBenefitType(BenefitType.RP);
		testBenefit.setBenefitValue("100");
		testBenefits.add(testBenefit);
		
		testOutgoings=new ArrayList<Outgoing>();
		Outgoing testOutgoing1=new Outgoing();
		testOutgoing1.setOutgoingState(ValueState.SET);
		testOutgoing1.setOutgoingType(OutgoingType.CommunityCharge);
		testOutgoing1.setOutgoingValue("20");
		
		Outgoing testOutgoing2=new Outgoing();
		testOutgoing2.setOutgoingState(ValueState.SET);
		testOutgoing2.setOutgoingType(OutgoingType.Rent);
		testOutgoing2.setOutgoingValue("60");
		
		testOutgoings.add(testOutgoing1);
		testOutgoings.add(testOutgoing2);
		
	}	
	
	private static void createBillPersona(){
		testPerson=new Person();
		try {
			testPerson.setDob(dateFormat.parse("01/02/1946"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		testPerson.setName(testName);
		
		testPerson.setNino(personNino);
		testPerson.setType(PersonType.MAIN_APPLICANT);
		testPerson.setIncomes(testIncomes);
		testPerson.setBenefits(testBenefits);
		testPerson.setOutgoings(testOutgoings);
	}
	
	/** End Create Test Data **/
	
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
	public void testBillPersona(){
		assertTrue(testPerson.getNino().equals(personNino));
		try {
			assertTrue(testPerson.getDob().equals(dateFormat.parse("01/02/1946")));
		} catch (ParseException e) {
			// Catch null pointers or invalid date
			e.printStackTrace();
			assertTrue(false);
		}
		assertTrue(testPerson.getName().equals(testName));
		assertTrue(testPerson.getType().equals(PersonType.MAIN_APPLICANT));
		System.out.println(testPerson);
	}
}
