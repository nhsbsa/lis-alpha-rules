package net.nhs.nhsbsa.lis.rules.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import uk.nhs.nhsbsa.lis.rules.v1.model.Assessment;
import uk.nhs.nhsbsa.lis.rules.v1.model.application.LisApplication;

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
	public Assessment post(LisApplication application) {
		HttpEntity<LisApplication> requestEntity = new HttpEntity<LisApplication>(application);
		ResponseEntity<Assessment> responseEntity =
				restTemplate.exchange(
						restEndpointBuilder.getPostResourceUri(),
						HttpMethod.POST, 
						requestEntity, 
						Assessment.class);
		return responseEntity.getBody();
	}

	@Override
	public Assessment get(String id) {
		return restTemplate.getForObject(restEndpointBuilder.getGetResourceUri(), Assessment.class, id);
	}

	@Override
	public Assessment put(String id, Assessment assessment) {
		HttpEntity<Assessment> requestEntity = new HttpEntity<Assessment>(assessment);
		ResponseEntity<Assessment> responseEntity =
				restTemplate.exchange(
						restEndpointBuilder.getPutResourceUri(),
						HttpMethod.PUT, 
						requestEntity, 
						Assessment.class, id);
		return responseEntity.getBody();
	}

}
