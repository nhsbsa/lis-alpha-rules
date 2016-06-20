package uk.nhs.nhsbsa.lis.rules.v1.model;
import static org.junit.Assert.*;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;

import com.fasterxml.jackson.databind.ObjectMapper;

public class AssessmentTest {
	
	BillPersonaTestData testData;
	Date assessmentDate;
	Date processingDate;
	
	@Test
	public void testBillAssessment(){
		try {
			assessmentDate=(BillPersonaTestData.dateFormat.parse("01/04/2016"));
			processingDate=(BillPersonaTestData.dateFormat.parse("01/04/2016"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		LisApplication assessment=new LisApplication();
		assessment.setAddress(BillPersonaTestData.testAddress);
		assessment.setApplicant(BillPersonaTestData.testPerson);
		assessment.setClaimDate(assessmentDate);
		assessment.setProcessingDate(processingDate);
		assessment.setDependants(null);
		assessment.setPartner(null);
		assessment.setNonDependants(null);
		assessment.setContactDetails(BillPersonaTestData.contactDetails);
		
		//REVIEW PT use Assert.assertEquals!
		assertTrue(assessment.getAddress().equals(BillPersonaTestData.testAddress));
		assertTrue(assessment.getApplicant().equals(BillPersonaTestData.testPerson));
		assertTrue(assessment.getClaimDate().equals(assessmentDate));
		assertTrue(assessment.getProcessingDate().equals(processingDate));
		assertTrue(assessment.getDependants()==null);
		assertTrue(assessment.getPartner()==null);
		assertTrue(assessment.getNonDependants()==null);
		assertTrue(assessment.getContactDetails().equals(BillPersonaTestData.contactDetails));
		
		System.out.println(toJSONString(assessment));
		
	}
	
	@Test
	public void testMiriamAssessment(){
		try {
			assessmentDate=(BillPersonaTestData.dateFormat.parse("01/05/2016"));
			processingDate=(BillPersonaTestData.dateFormat.parse("01/05/2016"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
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
		
		assertTrue(assessment.getAddress().equals(MiriamPersonaTestData.testAddress));
		assertTrue(assessment.getApplicant().equals(MiriamPersonaTestData.testPerson));
		assertTrue(assessment.getClaimDate().equals(assessmentDate));
		assertTrue(assessment.getProcessingDate().equals(processingDate));
		assertTrue(assessment.getDependants()==null);
		assertTrue(assessment.getPartner()==null);
		assertTrue(assessment.getNonDependants().equals(nonDependants));
		assertTrue(assessment.getContactDetails().equals(MiriamPersonaTestData.contactDetails));
		
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
			mapper.setDateFormat(BillPersonaTestData.dateFormat);
			try{
				String jsonInString = mapper.writeValueAsString(assessment);
				return jsonInString;
			}catch(Exception e){
				e.printStackTrace();

			}
			return "";
			
		}
	
}
