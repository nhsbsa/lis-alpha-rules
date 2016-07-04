package uk.nhs.nhsbsa.lis.rules.v1.droolsengine.service;

import org.springframework.stereotype.Service;

import uk.nhs.nhsbsa.lis.rules.v1.builder.PersonBuilder;
import uk.nhs.nhsbsa.lis.rules.v1.model.LisApplication;
import uk.nhs.nhsbsa.lis.rules.v1.model.Person;
import uk.nhs.nhsbsa.lis.rules.v1.model.PersonType;

@Service
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
}
