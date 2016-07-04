package uk.nhs.nhsbsa.lis.rules.v1.droolsengine.service;

import uk.nhs.nhsbsa.lis.rules.v1.model.LisApplication;
import uk.nhs.nhsbsa.lis.rules.v1.model.Person;
import uk.nhs.nhsbsa.lis.rules.v1.model.PersonType;

public interface IAssessmentFactoryService {

	LisApplication defaultApplication();
	
	Person defaultPerson(PersonType type);

}
