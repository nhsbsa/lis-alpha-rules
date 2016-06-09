package net.nhs.nhsbsa.lis.rules.client;

import uk.nhs.nhsbsa.lis.rules.v1.model.Assessment;

public class AssessmentClient implements IAssessmentClient {

	@Override
	public Assessment update(Assessment assessment) {
		return assessment;
	}

}
