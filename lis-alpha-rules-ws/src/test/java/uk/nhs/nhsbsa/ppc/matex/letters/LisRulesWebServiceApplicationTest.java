package uk.nhs.nhsbsa.ppc.matex.letters;

import static org.junit.Assert.assertEquals;

import java.util.Map;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import uk.nhs.nhsbsa.lis.rules.v1.model.application.LisApplication;
import uk.nhs.nhsbsa.lis.rules.ws.LisRulesWebServiceApplication;

/**
 * Basic integration tests for service demo application.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = LisRulesWebServiceApplication.class)
@WebAppConfiguration
@IntegrationTest({ "server.port=0", "management.port=0" })
@DirtiesContext
public class LisRulesWebServiceApplicationTest {

	@Value("${local.server.port}")
	private int port;

	@Value("${local.management.port}")
	private int mgt;

	@Test
	@Ignore
	public void testGreeting() throws Exception {
		ResponseEntity<LisApplication> entity = new TestRestTemplate()
				.getForEntity("http://localhost:" + this.port + "/assessments/123", LisApplication.class);
		assertEquals(HttpStatus.OK, entity.getStatusCode());
	}

	@Test
	@SuppressWarnings("rawtypes")
	public void testInfo() throws Exception {
		ResponseEntity<Map> entity = new TestRestTemplate().getForEntity("http://localhost:" + this.mgt + "/info",
				Map.class);
		assertEquals(HttpStatus.OK, entity.getStatusCode());
	}

}
