package uk.nhs.nhsbsa.lis.rules.v1.droolsengine.data;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import uk.nhs.nhsbsa.lis.rules.v1.model.ValueState;
import uk.nhs.nhsbsa.lis.rules.v1.model.application.BillPersonaTestData;
import uk.nhs.nhsbsa.lis.rules.v1.model.application.LisApplication;
import uk.nhs.nhsbsa.lis.rules.v1.model.application.MiriamPersonaTestData;
import uk.nhs.nhsbsa.lis.rules.v1.model.application.Person;
import uk.nhs.nhsbsa.lis.rules.v1.model.application.Saving;
import uk.nhs.nhsbsa.lis.rules.v1.model.application.SavingType;

public class TestData {
	
	public LisApplication createBillAssessment(){
		
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
	
	public LisApplication createMiriamAssessment(){
		
		LocalDate assessmentDate;
		LocalDate processingDate;
		
		assessmentDate=LocalDate.parse("2016-02-01");
		processingDate=LocalDate.parse("2016-05-01");
		
		LisApplication miriamApplication=new LisApplication();
		MiriamPersonaTestData miriamPersonaTestData=new MiriamPersonaTestData();
		miriamApplication.setAddress(miriamPersonaTestData.testAddress);
		miriamApplication.setApplicant(miriamPersonaTestData.testPerson);
		miriamApplication.setClaimDate(assessmentDate);
		miriamApplication.setProcessingDate(processingDate);
		miriamApplication.setDependants(null);
		miriamApplication.setPartner(null);
		miriamApplication.setContactDetails(miriamPersonaTestData.contactDetails);
		
		List<Person> nonDependants=new ArrayList<Person>();
		nonDependants.add(miriamPersonaTestData.testPerson2);
		miriamApplication.setNonDependants(nonDependants);
		
		List<Saving> testSavings=new ArrayList<Saving>();
		Saving saving=new Saving();
		saving.setState(ValueState.SET);
		saving.setType(SavingType.ACCOUNTS);
		saving.setValue("1000.00");
		testSavings.add(saving);
		miriamApplication.setSavings(testSavings);
		
		return miriamApplication;
		
	}
}
