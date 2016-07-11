package uk.nhs.nhsbsa.lis.rules.v1.droolsengine.service;

import uk.nhs.nhsbsa.lis.rules.v1.model.application.Benefit;
import uk.nhs.nhsbsa.lis.rules.v1.model.application.BenefitType;
import uk.nhs.nhsbsa.lis.rules.v1.model.application.Income;
import uk.nhs.nhsbsa.lis.rules.v1.model.application.IncomeType;
import uk.nhs.nhsbsa.lis.rules.v1.model.application.LisApplication;
import uk.nhs.nhsbsa.lis.rules.v1.model.application.Outgoing;
import uk.nhs.nhsbsa.lis.rules.v1.model.application.OutgoingType;
import uk.nhs.nhsbsa.lis.rules.v1.model.application.Person;
import uk.nhs.nhsbsa.lis.rules.v1.model.application.PersonType;

public interface IAssessmentFactoryService {

	LisApplication defaultApplication();
	
	Person defaultPerson(PersonType type);

	Benefit defaultBenefit(BenefitType type);
	
	Income defaultIncome(IncomeType type);
	
	Outgoing defaultOutgoing(OutgoingType type);
}
