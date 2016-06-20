package uk.nhs.nhsbsa.lis.rules.v1.builder;

import uk.nhs.nhsbsa.lis.rules.v1.model.Address;
import uk.nhs.nhsbsa.lis.rules.v1.model.LisApplication;
import uk.nhs.nhsbsa.lis.rules.v1.model.Person;

public class LisApplicationBuilder extends ModelBuilder<LisApplication> {

	
	public LisApplicationBuilder() {
		super();
	}
	
	/**
	 * Empty Address to prevent AssessmentController from breaking
	 * @return
	 */
	public AddressBuilder withAddress() {
		
		AddressBuilder result = new AddressBuilder(this, "name", null);
		getInstance().setAddress(new Address());
		return result;
	}
	
	public AddressBuilder withAddress(Address address) {
		
		AddressBuilder result = new AddressBuilder(this, "name", null);
		getInstance().setAddress(address);
		return result;
	}

	public PersonBuilder withApplicant(Person person) {
		
		PersonBuilder result = new PersonBuilder(this, "applicant", null);
		getInstance().setApplicant(person);
		return result;
	}
}
