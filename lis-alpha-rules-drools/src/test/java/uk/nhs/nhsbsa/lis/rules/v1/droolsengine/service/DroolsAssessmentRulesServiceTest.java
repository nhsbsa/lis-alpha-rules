package uk.nhs.nhsbsa.lis.rules.v1.droolsengine.service;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import uk.nhs.nhsbsa.lis.rules.v1.IAssessmentRulesService;
import uk.nhs.nhsbsa.lis.rules.v1.droolsengine.config.DroolsConfiguration;
import uk.nhs.nhsbsa.lis.rules.v1.model.Assessment;
import uk.nhs.nhsbsa.lis.rules.v1.model.application.BillPersonaTestData;
import uk.nhs.nhsbsa.lis.rules.v1.model.application.LisApplication;

@ContextConfiguration(classes={
		DroolsServiceConfiguration.class,
		DroolsConfiguration.class
})
public class DroolsAssessmentRulesServiceTest extends AbstractJUnit4SpringContextTests {
	
	@Autowired
	private IAssessmentRulesService service;

	@Test
	public void testSpring() {
		assertNotNull(service);
	}
	
	@Test
	public void testAssessment() {
		
		LisApplication bill = new BillPersonaTestData().createApplication();
		Assessment input = new Assessment("123", bill);
		
		Assessment actual = service.assess(input);
		
		assertNotNull(actual);
	}
	
}
