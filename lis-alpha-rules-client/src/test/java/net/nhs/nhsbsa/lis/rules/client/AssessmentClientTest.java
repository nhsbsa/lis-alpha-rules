package net.nhs.nhsbsa.lis.rules.client;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.method;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.requestTo;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withSuccess;

import org.junit.Before;
import org.junit.Test;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.test.web.client.MockRestServiceServer;
import org.springframework.web.client.RestTemplate;

import uk.nhs.nhsbsa.rules.model.rules.Assessment;

public class AssessmentClientTest {

	private RestTemplate restTemplate;
	private MockRestServiceServer mockServer;
	private AssessmentRestClient client;

	@Before
	public void setup() {
		
		restTemplate = new RestTemplate();
		mockServer = MockRestServiceServer.createServer(restTemplate);
		RestEndpointBuilder restEndpointBuilder = new RestEndpointBuilder("/assessments")
				.withGetResource("/{id}")
				.withPutResource("/{id}");
		client = new AssessmentRestClient(restTemplate, restEndpointBuilder);
	}

	@Test
	public void testGet() {

		mockServer.expect(requestTo("/assessments/42")).andExpect(method(HttpMethod.GET))
				.andRespond(withSuccess(resource("/fixture/assessment.json"), MediaType.APPLICATION_JSON));

		Assessment actual = client.get("42");
		assertNotNull(actual);
		assertEquals("42", actual.getId());

		mockServer.verify();
	}

	@Test
	public void testPut() {

		mockServer.expect(requestTo("/assessments/42")).andExpect(method(HttpMethod.PUT))
				.andRespond(withSuccess(resource("/fixture/assessment.json"), MediaType.APPLICATION_JSON));

		Assessment input = new Assessment("42", null);
		
		Assessment actual = client.put("42", input);
		assertNotNull(actual);
		assertEquals("42", actual.getId());

		mockServer.verify();
	}

	private Resource resource(String path) {
		return new ClassPathResource(path);
	}

}
