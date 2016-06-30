package uk.nhs.nhsbsa.lis.rules.v1.droolsengine.workflow;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.junit.Test;

import uk.nhs.nhsbsa.lis.rules.v1.droolsengine.WorkflowState;
import uk.nhs.nhsbsa.lis.rules.v1.droolsengine.data.TestData;
import uk.nhs.nhsbsa.lis.rules.v1.droolsengine.workflow.NavigationRules;
import uk.nhs.nhsbsa.lis.rules.v1.model.LisApplication;

/**
 * Test for Navigation flow
 * @author lorob
 *
 */
public class NavigationRulesTest {
	//static LisApplication billApplication;
	//static LisApplication miriamApplication;
	
	@Test
	public void testBillWorkflowAssessment(){
		NavigationRules navigationCheck=new NavigationRules();
		TestData testData=new TestData();
		LisApplication billApplication=testData.createBillAssessment();
		WorkflowState workflow=navigationCheck.runWorkflowRules(billApplication);
		System.out.println("\n>>>>Bills workflow="+workflow);
		System.out.println("Screen Errors:"+workflow.getErrorList());
		navigationCheck.clearRules();
		
	}
	
	@Test
	public void testMiriamWorkflowTest(){
		NavigationRules navigationCheck=new NavigationRules();
		TestData testData=new TestData();
		LisApplication miriamApplication=testData.createMiriamAssessment();
		WorkflowState workflow=navigationCheck.runWorkflowRules(miriamApplication);
		System.out.println("\n>>>>Miriam workflow="+workflow);
		System.out.println("Screen Errors:"+workflow.getErrorList());
		navigationCheck.clearRules();
		
	}
	
	@Test
	public void testMissingAgeWorkflow(){
		NavigationRules navigationCheck=new NavigationRules();
		TestData testData=new TestData();
		LisApplication billApplication=testData.createBillAssessment();
		billApplication.getApplicant().setDob(null);
		WorkflowState workflow=navigationCheck.runWorkflowRules(billApplication);
		System.out.println("\n>>>>Missing Age workflow="+workflow);
		System.out.println("Screen Errors:"+workflow.getErrorList());
		navigationCheck.clearRules();
		
	}
	
	@Test
	public void testUnderAgeWorkflow(){
		NavigationRules navigationCheck=new NavigationRules();
		TestData testData=new TestData();
		LisApplication billApplication=testData.createBillAssessment();
		billApplication.setClaimDate(LocalDateTime.parse("2016-01-01T00:00:00"));
		billApplication.getApplicant().setDob(LocalDate.parse("2010-01-01"));
		WorkflowState workflow=navigationCheck.runWorkflowRules(billApplication);
		System.out.println("\n>>>>Missing Age workflow="+workflow);
		System.out.println("Screen Errors:"+workflow.getErrorList());
		navigationCheck.clearRules();
		
	}
}
