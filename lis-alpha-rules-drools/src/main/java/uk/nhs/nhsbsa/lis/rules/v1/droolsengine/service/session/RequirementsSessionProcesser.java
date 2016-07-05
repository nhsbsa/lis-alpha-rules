package uk.nhs.nhsbsa.lis.rules.v1.droolsengine.service.session;

import org.kie.api.runtime.KieSession;

import uk.nhs.nhsbsa.lis.rules.v1.model.Assessment;
import uk.nhs.nhsbsa.lis.rules.v1.model.Requirement;

public class RequirementsSessionProcesser extends DefaultSessionProcessor {

	@Override
	public void preProcess(KieSession session, Assessment assessment) {
		Requirement req = new Requirement();
		req.include("application");
		assessment.setRequirements(req);
	}

}
