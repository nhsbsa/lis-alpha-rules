package rules;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.time.LocalDate;

import org.junit.Before;
import org.junit.Test;

import uk.nhs.nhsbsa.lis.rules.v1.model.Assessment;
import uk.nhs.nhsbsa.lis.rules.v1.model.application.Application;
import uk.nhs.nhsbsa.lis.rules.v1.model.application.BillPersonaTestData;
import uk.nhs.nhsbsa.lis.rules.v1.model.flow.Requirement;

public class BenefitsTest extends AbstractRulesTest {

	private Application bill;
	
	@Before
	public void setup() {
		
		bill = new BillPersonaTestData().createApplication();
		bill.setClaimDate(LocalDate.now());
		bill.getApplicant().setDob(bill.getClaimDate().minusYears(20));
	}
	
	@Test
	public void testPensionerDefaultStatePension() {

		bill.getApplicant().setDob(bill.getClaimDate().minusYears(70));
		Assessment input = new Assessment("123", bill);
		
		Assessment actual = service.assess(input);

		assertEquals(1, actual.getApplication().getApplicant().getBenefits().size());
	}

	@Test
	public void testEnablePensionerStatePension() {

		bill.getApplicant().setDob(bill.getClaimDate().minusYears(70));
		Assessment input = new Assessment("123", bill);
		
		Assessment actual = service.assess(input);

		Requirement req = actual.getRequirements();
		assertTrue(req.toString(), req.isRequired("application.applicant.benefits[0]"));
	}

	@Test
	public void testDisablePensionerStatePension() {

		bill.getApplicant().setDob(bill.getClaimDate().minusYears(20)); 
		Assessment input = new Assessment("123", bill);
		
		Assessment actual = service.assess(input);

		Requirement req = actual.getRequirements();
		assertFalse(req.isRequired("application.applicant.benefits[0]"));
	}

}
