package uk.nhs.nhsbsa.lis.rules.v1.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import uk.nhs.nhsbsa.lis.rules.v1.model.Address;
import uk.nhs.nhsbsa.lis.rules.v1.model.Benefit;
import uk.nhs.nhsbsa.lis.rules.v1.model.BenefitType;
import uk.nhs.nhsbsa.lis.rules.v1.model.Income;
import uk.nhs.nhsbsa.lis.rules.v1.model.IncomeType;
import uk.nhs.nhsbsa.lis.rules.v1.model.MoneyPeriod;
import uk.nhs.nhsbsa.lis.rules.v1.model.Name;
import uk.nhs.nhsbsa.lis.rules.v1.model.NationalInsuranceNo;
import uk.nhs.nhsbsa.lis.rules.v1.model.Outgoing;
import uk.nhs.nhsbsa.lis.rules.v1.model.OutgoingType;
import uk.nhs.nhsbsa.lis.rules.v1.model.Person;
import uk.nhs.nhsbsa.lis.rules.v1.model.PersonType;
import uk.nhs.nhsbsa.lis.rules.v1.model.ValueState;

public class BillPersonaTestData {
		public static SimpleDateFormat dateFormat=new SimpleDateFormat("dd/MM/yyyy");
		// test data
		public static Address testAddress;
		public static NationalInsuranceNo personNino;
		public static NationalInsuranceNo testNino;
		public static ArrayList<String>addressLines;
		public static Person testPerson;
		public static Name testName;
		public static ArrayList<Income> testIncomes;
		public static ArrayList<Benefit> testBenefits;
		public static ArrayList<Outgoing> testOutgoings;
		public static ContactDetails contactDetails;
				
		/** create test data **/
		static{
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
			addressLines.add("Accacia Avenue");
			addressLines.add("New Hamlington");
			addressLines.add("Northumberland");
			testAddress.setAddressLines(addressLines);
			testAddress.setPostcode("NE33 5TY");
			
			contactDetails=new ContactDetails();
			contactDetails.setEmailAddress("BillSmithPersona@noname.com");
			contactDetails.setTelephoneNumber("01234 567890");
			contactDetails.setMobileNumber("0789 0123456");
			contactDetails.setPreferredContactValue("0789 0123456");
		}
		
		private static void createNINO(){
			testNino=new NationalInsuranceNo("NX 96 33 13 B");
			personNino=new NationalInsuranceNo("NX 96 33 13 B");
		}
		
		private static void createBillName(){
			testName=new Name();
			testName.setTitle("Mr");
			testName.setForenames("Bill");
			testName.setSurname("Smith");
		}
		
		private static void createBillIncomeAndExpenditure(){
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
			testOutgoing2.setType(OutgoingType.RENT);
			testOutgoing2.setValue("60");
			testOutgoing2.setMoneyPeriod(MoneyPeriod.weekly);
			
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
}
