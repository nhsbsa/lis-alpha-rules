package uk.nhs.nhsbsa.lis.rules.v1.droolsengine.service.session;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.drools.core.ObjectFilter;
import org.kie.api.runtime.KieSession;

import uk.nhs.nhsbsa.lis.rules.v1.model.Assessment;

public class SessionFactOutputProcessor extends DefaultSessionProcessor {

	private ObjectFilter filter = new ObjectFilter() {
		@Override
		public boolean accept(Object o) {
			String pkg = o.getClass().getPackage().getName();
			return "uk.nhs.nhsbsa.lis.rules.v1.droolsengine.model".equals(pkg);
		}
	};
	
	@Override
	public void postProcess(KieSession session, Assessment assessment) {

		List<Object> facts = extractFacts(session);
		assessment.setWorkingData(facts);
	}

	private List<Object> extractFacts(KieSession session) {
		List<Object> result = new ArrayList<>();
		Collection<?> facts = session.getObjects(filter);
		for (Object fact : facts) {
			result.add(fact.toString());
		}
		return result;
	}

}
