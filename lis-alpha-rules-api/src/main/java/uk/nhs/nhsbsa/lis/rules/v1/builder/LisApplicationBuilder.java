package uk.nhs.nhsbsa.lis.rules.v1.builder;

import uk.nhs.nhsbsa.lis.rules.v1.model.application.Address;
import uk.nhs.nhsbsa.lis.rules.v1.model.application.LisApplication;
import uk.nhs.nhsbsa.lis.rules.v1.model.application.Person;

public class LisApplicationBuilder extends AbstractBuilder<LisApplication> {

	
	public LisApplicationBuilder() {
		super();
	}
	
	/**
	 * Empty Address to prevent AssessmentController from breaking
	 * @return
	 */
	public AddressBuilder withAddress() {
		
		AddressBuilder result = new AddressBuilder(this, "name", new Address());
		getInstance().setAddress(result.getInstance());
		return result;
	}
	
	public PersonBuilder withApplicant() {
		
		PersonBuilder result = new PersonBuilder(this, "applicant", new Person());
		getInstance().setApplicant(result.getInstance());
		return result;
	}
	
}
