package uk.nhs.nhsbsa.lis.rules.v1.droolsengine.service;

import java.util.List;

import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import uk.nhs.nhsbsa.lis.rules.v1.IAssessmentRulesService;
import uk.nhs.nhsbsa.lis.rules.v1.droolsengine.service.session.ISessionConfigService;
import uk.nhs.nhsbsa.lis.rules.v1.model.Assessment;

@Service
public class DroolsAssessmentRulesService implements IAssessmentRulesService {

	private static final Logger LOGGER = LoggerFactory.getLogger(DroolsAssessmentRulesService.class);
	
	@Autowired
	private KieContainer kieContainer;
	
	@Autowired
	private List<ISessionConfigService> configServices;

	@Override
	public Assessment assess(Assessment assessment) {
		
		KieSession session = null;
		try {
			session = kieSession();
			configure(session, assessment);
			session.fireAllRules();
			return assessment;
			
		} finally {
			if (session != null) {
				session.dispose();
			}
		}
		
	}

	/**
	 * Delegate to config the session.
	 * @param session
	 * @param assessment
	 */
	private void configure(KieSession session, Assessment assessment) {
		for (ISessionConfigService configurer : configServices) {
			configurer.configure(session, assessment);
		}
	}

	/**
	 * New stateful KieSession for every request as they are not threadsafe across multiple requests.
	 * @return
	 */
	private KieSession kieSession() {
		KieSession result = kieContainer.newKieSession();
		LOGGER.info("Created KieSession {}", result);
		return result;
	}


}
