package uk.nhs.nhsbsa.lis.rules.v1.droolsengine.service;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import uk.nhs.nhsbsa.lis.rules.v1.IAssessmentRulesService;
import uk.nhs.nhsbsa.lis.rules.v1.droolsengine.config.DroolsConfiguration;
import uk.nhs.nhsbsa.lis.rules.v1.droolsengine.service.DroolsAssessmentRulesServiceTest.DroolsAssessmentRulesServiceTestConfig;
import uk.nhs.nhsbsa.lis.rules.v1.model.Assessment;
import uk.nhs.nhsbsa.lis.rules.v1.model.BillPersonaTestData;
import uk.nhs.nhsbsa.lis.rules.v1.model.LisApplication;

@ContextConfiguration(classes={
		DroolsAssessmentRulesServiceTestConfig.class,
		DroolsConfiguration.class
})
public class DroolsAssessmentRulesServiceTest extends AbstractJUnit4SpringContextTests {

	@Configuration
	public static class DroolsAssessmentRulesServiceTestConfig {
		@Bean
		public DroolsAssessmentRulesService createDroolsAssessmentRulesService() {
			return new DroolsAssessmentRulesService();
		}
		@Bean
		public ISessionConfigService createAssessmentSessionConfigService() {
			return new AssessmentSessionConfigService();
		}
		@Bean
		public ISessionConfigService createGlobalsSessionConfigService() {
			return new GlobalsSessionConfigService();
		}
	}
	
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
		actual = service.assess(input);
		
		assertNotNull(actual);
	}

}
