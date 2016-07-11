package uk.nhs.nhsbsa.lis.rules.v1.droolsengine.service;

import uk.nhs.nhsbsa.lis.rules.v1.builder.PersonBuilder;
import uk.nhs.nhsbsa.lis.rules.v1.model.application.Benefit;
import uk.nhs.nhsbsa.lis.rules.v1.model.application.BenefitType;
import uk.nhs.nhsbsa.lis.rules.v1.model.application.Income;
import uk.nhs.nhsbsa.lis.rules.v1.model.application.IncomeType;
import uk.nhs.nhsbsa.lis.rules.v1.model.application.LisApplication;
import uk.nhs.nhsbsa.lis.rules.v1.model.application.Outgoing;
import uk.nhs.nhsbsa.lis.rules.v1.model.application.OutgoingType;
import uk.nhs.nhsbsa.lis.rules.v1.model.application.Person;
import uk.nhs.nhsbsa.lis.rules.v1.model.application.PersonType;

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
	
	@Override
	public Income defaultIncome(IncomeType type) {
		Income result = new Income();
		result.setType(type);
		return result;
	}
	
	@Override
	public Outgoing defaultOutgoing(OutgoingType type) {
		Outgoing result = new Outgoing();
		result.setType(type);
		return result;
	}
}
