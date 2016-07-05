package uk.nhs.nhsbsa.lis.rules.v1.droolsengine.service.session;

import org.kie.api.runtime.KieSession;

import uk.nhs.nhsbsa.lis.rules.v1.model.Assessment;
import uk.nhs.nhsbsa.util.ObjectIndex;

public class ObjectIndexSessionProcesser extends DefaultSessionProcessor {

	@Override
	public void preProcess(KieSession session, Assessment assessment) {
		
		ObjectIndex index = new ObjectIndex(assessment);
		session.insert(index);
	}

}
