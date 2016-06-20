package uk.nhs.nhsbsa.lis.rules.v1.builder;

import uk.nhs.nhsbsa.lis.rules.v1.model.Name;
import uk.nhs.nhsbsa.lis.rules.v1.model.Person;

public class PersonBuilder extends ModelBuilder<Person>{

	public PersonBuilder() {
		super();
	}

	public PersonBuilder(ModelBuilder<?> parent, String name, Person instance) {
		super(parent, name, instance);
	}

	public NameBuilder withName() {

		NameBuilder result = new NameBuilder(this, "name", new Name());
		getInstance().setName(result.getInstance());
		return result;
	}
}
