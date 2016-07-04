package uk.nhs.nhsbsa.lis.rules.v1;

import uk.nhs.nhsbsa.lis.rules.v1.model.Assessment;
import uk.nhs.nhsbsa.lis.rules.v1.model.LisApplication;

public interface IAssessmentWebService {

	/**
	 * POST an LISApplication to create a new Assessment.
	 * @param application
	 * @return
	 */
	public Assessment post(LisApplication application);

	/**
	 * GET a default Assessment by ID.
	 * @param id
	 * @return
	 */
	public Assessment get(String id);

	/**
	 * Update an assessment.
	 * @param id
	 * @param assessment
	 * @return
	 */
	public Assessment put(String id, Assessment assessment);

}
