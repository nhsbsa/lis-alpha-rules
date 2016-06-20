package uk.nhs.nhsbsa.lis.rules.v1.builder;

import java.util.ArrayList;
import java.util.List;

import uk.nhs.nhsbsa.lis.rules.v1.model.Benefit;
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
	
	public BenefitsBuilder withBenefits() {
		
		BenefitsBuilder result = new BenefitsBuilder(this, "benefits", (List<Benefit>)new ArrayList<Benefit>());
		getInstance().setBenefits(result.getInstance());
		return result;
	}
}
