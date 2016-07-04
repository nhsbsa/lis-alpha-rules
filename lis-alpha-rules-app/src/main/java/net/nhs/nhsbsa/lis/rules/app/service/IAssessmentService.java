package net.nhs.nhsbsa.lis.rules.app.service;

import uk.nhs.nhsbsa.lis.rules.v1.model.Assessment;

public interface IAssessmentService {

	Iterable<Assessment> list();

	Assessment get(String id);

	Assessment create();

	Assessment update(String id, Assessment model);

	void delete(String id);

}