package uk.nhs.nhsbsa.lis.rules.v1.droolsengine.service.session;

import java.util.List;

import org.kie.api.runtime.KieSession;

import uk.nhs.nhsbsa.lis.rules.v1.model.Assessment;
import uk.nhs.nhsbsa.lis.rules.v1.model.application.Benefit;
import uk.nhs.nhsbsa.lis.rules.v1.model.application.Income;
import uk.nhs.nhsbsa.lis.rules.v1.model.application.Application;
import uk.nhs.nhsbsa.lis.rules.v1.model.application.Outgoing;
import uk.nhs.nhsbsa.lis.rules.v1.model.application.Person;

public class SessionFactInputProcesser extends DefaultSessionProcessor {

	@Override
	public void preProcess(KieSession session, Assessment assessment) {
		insert(session, assessment);
	}

	private void insert(KieSession session, Assessment assessment) {
		session.insert(assessment);
		insert(session, assessment.getApplication());
	}

	private void insert(KieSession session, Application application) {

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
			insertIncomes(session, person.getIncomes());
			insertOutgoings(session, person.getOutgoings());
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

	private void insertIncomes(KieSession session, List<Income> incomes) {

		if (incomes != null) {
			for (Income income : incomes) {
				insert(session, income);
			}
		}
	}

	private void insert(KieSession session, Income income) {

		session.insert(income);
	}

	private void insertOutgoings(KieSession session, List<Outgoing> outgoings) {

		if (outgoings != null) {
			for (Outgoing outgoing : outgoings) {
				insert(session, outgoing);
			}
		}
	}

	private void insert(KieSession session, Outgoing outgoing) {

		session.insert(outgoing);
	}


}
