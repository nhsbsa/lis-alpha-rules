package uk.nhs.nhsbsa.lis.rules.ws.service;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.time.LocalDate;

import org.junit.Ignore;
import org.junit.Test;

import uk.nhs.nhsbsa.lis.rules.v1.model.Assessment;

@Ignore
public class AssessmentRulesServiceTest {

	AssessmentRulesService service = new AssessmentRulesService();
	
	@Test(expected=NullPointerException.class)
	public void testNull() {

		service.assess(null);
	}

	@Test
	public void testDefault() {

		Assessment defaultAssessment = service.assess(new Assessment());
		assertNotNull(defaultAssessment.getApplication());
	}

	@Test
	public void testDoBRequiresPension() {

		Assessment input = service.assess(new Assessment());
		input.getApplication().getApplicant().setDob(LocalDate.parse("1950-01-01"));

		Assessment actual = service.assess(input);
		assertTrue(actual.getRequirements().isRequired("application.applicant.benefits[RETIREMENT_PENSION]"));
		
	}

}
