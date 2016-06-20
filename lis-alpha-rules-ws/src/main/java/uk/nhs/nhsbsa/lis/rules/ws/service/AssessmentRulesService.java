package uk.nhs.nhsbsa.lis.rules.ws.service;

import org.springframework.stereotype.Service;

import uk.nhs.nhsbsa.lis.rules.v1.builder.LisApplicationBuilder;
import uk.nhs.nhsbsa.lis.rules.v1.model.LisApplication;
import uk.nhs.nhsbsa.rules.model.rules.Assessment;

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
		return result;
	}

	private LisApplication defaultApplication() {
		
		LisApplicationBuilder builder = new LisApplicationBuilder();
		builder.withAddress()
			.withAddressLines("", "", "");
		builder.withApplicant()
			.withName();
		return builder.getInstance();
	}
}
