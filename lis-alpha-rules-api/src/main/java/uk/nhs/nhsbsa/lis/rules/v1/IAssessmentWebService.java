package uk.nhs.nhsbsa.lis.rules.v1;

import uk.nhs.nhsbsa.rules.model.rules.Assessment;

public interface IAssessmentWebService {

	public Assessment put(String id, Assessment assessment);

	Assessment get(String id);
}
