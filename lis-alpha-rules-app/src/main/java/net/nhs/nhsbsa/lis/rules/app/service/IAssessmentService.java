package net.nhs.nhsbsa.lis.rules.app.service;

import uk.nhs.nhsbsa.lis.rules.v1.model.Assessment;

public interface IAssessmentService {

	Assessment getAssessment(String id);

}