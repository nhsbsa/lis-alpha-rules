package uk.nhs.nhsbsa.lis.rules.v1.droolsengine.assessment;

import org.junit.Ignore;
import org.junit.Test;

import uk.nhs.nhsbsa.lis.rules.v1.droolsengine.assessment.AssessmentRules;
import uk.nhs.nhsbsa.lis.rules.v1.droolsengine.data.TestData;
import uk.nhs.nhsbsa.lis.rules.v1.model.application.Application;
import uk.nhs.nhsbsa.lis.rules.v1.model.outcome.AssessmentBreakdown;

@Ignore
public class AssessmentRulesTest {
	
	//public static LisApplication billApplication;
	//public static LisApplication miriamApplication;
	
	@Test
	public void testBillAssessment(){
		AssessmentRules rulesCheck=new AssessmentRules();
		TestData testData=new TestData();
		Application billApplication=testData.createBillAssessment();
		AssessmentBreakdown assessmentCalc=rulesCheck.runApplicationRules(billApplication);
		System.out.println("Bills assessment="+assessmentCalc);
		rulesCheck.clearRules();
		// TODO add some test conditions
		
	}
	
	@Test
	public void testMiriamApplication(){
		AssessmentRules rulesCheck=new AssessmentRules();
		TestData testData=new TestData();
		Application miriamApplication=testData.createMiriamAssessment();
		AssessmentBreakdown assessmentCalc=rulesCheck.runApplicationRules(miriamApplication);
		System.out.println("Miriams assessment="+assessmentCalc);
		rulesCheck.clearRules();
		// TODO add some test conditions	
	}
	

}
