package uk.nhs.nhsbsa.lis.rules.v1;

import uk.nhs.nhsbsa.lis.rules.v1.model.Assessment;

@FunctionalInterface
public interface IAssessmentRulesService {

	Assessment assess(Assessment assessment);
}
