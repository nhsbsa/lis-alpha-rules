package uk.nhs.nhsbsa.lis.rules.v1.model;
import static org.junit.Assert.assertEquals;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

public class AssessmentTest {
	
	BillPersonaTestData testData;
	LocalDateTime assessmentDate;
	LocalDateTime processingDate;
	
	@Test
	public void testBillAssessment(){
		assessmentDate=LocalDateTime.parse("2016-04-01T00:00:00");
		processingDate=LocalDateTime.parse("2016-04-01T00:00:00");
		
		LisApplication assessment=new LisApplication();
		assessment.setAddress(BillPersonaTestData.testAddress);
		assessment.setApplicant(BillPersonaTestData.testPerson);
		assessment.setClaimDate(assessmentDate);
		assessment.setProcessingDate(processingDate);
		assessment.setDependants(null);
		assessment.setPartner(null);
		assessment.setNonDependants(null);
		assessment.setContactDetails(BillPersonaTestData.contactDetails);
		
		assertEquals(assessment.getAddress(),BillPersonaTestData.testAddress);
		assertEquals(assessment.getApplicant(),BillPersonaTestData.testPerson);
		assertEquals(assessment.getClaimDate(),assessmentDate);
		assertEquals(assessment.getProcessingDate(),processingDate);
		assertEquals(assessment.getDependants(),null);
		assertEquals(assessment.getPartner(),null);
		assertEquals(assessment.getNonDependants(),null);
		assertEquals(assessment.getContactDetails(),BillPersonaTestData.contactDetails);
		
		System.out.println(toJSONString(assessment));
		
	}
	
	@Test
	public void testMiriamAssessment(){
		assessmentDate=LocalDateTime.parse("2016-05-01T00:00:00");
		processingDate=LocalDateTime.parse("2016-05-01T00:00:00");
		
		LisApplication assessment=new LisApplication();
		assessment.setAddress(MiriamPersonaTestData.testAddress);
		assessment.setApplicant(MiriamPersonaTestData.testPerson);
		assessment.setClaimDate(assessmentDate);
		assessment.setProcessingDate(processingDate);
		assessment.setDependants(null);
		assessment.setPartner(null);
		assessment.setContactDetails(MiriamPersonaTestData.contactDetails);
		
		List<Person> nonDependants=new ArrayList<Person>();
		nonDependants.add(MiriamPersonaTestData.testPerson2);
		assessment.setNonDependants(nonDependants);
		
		List<Saving> testSavings=new ArrayList<Saving>();
		Saving saving=new Saving();
		saving.setState(ValueState.SET);
		saving.setType(SavingType.ACCOUNTS);
		saving.setValue("1000.00");
		testSavings.add(saving);
		assessment.setSavings(testSavings);
		
		assertEquals(assessment.getAddress(),MiriamPersonaTestData.testAddress);
		assertEquals(assessment.getApplicant(),MiriamPersonaTestData.testPerson);
		assertEquals(assessment.getClaimDate(),assessmentDate);
		assertEquals(assessment.getProcessingDate(),processingDate);
		assertEquals(assessment.getDependants(),null);
		assertEquals(assessment.getPartner(),null);
		assertEquals(assessment.getNonDependants(),nonDependants);
		assertEquals(assessment.getContactDetails(),MiriamPersonaTestData.contactDetails);
		
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
