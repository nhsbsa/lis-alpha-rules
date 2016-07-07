package uk.nhs.nhsbsa.lis.rules.v1.droolsengine.service.session;

import org.drools.core.event.DefaultAgendaEventListener;
import org.kie.api.definition.rule.Rule;
import org.kie.api.event.rule.AfterMatchFiredEvent;
import org.kie.api.runtime.KieSession;

import uk.nhs.nhsbsa.lis.rules.v1.model.Assessment;

public class RuleLoggerListenerSessionProcesser extends DefaultSessionProcessor {

	private static class Listener extends DefaultAgendaEventListener {
		
		private Assessment assessment;

		public Listener(Assessment assessment) {
			super();
			this.assessment = assessment;
		}
		
		@Override
		public void afterMatchFired(AfterMatchFiredEvent event) {
			
			Rule rule = event.getMatch().getRule();
			assessment.getRules().add(rule.getName());
		}
	}
	
	@Override
	public void preProcess(KieSession session, Assessment assessment) {
		
		session.addEventListener(new Listener(assessment));
	}

}
