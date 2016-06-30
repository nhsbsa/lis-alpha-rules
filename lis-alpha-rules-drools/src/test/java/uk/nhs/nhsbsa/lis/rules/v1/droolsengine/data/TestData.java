package uk.nhs.nhsbsa.lis.rules.v1.droolsengine.data;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import uk.nhs.nhsbsa.lis.rules.v1.model.BillPersonaTestData;
import uk.nhs.nhsbsa.lis.rules.v1.model.LisApplication;
import uk.nhs.nhsbsa.lis.rules.v1.model.MiriamPersonaTestData;
import uk.nhs.nhsbsa.lis.rules.v1.model.Person;
import uk.nhs.nhsbsa.lis.rules.v1.model.Saving;
import uk.nhs.nhsbsa.lis.rules.v1.model.SavingType;
import uk.nhs.nhsbsa.lis.rules.v1.model.ValueState;

public class TestData {
	
	public LisApplication createBillAssessment(){
		
		LocalDateTime assessmentDate;
		LocalDateTime processingDate;
		
		assessmentDate=LocalDateTime.parse("2016-07-01T00:00:00");
		processingDate=LocalDateTime.parse("2016-07-01T00:00:00");
		
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
		
		LocalDateTime assessmentDate;
		LocalDateTime processingDate;
		
		assessmentDate=LocalDateTime.parse("2016-02-01T00:00:00");
		processingDate=LocalDateTime.parse("2016-05-01T00:00:00");
		
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
