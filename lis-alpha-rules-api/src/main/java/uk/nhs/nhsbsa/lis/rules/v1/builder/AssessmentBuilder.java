package uk.nhs.nhsbsa.lis.rules.v1.builder;

import uk.nhs.nhsbsa.lis.rules.v1.model.Assessment;

public class AssessmentBuilder extends ModelBuilder<Assessment> {

	
	public AssessmentBuilder() {
		super();
	}
	
	public AssessmentBuilder(String id) {
		super();
		instance.setId(id);
	}
	
	public AddressBuilder withAddress() {
		
		AddressBuilder result = new AddressBuilder(this, "name", null);
		instance.setAddress(result.getField());
		return result;
	}

	public PersonBuilder withApplicant() {
		
		PersonBuilder result = new PersonBuilder(this, "applicant", null);
		instance.setApplicant(result.getField());
		return result;
	}
}
