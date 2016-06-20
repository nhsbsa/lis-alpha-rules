package net.nhs.nhsbsa.lis.rules.app.service;

import uk.nhs.nhsbsa.rules.model.rules.Assessment;

public interface IAssessmentService {

	Iterable<Assessment> list();

	Assessment get(String id);

	Assessment create();

	Assessment update(String id, Assessment model);

}