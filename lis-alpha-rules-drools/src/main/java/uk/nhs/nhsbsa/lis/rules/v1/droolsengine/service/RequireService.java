package uk.nhs.nhsbsa.lis.rules.v1.droolsengine.service;

import uk.nhs.nhsbsa.lis.rules.v1.model.Assessment;
import uk.nhs.nhsbsa.util.ObjectIndex;

public class RequireService implements IRequireService {

	@Override
	public void enable(Assessment assessment, ObjectIndex index, Object o) {
		String path = index.path(o);
		assessment.getRequirements().include(path);
	}

	@Override
	public void disable(Assessment assessment, ObjectIndex index, Object o) {
		String path = index.path(o);
		assessment.getRequirements().exclude(path);
	}

}
