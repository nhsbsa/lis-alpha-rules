package uk.nhs.nhsbsa.lis.rules.v1.droolsengine.service.session;

import java.util.Iterator;
import java.util.List;

import org.kie.api.runtime.KieSession;

import uk.nhs.nhsbsa.lis.rules.v1.model.Assessment;
import uk.nhs.nhsbsa.lis.rules.v1.model.Benefit;
import uk.nhs.nhsbsa.lis.rules.v1.model.LisApplication;
import uk.nhs.nhsbsa.lis.rules.v1.model.Person;

public class SessionFactInputProcesser extends DefaultSessionProcessor {

	@Override
	public void preProcess(KieSession session, Assessment assessment) {
		insert(session, assessment);
	}

	private void insert(KieSession session, Assessment assessment) {
		session.insert(assessment);
		insert(session, assessment.getApplication());
	}

	private void insert(KieSession session, LisApplication application) {

		if (application != null) {
			session.insert(application);
			insert(session, application.getApplicant());
			insert(session, application.getPartner());
		}
	}

	private void insert(KieSession session, Person person) {
		if (person != null) {
			session.insert(person);
			insertBenefits(session, person.getBenefits());
		}
	}

	private void insertBenefits(KieSession session, List<Benefit> benefits) {

		if (benefits != null) {
			for (Benefit benefit : benefits) {
				insert(session, benefit);
			}
		}
	}

	private void insert(KieSession session, Benefit benefit) {

		session.insert(benefit);
	}


}
