package uk.nhs.nhsbsa.lis.rules.v1.droolsengine.service;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import uk.nhs.nhsbsa.lis.rules.v1.droolsengine.service.session.AssessmentPresetsSessionProcesser;
import uk.nhs.nhsbsa.lis.rules.v1.droolsengine.service.session.ISessionProcessor;
import uk.nhs.nhsbsa.lis.rules.v1.droolsengine.service.session.ObjectIndexSessionProcesser;
import uk.nhs.nhsbsa.lis.rules.v1.droolsengine.service.session.RuleLoggerListenerSessionProcesser;
import uk.nhs.nhsbsa.lis.rules.v1.droolsengine.service.session.SessionFactInputProcesser;
import uk.nhs.nhsbsa.lis.rules.v1.droolsengine.service.session.SessionGlobalsProcessor;
import uk.nhs.nhsbsa.lis.rules.v1.droolsengine.service.session.WorkingDataSessionProcesser;

@Configuration
public class DroolsServiceConfiguration {

	@Bean
	public DroolsAssessmentRulesService createDroolsAssessmentRulesService() {
		return new DroolsAssessmentRulesService();
	}
	
	@Bean
	public ISessionProcessor createRequirementsSessionProcesser() {
		return new AssessmentPresetsSessionProcesser();
	}
	
	@Bean
	public ISessionProcessor createSessionFactInputProcesser() {
		return new SessionFactInputProcesser();
	}
	
	@Bean
	public ISessionProcessor createWorkingDataSessionProcesser() {
		return new WorkingDataSessionProcesser();
	}
	
	@Bean
	public ISessionProcessor createObjectIndexSessionProcesser() {
		return new ObjectIndexSessionProcesser();
	}
	
	@Bean
	public ISessionProcessor createRuleLoggerListenerSessionProcesser() {
		return new RuleLoggerListenerSessionProcesser();
	}
	
	@Bean
	public ISessionProcessor createSessionGlobalsProcessor() {
		return new SessionGlobalsProcessor();
	}
	
	@Bean
	public IAssessmentFactoryService createAssessmentFactoryService() {
		return new AssessmentFactoryService();
	}

	@Bean
	public IRequireService createRequireService() {
		return new RequireService();
	}
}
