package uk.nhs.nhsbsa.lis.rules.v1.droolsengine.service.session;

import org.kie.api.runtime.KieSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import uk.nhs.nhsbsa.lis.rules.v1.droolsengine.service.IAssessmentFactoryService;
import uk.nhs.nhsbsa.lis.rules.v1.model.Assessment;

@Service
public class GlobalsSessionConfigService implements ISessionConfigService {

	private static final Logger RULE_LOGGER = LoggerFactory.getLogger("LisRules");

	@Autowired
	IAssessmentFactoryService assessmentFactoryService;
	
	@Override
	public void configure(KieSession session, Assessment assessment) {
		session.setGlobal("logger", RULE_LOGGER);
		session.setGlobal("factory", assessmentFactoryService);
	}

}
