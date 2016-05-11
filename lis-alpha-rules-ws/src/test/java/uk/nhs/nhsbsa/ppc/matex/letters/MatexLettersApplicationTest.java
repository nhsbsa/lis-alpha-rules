package uk.nhs.nhsbsa.ppc.matex.letters;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Rule;
import org.junit.Test;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.OutputCapture;

import uk.nhs.nhsbsa.lis.rules.ws.LisRulesWebServiceApplication;

public class MatexLettersApplicationTest {

	@Rule
	public OutputCapture outputCapture = new OutputCapture();

	@Test
	public void testDefaultSettings() throws Exception {
		assertThat(SpringApplication
				.exit(SpringApplication.run(LisRulesWebServiceApplication.class))).isEqualTo(0);
		String output = this.outputCapture.toString();
		assertThat(output).contains("completed with the following parameters");
	}

}
