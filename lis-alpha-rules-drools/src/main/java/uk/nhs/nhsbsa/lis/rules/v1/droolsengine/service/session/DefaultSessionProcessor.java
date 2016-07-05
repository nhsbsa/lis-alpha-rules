package uk.nhs.nhsbsa.lis.rules.v1.droolsengine.service.session;

import org.kie.api.runtime.KieSession;

import uk.nhs.nhsbsa.lis.rules.v1.model.Assessment;

public class DefaultSessionProcessor implements ISessionProcessor {

	@Override
	public void preProcess(KieSession session, Assessment assessment) {
		//do nothing
	}

	@Override
	public void postProcess(KieSession session, Assessment assessment) {
		//do nothing
	}

}
