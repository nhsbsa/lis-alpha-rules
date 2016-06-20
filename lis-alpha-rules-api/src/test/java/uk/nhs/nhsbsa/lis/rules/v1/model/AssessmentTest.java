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
		
		Assessment assessment=new Assessment();
		assessment.setAddress(BillPersonaTestData.testAddress);
		assessment.setApplicant(BillPersonaTestData.testPerson);
		assessment.setClaimDate(assessmentDate);
		assessment.setProcessingDate(processingDate);
		assessment.setDependants(null);
		assessment.setId("01042016SMITHBB");
		assessment.setPartner(null);
		assessment.setNonDependants(null);
		
		
		assertTrue(assessment.getAddress().equals(BillPersonaTestData.testAddress));
		assertTrue(assessment.getApplicant().equals(BillPersonaTestData.testPerson));
		assertTrue(assessment.getClaimDate().equals(assessmentDate));
		assertTrue(assessment.getProcessingDate().equals(processingDate));
		assertTrue(assessment.getDependants()==null);
		assertTrue(assessment.getId().equals("01042016SMITHBB"));
		assertTrue(assessment.getPartner()==null);
		assertTrue(assessment.getNonDependants()==null);
		
		System.out.println("testBillAssessment:");
		System.out.println("String Method");
		System.out.println(assessment);
		System.out.println("JSON String Method");
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
		
		Assessment assessment=new Assessment();
		assessment.setAddress(MiriamPersonaTestData.testAddress);
		assessment.setApplicant(MiriamPersonaTestData.testPerson);
		assessment.setClaimDate(assessmentDate);
		assessment.setProcessingDate(processingDate);
		assessment.setDependants(null);
		assessment.setId("01052016JONESM");
		assessment.setPartner(null);
		
		List<Person> nonDependants=new ArrayList<Person>();
		nonDependants.add(MiriamPersonaTestData.testPerson2);
		assessment.setNonDependants(nonDependants);
		
		assertTrue(assessment.getAddress().equals(MiriamPersonaTestData.testAddress));
		assertTrue(assessment.getApplicant().equals(MiriamPersonaTestData.testPerson));
		assertTrue(assessment.getClaimDate().equals(assessmentDate));
		assertTrue(assessment.getProcessingDate().equals(processingDate));
		assertTrue(assessment.getDependants()==null);
		assertTrue(assessment.getId().equals("01052016JONESM"));
		assertTrue(assessment.getPartner()==null);
		assertTrue(assessment.getNonDependants().equals(nonDependants));
		
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
	public String toJSONString(Assessment assessment){
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
