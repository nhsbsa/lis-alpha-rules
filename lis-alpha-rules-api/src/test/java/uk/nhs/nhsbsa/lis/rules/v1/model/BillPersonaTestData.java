package uk.nhs.nhsbsa.lis.rules.v1.model;

import java.time.LocalDate;
import java.util.ArrayList;

public class BillPersonaTestData {
	
		// test data
		public Address testAddress;
		public String personNino;
		public String testNino;
		public String addressLine1;
		public String addressLine2;
		public String addressLine3;
		public Person testPerson;
		public Name testName;
		public ArrayList<Income> testIncomes;
		public ArrayList<Benefit> testBenefits;
		public ArrayList<Outgoing> testOutgoings;
		public ContactDetails contactDetails;

		/**
		 * Not very efficient - but allows values to be changed
		 */
		public BillPersonaTestData(){
				createAddress();
				createNINO();
				createBillName();
				createBillIncomeAndExpenditure();
				createBillPersona();
		}
		
		public LisApplication createApplication(){
			
			LocalDate assessmentDate;
			LocalDate processingDate;
			
			assessmentDate=LocalDate.parse("2016-07-01");
			processingDate=LocalDate.parse("2016-07-01");
			
			LisApplication billApplication=new LisApplication();
			BillPersonaTestData billPersonaTestData=new BillPersonaTestData();
			billApplication.setAddress(billPersonaTestData.testAddress);
			billApplication.setApplicant(billPersonaTestData.testPerson);
			billApplication.setClaimDate(assessmentDate);
			billApplication.setProcessingDate(processingDate);
			billApplication.setDependants(null);
			billApplication.setPartner(null);
			billApplication.setNonDependants(null);
			billApplication.setContactDetails(billPersonaTestData.contactDetails);
			return billApplication;
		}
		
		private void createAddress(){
			testAddress=new Address();
			testAddress.setHouseNameNumber("1");
			testAddress.setAddressLine1(addressLine1);
			testAddress.setAddressLine2(addressLine2);
			testAddress.setAddressLine3(addressLine3);
			testAddress.setPostcode("NE33 5TY");
			
			contactDetails=new ContactDetails();
			contactDetails.setEmailAddress("BillSmithPersona@noname.com");
			contactDetails.setTelephoneNumber("01234 567890");
			contactDetails.setMobileNumber("0789 0123456");
			contactDetails.setPreferredContactValue("0789 0123456");
		}
		
		private void createNINO(){
			testNino = "NX963313B";
			personNino = "NX963313B";
		}
		
		private void createBillName(){
			testName=new Name();
			testName.setTitle("Mr");
			testName.setForenames("Bill");
			testName.setSurname("Smith");
		}
		
		private void createBillIncomeAndExpenditure(){
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
		
		private void createBillPersona(){
			testPerson=new Person();
			testPerson.setDob(LocalDate.parse("1946-02-01"));
			testPerson.setName(testName);
			
			testPerson.setNino(personNino);
			testPerson.setType(PersonType.MAIN_APPLICANT);
			testPerson.setIncomes(testIncomes);
			testPerson.setBenefits(testBenefits);
			testPerson.setOutgoings(testOutgoings);
		}
}
