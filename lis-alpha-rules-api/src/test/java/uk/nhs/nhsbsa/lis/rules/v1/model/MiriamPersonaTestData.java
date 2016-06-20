package uk.nhs.nhsbsa.lis.rules.v1.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class MiriamPersonaTestData {
	public static SimpleDateFormat dateFormat=new SimpleDateFormat("dd/MM/yyyy");
	// test data
	public static Address testAddress;
	public static NationalInsuranceNo personNino;
	public static NationalInsuranceNo personNino2;
	public static List<String>addressLines;
	public static Person testPerson;
	public static Person testPerson2;
	public static Name testName;
	public static Name testName2;
	public static List<Income> testIncomes;
	public static List<Benefit> testBenefits;
	public static List<Outgoing> testOutgoings;
	// son
	public static List<Income> testIncomes2;
	public static List<Benefit> testBenefits2;
	public static List<Outgoing> testOutgoings2;
			
	/** create test data **/
	static{
		createAddress();
		createMiriamName();
		createMiriamSonName();
		createIncomeAndExpenditure();
		createMiriamPersona();
		createMiriamSonPersona();
	}
	
	private static void createAddress(){
		testAddress=new Address();
		testAddress.setHouseNameNumber("42");
		addressLines=new ArrayList<String>();
		addressLines.add("Station Road");
		addressLines.add("Winbledon");
		addressLines.add("London");
		testAddress.setAddressLines(addressLines);
		testAddress.setPostcode("LN5 4RT");
	}
	
	private static void createMiriamName(){
		testName=new Name();
		testName.setTitle("Mrs");
		testName.setForenames("Miriam");
		testName.setSurname("Jones");
	}
	
	private static void createMiriamSonName(){
		testName2=new Name();
		testName2.setTitle("Mr");
		testName2.setForenames("Thomas");
		testName2.setSurname("Jones");
	}
	
	private static void createIncomeAndExpenditure(){
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
		Outgoing testOutgoing1=new Outgoing();
		testOutgoing1.setState(ValueState.SET);
		testOutgoing1.setType(OutgoingType.COMMUNITY_CHARGE);
		testOutgoing1.setValue("20");
		testOutgoing1.setMoneyPeriod(MoneyPeriod.weekly);
		
		Outgoing testOutgoing2=new Outgoing();
		testOutgoing2.setState(ValueState.SET);
		testOutgoing2.setType(OutgoingType.MORTGAGE);
		testOutgoing2.setValue("175");
		testOutgoing2.setMoneyPeriod(MoneyPeriod.monthly);
		
		testOutgoings.add(testOutgoing1);
		testOutgoings.add(testOutgoing2);
		
		testIncomes2=new ArrayList<Income>();
		testIncome=new Income();
		testIncome.setState(ValueState.SET);
		testIncome.setType(IncomeType.EARNS);
		testIncome.setIncomeValue("400");
		testIncome.setMoneyPeriod(MoneyPeriod.weekly);
		testIncomes2.add(testIncome);
	}
	
	private static void createMiriamPersona(){
		testPerson=new Person();
		try {
			testPerson.setDob(dateFormat.parse("01/03/1954"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		testPerson.setName(testName);
		personNino=new NationalInsuranceNo("NX 98 44 13 B");
		testPerson.setNino(personNino);
		testPerson.setType(PersonType.MAIN_APPLICANT);
		testPerson.setIncomes(testIncomes);
		testPerson.setBenefits(testBenefits);
		testPerson.setOutgoings(testOutgoings);
	}
	
	private static void createMiriamSonPersona(){
		testPerson2=new Person();
		try {
			testPerson2.setDob(dateFormat.parse("31/03/1996"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		testPerson2.setName(testName2);
		personNino2=new NationalInsuranceNo("NX 90 44 13 C");
		testPerson2.setNino(personNino2);
		testPerson2.setType(PersonType.HOUSEHOLDER);
		testPerson2.setIncomes(testIncomes2);
	}


}
