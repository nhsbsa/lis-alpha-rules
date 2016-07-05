package uk.nhs.nhsbsa.lis.rules.v1.droolsengine.service;

import uk.nhs.nhsbsa.lis.rules.v1.builder.PersonBuilder;
import uk.nhs.nhsbsa.lis.rules.v1.model.Benefit;
import uk.nhs.nhsbsa.lis.rules.v1.model.BenefitType;
import uk.nhs.nhsbsa.lis.rules.v1.model.LisApplication;
import uk.nhs.nhsbsa.lis.rules.v1.model.Person;
import uk.nhs.nhsbsa.lis.rules.v1.model.PersonType;

public class AssessmentFactoryService implements IAssessmentFactoryService {

	@Override
	public LisApplication defaultApplication() {
		
		LisApplication application = new LisApplication();
		return application;
	}

	@Override
	public Person defaultPerson(PersonType type) {
		PersonBuilder result = new PersonBuilder();
		result.withType(type);
		result
			.withName();
		return result.getInstance();
	}

	@Override
	public Benefit defaultBenefit(BenefitType type) {
		Benefit result = new Benefit();
		result.setType(type);
		return result;
	}
}
