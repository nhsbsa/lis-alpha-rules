package uk.nhs.nhsbsa.lis.rules.v1.builder;

import java.util.ArrayList;
import java.util.List;

import uk.nhs.nhsbsa.lis.rules.v1.model.Benefit;
import uk.nhs.nhsbsa.lis.rules.v1.model.Income;
import uk.nhs.nhsbsa.lis.rules.v1.model.Name;
import uk.nhs.nhsbsa.lis.rules.v1.model.Outgoing;
import uk.nhs.nhsbsa.lis.rules.v1.model.Person;
import uk.nhs.nhsbsa.lis.rules.v1.model.PersonType;

public class PersonBuilder extends AbstractBuilder<Person>{

	public PersonBuilder() {
		super();
	}

	public PersonBuilder(AbstractBuilder<?> parent, String name, Person instance) {
		super(parent, name, instance);
	}

	public PersonBuilder withType(PersonType type) {
		getInstance().setType(type);
		return this;
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
	
	public OutgoingsBuilder withOutgoings() {
		
		OutgoingsBuilder result = new OutgoingsBuilder(this, "outgoings", (List<Outgoing>)new ArrayList<Outgoing>());
		getInstance().setOutgoings(result.getInstance());
		return result;
	}

	public IncomesBuilder withIncomes() {
	
		IncomesBuilder result = new IncomesBuilder(this, "incomes", (List<Income>)new ArrayList<Income>());
		getInstance().setIncomes(result.getInstance());
		return result;
	}
}
