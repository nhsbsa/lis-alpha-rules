package uk.nhs.nhsbsa.lis.rules.v1.droolsengine.service.session;

import org.kie.api.runtime.KieSession;

import uk.nhs.nhsbsa.lis.rules.v1.model.Assessment;

public interface ISessionProcessor {

	void preProcess(KieSession session, Assessment assessment);

	void postProcess(KieSession session, Assessment assessment);
}
