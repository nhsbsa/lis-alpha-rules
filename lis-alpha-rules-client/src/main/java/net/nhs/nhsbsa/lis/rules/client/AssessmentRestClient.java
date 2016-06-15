package net.nhs.nhsbsa.lis.rules.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import uk.nhs.nhsbsa.lis.rules.v1.model.Assessment;

public class AssessmentRestClient implements IAssessmentRestClient {

	/**
	 * Base URI to assessments resource.
	 */
	private RestEndpointBuilder restEndpointBuilder;
	
	@Autowired
	private RestTemplate restTemplate;

	/**
	 * Default constructor.
	 */
	public AssessmentRestClient(RestEndpointBuilder restEndpointBuilder) {
		this(null, restEndpointBuilder);
	}

	/**
	 * Convenience constructor.
	 * @param restTemplate
	 */
	public AssessmentRestClient(RestTemplate restTemplate, RestEndpointBuilder restEndpointBuilder) {
		super();
		this.restTemplate = restTemplate;
		this.restEndpointBuilder = restEndpointBuilder;
	}

	@Override
	public Assessment put(Assessment assessment) {
		HttpEntity<Assessment> requestEntity = new HttpEntity<Assessment>(assessment);
		ResponseEntity<Assessment> responseEntity =
				restTemplate.exchange(restEndpointBuilder.getPutResourceUri(), HttpMethod.PUT, requestEntity, Assessment.class, "42");
		return responseEntity.getBody();
	}

	@Override
	public Assessment post() {
		//HttpEntity<Assessment> requestEntity = new HttpEntity<Assessment>(assessment);
		ResponseEntity<Assessment> responseEntity =
				restTemplate.exchange(restEndpointBuilder.getPostResourceUri(), HttpMethod.POST, null, Assessment.class);
		return responseEntity.getBody();
	}
}
