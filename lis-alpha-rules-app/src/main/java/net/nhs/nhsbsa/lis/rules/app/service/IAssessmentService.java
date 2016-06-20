package net.nhs.nhsbsa.lis.rules.app.service;

import net.nhs.nhsbsa.lis.rules.app.model.AssessmentModel;
import uk.nhs.nhsbsa.rules.model.rules.Assessment;

public interface IAssessmentService {

	Iterable<Assessment> list();

	AssessmentModel get(String id);

	AssessmentModel create();

	AssessmentModel update(String id, AssessmentModel model);

}