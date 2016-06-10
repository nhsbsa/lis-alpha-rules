package uk.nhs.nhsbsa.lis.rules.v1.builder;

import uk.nhs.nhsbsa.lis.rules.v1.model.Person;

public class PersonBuilder extends ModelBuilder<Person>{

	public PersonBuilder() {
		super();
	}

	public PersonBuilder(ModelBuilder<?> parent, Person instance) {
		super(parent, instance);
	}

	public NameBuilder withName() {

		NameBuilder result = new NameBuilder(this, null);
		instance.setName(result.getField());
		return result;
	}
}
