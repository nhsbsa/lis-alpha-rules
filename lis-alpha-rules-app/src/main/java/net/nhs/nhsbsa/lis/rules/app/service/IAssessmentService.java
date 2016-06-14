package net.nhs.nhsbsa.lis.rules.app.service;

import net.nhs.nhsbsa.lis.rules.app.model.AssessmentModel;

public interface IAssessmentService {

	Iterable<AssessmentModel> list();

	AssessmentModel get(String id);

	AssessmentModel create();

	AssessmentModel update(String id, AssessmentModel model);

}