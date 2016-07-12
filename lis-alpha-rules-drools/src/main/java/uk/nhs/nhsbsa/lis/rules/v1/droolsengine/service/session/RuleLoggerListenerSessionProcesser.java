package uk.nhs.nhsbsa.lis.rules.v1.droolsengine.service.session;

import org.drools.core.event.DefaultAgendaEventListener;
import org.kie.api.definition.rule.Rule;
import org.kie.api.event.rule.AfterMatchFiredEvent;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.rule.Match;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import uk.nhs.nhsbsa.lis.rules.v1.model.Assessment;

public class RuleLoggerListenerSessionProcesser extends DefaultSessionProcessor {

	private static final Logger LOGGER = LoggerFactory.getLogger(RuleLoggerListenerSessionProcesser.class);
	
	private static class Listener extends DefaultAgendaEventListener {
		
		private Assessment assessment;

		public Listener(Assessment assessment) {
			super();
			this.assessment = assessment;
		}
		
		@Override
		public void afterMatchFired(AfterMatchFiredEvent event) {

			String rule = toString(event);
			assessment.getRules().add(rule);
		}

		private String toString(AfterMatchFiredEvent event) {

			StringBuilder result = new StringBuilder();
			Match match = event.getMatch();
			
			Rule rule = match.getRule();
			result.append(rule.getName());

//			List<?> objects = match.getObjects();
//			if (!CollectionUtils.isEmpty(objects)) {
//				result.append(" ").append(objects);
//			}
			LOGGER.info("Rule match: {}", rule.getName());
			return result.toString();
		}
	}
	
	@Override
	public void preProcess(KieSession session, Assessment assessment) {
		
		session.addEventListener(new Listener(assessment));
	}

}
