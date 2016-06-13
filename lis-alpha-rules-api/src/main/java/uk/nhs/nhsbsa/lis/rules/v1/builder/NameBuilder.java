package uk.nhs.nhsbsa.lis.rules.v1.builder;

import uk.nhs.nhsbsa.lis.rules.v1.model.Name;
import uk.nhs.nhsbsa.rules.types.Field;

public class NameBuilder extends ModelBuilder<Name>{

	public NameBuilder() {
		super();
	}

	public NameBuilder(ModelBuilder<?> parent, String name, Name instance) {
		super(parent, name, instance);
	}

	public NameBuilder withForenames(String forenames) {
		getInstance().setForenames(new Field<>("forenames", forenames));
		return this;
	}

	public NameBuilder withSurname(String surname) {
		getInstance().setSurname(new Field<>("surname", surname));
		return this;
	}

	public NameBuilder withTitle(String title) {
		getInstance().setTitle(new Field<>("title", title));
		return this;
	}
}
