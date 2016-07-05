package uk.nhs.nhsbsa.lis.rules.v1.droolsengine.service;

import uk.nhs.nhsbsa.lis.rules.v1.model.Assessment;
import uk.nhs.nhsbsa.util.ObjectIndex;

public interface IRequireService {

	void enable(Assessment assessment, ObjectIndex index, Object o);

	void disable(Assessment assessment, ObjectIndex index, Object o);
}
