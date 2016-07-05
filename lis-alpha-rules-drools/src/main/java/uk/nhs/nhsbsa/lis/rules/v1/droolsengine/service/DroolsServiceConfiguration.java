package uk.nhs.nhsbsa.lis.rules.v1.droolsengine.service;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import uk.nhs.nhsbsa.lis.rules.v1.droolsengine.service.session.SessionFactInputProcesser;
import uk.nhs.nhsbsa.lis.rules.v1.droolsengine.service.session.SessionFactOutputProcessor;
import uk.nhs.nhsbsa.lis.rules.v1.droolsengine.service.session.SessionGlobalsProcessor;
import uk.nhs.nhsbsa.lis.rules.v1.droolsengine.service.session.ISessionProcessor;

@Configuration
public class DroolsServiceConfiguration {

	@Bean
	public DroolsAssessmentRulesService createDroolsAssessmentRulesService() {
		return new DroolsAssessmentRulesService();
	}
	
	@Bean
	public ISessionProcessor createSessionFactInputProcesser() {
		return new SessionFactInputProcesser();
	}
	
	@Bean
	public ISessionProcessor createSessionFactOutputProcessor() {
		return new SessionFactOutputProcessor();
	}
	
	@Bean
	public ISessionProcessor createSessionGlobalsProcessor() {
		return new SessionGlobalsProcessor();
	}
	
	@Bean
	public IAssessmentFactoryService createAssessmentFactoryService() {
		return new AssessmentFactoryService();
	}
}
