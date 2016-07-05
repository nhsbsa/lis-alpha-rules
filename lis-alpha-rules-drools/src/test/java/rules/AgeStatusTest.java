package rules;

import org.junit.Test;

import uk.nhs.nhsbsa.lis.rules.v1.model.Assessment;
import uk.nhs.nhsbsa.lis.rules.v1.model.BillPersonaTestData;
import uk.nhs.nhsbsa.lis.rules.v1.model.LisApplication;

public class AgeStatusTest extends AbstractRulesTest {

	
	@Test
	public void testAge() {

		LisApplication bill = new BillPersonaTestData().createApplication();
		Assessment input = new Assessment("123", bill);
		
		Assessment actual = service.assess(input);

		System.out.println(actual.getFacts());
		
	}

}
