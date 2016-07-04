package uk.nhs.nhsbsa.lis.rules.v1.droolsengine.service;

import org.kie.api.runtime.KieSession;

import uk.nhs.nhsbsa.lis.rules.v1.model.Assessment;

public interface ISessionConfigService {

	void configure(KieSession session, Assessment assessment);
}
