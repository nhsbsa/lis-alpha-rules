package uk.nhs.nhsbsa.lis.rules.v1.droolsengine.service;

import org.springframework.stereotype.Service;

import uk.nhs.nhsbsa.lis.rules.v1.IAssessmentRulesService;
import uk.nhs.nhsbsa.lis.rules.v1.model.Assessment;

@Service
public class DroolsAssessmentRulesService implements IAssessmentRulesService {

	@Override
	public Assessment assess(Assessment assessment) {
		
		return assessment;
	}
}
