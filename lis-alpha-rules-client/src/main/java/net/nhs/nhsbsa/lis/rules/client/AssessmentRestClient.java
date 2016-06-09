package net.nhs.nhsbsa.lis.rules.client;

import org.springframework.web.client.RestTemplate;

import uk.nhs.nhsbsa.lis.rules.v1.model.Assessment;

public class AssessmentRestClient implements IAssessmentRestClient {

	private RestTemplate restTemplate;

	public AssessmentRestClient() {
		restTemplate = new RestTemplate();
	}

	@Override
	public Assessment put(Assessment assessment) {
		return assessment;
	}

	@Override
	public Assessment get(String id) {
		return restTemplate.getForObject("/assessments/{id}", Assessment.class, "42");
	}

	public RestTemplate getRestTemplate() {
		return restTemplate;
	}

	public void setRestTemplate(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}

}
