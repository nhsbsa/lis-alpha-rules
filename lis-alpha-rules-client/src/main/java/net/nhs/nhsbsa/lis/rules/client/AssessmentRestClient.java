package net.nhs.nhsbsa.lis.rules.client;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import uk.nhs.nhsbsa.lis.rules.v1.model.Assessment;

public class AssessmentRestClient implements IAssessmentRestClient {

	private RestTemplate restTemplate;

	public AssessmentRestClient() {
		restTemplate = new RestTemplate();
	}

	@Override
	public Assessment put(Assessment assessment) {
		HttpEntity<Assessment> requestEntity = new HttpEntity<Assessment>(assessment);
		ResponseEntity<Assessment> responseEntity =
				restTemplate.exchange("/assessments/{id}", HttpMethod.PUT, requestEntity, Assessment.class, "42");
		return responseEntity.getBody();
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
