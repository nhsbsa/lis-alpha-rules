package uk.nhs.nhsbsa.lis.rules.v1.droolsengine.service.session;

import org.kie.api.runtime.KieSession;
import org.springframework.stereotype.Service;

import uk.nhs.nhsbsa.lis.rules.v1.model.Assessment;
import uk.nhs.nhsbsa.lis.rules.v1.model.LisApplication;
import uk.nhs.nhsbsa.lis.rules.v1.model.Person;

@Service
public class AssessmentSessionConfigService implements ISessionConfigService {

	@Override
	public void configure(KieSession session, Assessment assessment) {
		insert(session, assessment);
	}

	private void insert(KieSession session, Assessment assessment) {
		
		session.insert(assessment);
		insert(session, assessment.getApplication());
	}

	private void insert(KieSession session, LisApplication application) {

		session.insert(application);
		insert(session, application.getApplicant());
		insert(session, application.getPartner());
	}

	private void insert(KieSession session, Person person) {
		
		session.insert(person);
	}


}
