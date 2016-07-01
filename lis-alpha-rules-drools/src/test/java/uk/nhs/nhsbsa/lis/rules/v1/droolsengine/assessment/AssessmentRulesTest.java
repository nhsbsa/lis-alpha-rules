package uk.nhs.nhsbsa.lis.rules.v1.droolsengine.assessment;

import org.junit.Test;

import uk.nhs.nhsbsa.lis.rules.v1.droolsengine.assessment.AssessmentRules;
import uk.nhs.nhsbsa.lis.rules.v1.droolsengine.data.TestData;
import uk.nhs.nhsbsa.lis.rules.v1.model.AssessmentCalculation;
import uk.nhs.nhsbsa.lis.rules.v1.model.LisApplication;



public class AssessmentRulesTest {
	
	//public static LisApplication billApplication;
	//public static LisApplication miriamApplication;
	
	@Test
	public void testBillAssessment(){
		AssessmentRules rulesCheck=new AssessmentRules();
		TestData testData=new TestData();
		LisApplication billApplication=testData.createBillAssessment();
		AssessmentCalculation assessmentCalc=rulesCheck.runApplicationRules(billApplication);
		System.out.println("Bills assessment="+assessmentCalc);
		rulesCheck.clearRules();
		// TODO add some test conditions
		
	}
	
	@Test
	public void testMiriamApplication(){
		AssessmentRules rulesCheck=new AssessmentRules();
		TestData testData=new TestData();
		LisApplication miriamApplication=testData.createMiriamAssessment();
		AssessmentCalculation assessmentCalc=rulesCheck.runApplicationRules(miriamApplication);
		System.out.println("Miriams assessment="+assessmentCalc);
		rulesCheck.clearRules();
		// TODO add some test conditions	
	}
	

}
