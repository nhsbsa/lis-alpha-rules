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

import uk.nhs.nhsbsa.lis.rules.v1.model.Assessment;

public class AssessmentClientTest {

	private AssessmentRestClient client = new AssessmentRestClient();
	private MockRestServiceServer mockServer;

	@Before
	public void setup() {

		mockServer = MockRestServiceServer.createServer(client.getRestTemplate());
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

		Assessment input = new Assessment("42");
		
		Assessment actual = client.put(input);
		assertNotNull(actual);
		assertEquals("42", actual.getId());

		mockServer.verify();
	}

	private Resource resource(String path) {
		return new ClassPathResource(path);
	}

}
