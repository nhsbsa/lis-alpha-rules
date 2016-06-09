package net.nhs.nhsbsa.lis.rules.client;

import uk.nhs.nhsbsa.lis.rules.v1.model.Assessment;

public interface IAssessmentClient {

	public Assessment update(Assessment assessment);
}
