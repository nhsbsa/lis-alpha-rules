package uk.nhs.nhsbsa.lis.rules.v1.droolsengine.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import uk.nhs.nhsbsa.lis.rules.v1.IAssessmentRulesService;
import uk.nhs.nhsbsa.lis.rules.v1.droolsengine.service.DroolsAssessmentRulesService;

@Configuration
public class DroolsConfiguration {

	@Bean
	public IAssessmentRulesService getAssessmentRulesService() {
		return new DroolsAssessmentRulesService();
	}
	
}
