package uk.nhs.nhsbsa.lis.rules.v1.model;
import static org.junit.Assert.*;
import java.text.ParseException;
import java.util.Date;

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
		
		
		assertSame(assessment.getAddress(),BillPersonaTestData.testAddress);
		assertSame(assessment.getApplicant(),BillPersonaTestData.testPerson);
		assertSame(assessment.getClaimDate(),assessmentDate);
		assertSame(assessment.getProcessingDate(),processingDate);
		assertSame(assessment.getDependants(),null);
		assertSame(assessment.getId(),"01042016SMITHBB");
		assertSame(assessment.getPartner(),null);
		assertSame(assessment.getNonDependants(),null);
		
		System.out.println("testBillAssessment:");
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
