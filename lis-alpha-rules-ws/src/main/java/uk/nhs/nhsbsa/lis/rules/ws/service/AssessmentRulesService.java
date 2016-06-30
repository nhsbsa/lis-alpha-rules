package uk.nhs.nhsbsa.lis.rules.ws.service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import org.springframework.stereotype.Service;

import uk.nhs.nhsbsa.lis.rules.v1.builder.LisApplicationBuilder;
import uk.nhs.nhsbsa.lis.rules.v1.builder.PersonBuilder;
import uk.nhs.nhsbsa.lis.rules.v1.model.Assessment;
import uk.nhs.nhsbsa.lis.rules.v1.model.BenefitType;
import uk.nhs.nhsbsa.lis.rules.v1.model.LisApplication;
import uk.nhs.nhsbsa.lis.rules.v1.model.Person;
import uk.nhs.nhsbsa.lis.rules.v1.model.Requirement;

@Service
public class AssessmentRulesService implements IAssessmentRulesService {

	@Override
	public Assessment assess(Assessment assessment) {
		
		//create a response assessment
		Assessment result = new Assessment();
		if (assessment.getApplication() == null) {
			result.setApplication(defaultApplication());
		} else {
			result.setApplication(assessment.getApplication());
		}
		
		//handle required fields
		updateRequired(result);
		
		return result;
	}

	private void updateRequired(Assessment result) {
		
		Requirement requirements = new Requirement();
		requirements.include("application.address");
		requirements.include("application.applicant");
		requirements.exclude("application.applicant.benefits");
		
		//handle pensionable applicants
		applyPensionableRequirements(requirements, result.getApplication().getApplicant());
		
		result.setRequirements(requirements);
	}

	private void applyPensionableRequirements(Requirement requirements, Person applicant) {
		
		LocalDate dob = applicant.getDob();
		if (dob != null) {
			long age = ChronoUnit.YEARS.between(dob, LocalDate.now());
			if (age > 60) {
				requirements.include("application.applicant.benefits[RETIREMENT_PENSION]");
			}
		}
	}

	private LisApplication defaultApplication() {
		
		LisApplicationBuilder builder = new LisApplicationBuilder();
		builder.withAddress()
			.withAddressLines("", "", "");
		PersonBuilder applicant = builder.withApplicant();
		applicant
			.withName();
		applicant.withBenefits()
			.add().withBenefitType(BenefitType.RETIREMENT_PENSION)
			;
		return builder.getInstance();
	}
}
