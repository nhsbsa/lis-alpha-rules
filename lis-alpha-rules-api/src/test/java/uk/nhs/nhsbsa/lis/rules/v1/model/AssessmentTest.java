package uk.nhs.nhsbsa.lis.rules.v1.model;
import static org.junit.Assert.assertEquals;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

public class AssessmentTest {
	
	BillPersonaTestData testData;
	LocalDate assessmentDate;
	LocalDate processingDate;
	
	@Test
	public void testBillAssessment(){
		assessmentDate=LocalDate.parse("2016-04-01");
		processingDate=LocalDate.parse("2016-04-01");
		
		LisApplication assessment=new LisApplication();
		BillPersonaTestData billPersonaTestData=new BillPersonaTestData();
		assessment.setAddress(billPersonaTestData.testAddress);
		assessment.setApplicant(billPersonaTestData.testPerson);
		assessment.setClaimDate(assessmentDate);
		assessment.setProcessingDate(processingDate);
		assessment.setDependants(null);
		assessment.setPartner(null);
		assessment.setNonDependants(null);
		assessment.setContactDetails(billPersonaTestData.contactDetails);
		
		assertEquals(assessment.getAddress(),billPersonaTestData.testAddress);
		assertEquals(assessment.getApplicant(),billPersonaTestData.testPerson);
		assertEquals(assessment.getClaimDate(),assessmentDate);
		assertEquals(assessment.getProcessingDate(),processingDate);
		assertEquals(assessment.getDependants(),null);
		assertEquals(assessment.getPartner(),null);
		assertEquals(assessment.getNonDependants(),null);
		assertEquals(assessment.getContactDetails(),billPersonaTestData.contactDetails);
		
		System.out.println(toJSONString(assessment));
		
	}
	
	@Test
	public void testMiriamAssessment(){
		assessmentDate=LocalDate.parse("2016-05-01");
		processingDate=LocalDate.parse("2016-05-01");
		
		LisApplication assessment=new LisApplication();
		MiriamPersonaTestData miriamPersonaTestData=new MiriamPersonaTestData();
		assessment.setAddress(miriamPersonaTestData.testAddress);
		assessment.setApplicant(miriamPersonaTestData.testPerson);
		assessment.setClaimDate(assessmentDate);
		assessment.setProcessingDate(processingDate);
		assessment.setDependants(null);
		assessment.setPartner(null);
		assessment.setContactDetails(miriamPersonaTestData.contactDetails);
		
		List<Person> nonDependants=new ArrayList<Person>();
		nonDependants.add(miriamPersonaTestData.testPerson2);
		assessment.setNonDependants(nonDependants);
		
		List<Saving> testSavings=new ArrayList<Saving>();
		Saving saving=new Saving();
		saving.setState(ValueState.SET);
		saving.setType(SavingType.ACCOUNTS);
		saving.setValue("1000.00");
		testSavings.add(saving);
		assessment.setSavings(testSavings);
		
		assertEquals(assessment.getAddress(),miriamPersonaTestData.testAddress);
		assertEquals(assessment.getApplicant(),miriamPersonaTestData.testPerson);
		assertEquals(assessment.getClaimDate(),assessmentDate);
		assertEquals(assessment.getProcessingDate(),processingDate);
		assertEquals(assessment.getDependants(),null);
		assertEquals(assessment.getPartner(),null);
		assertEquals(assessment.getNonDependants(),nonDependants);
		assertEquals(assessment.getContactDetails(),miriamPersonaTestData.contactDetails);
		
		System.out.println("testMiriamAssessment:");
		System.out.println("String Method");
		System.out.println(assessment);
		System.out.println("JSON String Method");
		System.out.println(toJSONString(assessment));
		
	}
	
	/**
	 * Just for outputting 
	 * @return
	 */
	public String toJSONString(LisApplication assessment){
			ObjectMapper mapper = new ObjectMapper();
			mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
			try{
				String jsonInString = mapper.writeValueAsString(assessment);
				return jsonInString;
			}catch(Exception e){
				e.printStackTrace();

			}
			return "";
			
		}
	
}
