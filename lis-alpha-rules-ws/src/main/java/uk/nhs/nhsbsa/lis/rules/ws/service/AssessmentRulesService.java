package uk.nhs.nhsbsa.lis.rules.ws.service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import uk.nhs.nhsbsa.lis.rules.v1.IAssessmentRulesService;
import uk.nhs.nhsbsa.lis.rules.v1.builder.LisApplicationBuilder;
import uk.nhs.nhsbsa.lis.rules.v1.builder.PersonBuilder;
import uk.nhs.nhsbsa.lis.rules.v1.model.Assessment;
import uk.nhs.nhsbsa.lis.rules.v1.model.BenefitType;
import uk.nhs.nhsbsa.lis.rules.v1.model.LisApplication;
import uk.nhs.nhsbsa.lis.rules.v1.model.Person;
import uk.nhs.nhsbsa.lis.rules.v1.model.Requirement;

@Service
public class AssessmentRulesService implements IAssessmentRulesService {

	private static final Logger LOGGER = LoggerFactory.getLogger(AssessmentRulesService.class);
	
	@Autowired
	private List<IAssessmentRulesService> delegates;
	
	@Override
	public Assessment assess(Assessment assessment) {

		Assessment result = null;
		for (IAssessmentRulesService delegate : delegates) {
			if (this != delegate) {
				result = delegate.assess(assessment);
				if (result != null) {
					LOGGER.info("Assessment provided by {}", delegate.getClass().getName());
					break;
				}
			}
		}
		
		if (result == null) {
			LOGGER.info("Assessment provided by {}", getClass().getName());
			result = assessInternal(assessment);
		}
		
		return result;
	}
	
	private Assessment assessInternal(Assessment assessment) {
		
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
