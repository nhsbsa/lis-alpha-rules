package rules;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import uk.nhs.nhsbsa.lis.rules.v1.IAssessmentRulesService;
import uk.nhs.nhsbsa.lis.rules.v1.droolsengine.config.DroolsConfiguration;
import uk.nhs.nhsbsa.lis.rules.v1.droolsengine.service.DroolsServiceConfiguration;

@ContextConfiguration(classes={
		DroolsServiceConfiguration.class,
		DroolsConfiguration.class
})
public class AbstractRulesTest extends AbstractJUnit4SpringContextTests {
	
	@Autowired
	protected IAssessmentRulesService service;

	@Test
	public void testSpring() {
		assertNotNull(service);
	}
	
	

}
