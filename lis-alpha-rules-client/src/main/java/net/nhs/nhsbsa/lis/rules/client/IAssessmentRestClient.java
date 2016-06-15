package net.nhs.nhsbsa.lis.rules.client;

import uk.nhs.nhsbsa.lis.rules.v1.model.Assessment;

public interface IAssessmentRestClient {

	public Assessment put(Assessment assessment);

	public Assessment post();
}
