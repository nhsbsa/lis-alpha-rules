package rules;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.time.LocalDate;

import org.junit.Before;
import org.junit.Test;

import uk.nhs.nhsbsa.lis.rules.v1.model.Assessment;
import uk.nhs.nhsbsa.lis.rules.v1.model.application.BillPersonaTestData;
import uk.nhs.nhsbsa.lis.rules.v1.model.application.LisApplication;

public class AgeStatusTest extends AbstractRulesTest {

	private LisApplication bill;
	
	@Before
	public void setup() {
		
		bill = new BillPersonaTestData().createApplication();
		bill.setClaimDate(LocalDate.now());
		bill.getApplicant().setDob(bill.getClaimDate().minusYears(20));
	}
	
	@Test
	public void testAge() {

		Assessment input = new Assessment("123", bill);
		
		Assessment actual = service.assess(input);

		System.out.println(actual.getWorkingData());
		
		assertTrue(actual.getWorkingData().contains("[Mr Bill Smith MAIN_APPLICANT] age = 20"));
	}

	@Test
	public void testPensioner_true() {

		bill.getApplicant().setDob(bill.getClaimDate().minusYears(70));
		Assessment input = new Assessment("123", bill);
		
		Assessment actual = service.assess(input);

		System.out.println(actual.getWorkingData());
		
		assertTrue(actual.getWorkingData().contains("[Mr Bill Smith MAIN_APPLICANT] is a Pensioner"));
	}

	@Test
	public void testPensioner_false() {

		LisApplication bill = new BillPersonaTestData().createApplication();
		bill.getApplicant().setDob(LocalDate.now().minusYears(20));
		Assessment input = new Assessment("123", bill);
		
		Assessment actual = service.assess(input);

		System.out.println(actual.getWorkingData());
		
		assertFalse(actual.getWorkingData().contains("[Mr Bill Smith MAIN_APPLICANT] is a Pensioner"));
	}

}
