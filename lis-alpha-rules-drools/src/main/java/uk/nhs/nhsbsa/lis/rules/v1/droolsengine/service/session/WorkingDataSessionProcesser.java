package uk.nhs.nhsbsa.lis.rules.v1.droolsengine.service.session;

import java.util.ArrayList;

import org.drools.core.event.DefaultRuleRuntimeEventListener;
import org.kie.api.runtime.KieSession;

import uk.nhs.nhsbsa.lis.rules.v1.model.Assessment;

public class WorkingDataSessionProcesser extends DefaultSessionProcessor {

	private static class Listener extends DefaultRuleRuntimeEventListener {
		
		private Assessment assessment;

		public Listener(Assessment assessment) {
			super();
			this.assessment = assessment;
		}
		
		@Override
		public void objectInserted(org.kie.api.event.rule.ObjectInsertedEvent event) {
			String data = event.getObject().toString();
			assessment.getWorkingData().add(data);
		}
	}
	
	@Override
	public void preProcess(KieSession session, Assessment assessment) {
		
        //working data
        assessment.setWorkingData(new ArrayList<>());
        
		session.addEventListener(new Listener(assessment));
	}

}
