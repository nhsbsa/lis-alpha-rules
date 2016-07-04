package uk.nhs.nhsbsa.lis.rules.v1.droolsengine.service;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import uk.nhs.nhsbsa.lis.rules.v1.droolsengine.service.session.AssessmentSessionConfigService;
import uk.nhs.nhsbsa.lis.rules.v1.droolsengine.service.session.GlobalsSessionConfigService;
import uk.nhs.nhsbsa.lis.rules.v1.droolsengine.service.session.ISessionConfigService;

@Configuration
public class DroolsServiceConfiguration {

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
	
	@Bean
	public IAssessmentFactoryService createAssessmentFactoryService() {
		return new AssessmentFactoryService();
	}
}
