package net.nhs.nhsbsa.lis.rules.client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RulesClientConfiguration {

	@Value("assessments.uri")
	String assessmentsUri;
	
	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}
	
	@Bean
	public AssessmentRestClient getAssessmentRestClient() {
		RestEndpointBuilder builder = new RestEndpointBuilder(assessmentsUri)
				.withGetResource("/{id}")
				.withPutResource("/{id}");
		return new AssessmentRestClient(builder);
	}
	
}
