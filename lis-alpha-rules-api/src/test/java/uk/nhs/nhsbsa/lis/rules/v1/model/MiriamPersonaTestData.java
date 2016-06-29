package uk.nhs.nhsbsa.lis.rules.v1.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class MiriamPersonaTestData {
	
	// test data
	public Address testAddress;
	public String personNino;
	public String personNino2;
	public String addressLine1;
	public String addressLine2;
	public String addressLine3;
	public Person testPerson;
	public Person testPerson2;
	public Name testName;
	public Name testName2;
	public List<Income> testIncomes;
	public List<Benefit> testBenefits;
	public List<Outgoing> testOutgoings;
	
	// son
	public List<Income> testIncomes2;
	public List<Benefit> testBenefits2;
	public List<Outgoing> testOutgoings2;
	
	public ContactDetails contactDetails;
	
	/**
	 * Not very efficient - but allows values to be changed
	 */
	public MiriamPersonaTestData(){
		createAddress();
		createMiriamName();
		createMiriamSonName();
		createIncomeAndExpenditure();
		createMiriamPersona();
		createMiriamSonPersona();
	}
			
	private void createAddress(){
		testAddress=new Address();
		testAddress.setHouseNameNumber("42");
		testAddress.setAddressLine1("Station Road");
		testAddress.setAddressLine2("Winbledon");
		testAddress.setAddressLine3("London");
		testAddress.setPostcode("LN5 4RT");
		
		contactDetails=new ContactDetails();
		contactDetails.setEmailAddress("MiriamJonesPersona@noname.com");
		contactDetails.setTelephoneNumber("02341 657890");
		contactDetails.setMobileNumber("0798 1234560");
		contactDetails.setPreferredContactValue("0798 1234560");
	}
	
	private void createMiriamName(){
		testName=new Name();
		testName.setTitle("Mrs");
		testName.setForenames("Miriam");
		testName.setSurname("Jones");
	}
	
	private void createMiriamSonName(){
		testName2=new Name();
		testName2.setTitle("Mr");
		testName2.setForenames("Thomas");
		testName2.setSurname("Jones");
	}
	
	private void createIncomeAndExpenditure(){
		testIncomes=new ArrayList<Income>();
		Income testIncome=new Income();
		testIncome.setState(ValueState.SET);
		testIncome.setType(IncomeType.OCC_PENSION);
		testIncome.setIncomeValue("50");
		testIncome.setMoneyPeriod(MoneyPeriod.weekly);
		testIncomes.add(testIncome);
		
		testBenefits=new ArrayList<Benefit>();
		Benefit testBenefit=new Benefit();
		testBenefit.setState(ValueState.SET);
		testBenefit.setType(BenefitType.RETIREMENT_PENSION);
		testBenefit.setValue("119.30");
		testBenefit.setMoneyPeriod(MoneyPeriod.weekly);
		testBenefits.add(testBenefit);
		
		testOutgoings=new ArrayList<Outgoing>();
		Outgoing testOutgoing=new Outgoing();
		testOutgoing.setState(ValueState.SET);
		testOutgoing.setType(OutgoingType.COMMUNITY_CHARGE);
		testOutgoing.setValue("40");
		testOutgoing.setMoneyPeriod(MoneyPeriod.weekly);
		testOutgoings.add(testOutgoing);
		
		testOutgoing=new Outgoing();
		testOutgoing.setState(ValueState.SET);
		testOutgoing.setType(OutgoingType.MORTGAGE);
		testOutgoing.setValue("175");
		testOutgoing.setMoneyPeriod(MoneyPeriod.monthly);
		testOutgoings.add(testOutgoing);
		
		// son
		testIncomes2=new ArrayList<Income>();
		testIncome=new Income();
		testIncome.setState(ValueState.SET);
		testIncome.setType(IncomeType.EARNS);
		testIncome.setIncomeValue("1600");
		testIncome.setMoneyPeriod(MoneyPeriod.monthly);
		testIncomes2.add(testIncome);
		
		testOutgoings2=new ArrayList<Outgoing>();
		testOutgoing=new Outgoing();
		testOutgoing.setState(ValueState.SET);
		testOutgoing.setType(OutgoingType.PENSION);
		testOutgoing.setValue("100");
		testOutgoing.setMoneyPeriod(MoneyPeriod.monthly);
		testOutgoings2.add(testOutgoing);
	}
	
	private void createMiriamPersona(){
		testPerson=new Person();
		testPerson.setDob(LocalDate.parse("1954-03-01"));
		testPerson.setName(testName);
		personNino="NX984413B";
		testPerson.setNino(personNino);
		testPerson.setType(PersonType.MAIN_APPLICANT);
		testPerson.setIncomes(testIncomes);
		testPerson.setBenefits(testBenefits);
		testPerson.setOutgoings(testOutgoings);
	}
	
	private void createMiriamSonPersona(){
		testPerson2=new Person();
		testPerson2.setDob(LocalDate.parse("1996-03-31"));
		testPerson2.setName(testName2);
		personNino2="NX 90 44 13 C";
		testPerson2.setNino(personNino2);
		testPerson2.setType(PersonType.HOUSEHOLDER);
		testPerson2.setIncomes(testIncomes2);
		testPerson2.setOutgoings(testOutgoings2);
	}


}
