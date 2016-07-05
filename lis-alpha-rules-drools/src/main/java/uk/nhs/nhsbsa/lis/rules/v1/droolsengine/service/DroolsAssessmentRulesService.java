package uk.nhs.nhsbsa.lis.rules.v1.droolsengine.service;

import java.util.List;

import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import uk.nhs.nhsbsa.lis.rules.v1.IAssessmentRulesService;
import uk.nhs.nhsbsa.lis.rules.v1.droolsengine.service.session.ISessionProcessor;
import uk.nhs.nhsbsa.lis.rules.v1.model.Assessment;

public class DroolsAssessmentRulesService implements IAssessmentRulesService {

	private static final Logger LOGGER = LoggerFactory.getLogger(DroolsAssessmentRulesService.class);
	
	@Autowired
	private KieContainer kieContainer;
	
	@Autowired
	private List<ISessionProcessor> configServices;

	@Override
	public Assessment assess(Assessment assessment) {
		
		KieSession session = null;
		try {
			session = kieSession();
			preProcess(session, assessment);
			session.fireAllRules();
			postProcess(session, assessment);
			return assessment;
			
		} finally {
			if (session != null) {
				session.dispose();
			}
		}
		
	}

	private Object getFacts(KieSession session) {
		return null;
	}

	/**
	 * Delegate to preProcess the session.
	 * @param session
	 * @param assessment
	 */
	private void preProcess(KieSession session, Assessment assessment) {
		for (ISessionProcessor configurer : configServices) {
			configurer.preProcess(session, assessment);
		}
	}

	/**
	 * Delegate to postProcess the session.
	 * @param session
	 * @param assessment
	 */
	private void postProcess(KieSession session, Assessment assessment) {
		for (ISessionProcessor configurer : configServices) {
			configurer.postProcess(session, assessment);
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
