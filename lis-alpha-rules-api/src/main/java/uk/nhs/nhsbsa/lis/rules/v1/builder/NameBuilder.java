package uk.nhs.nhsbsa.lis.rules.v1.builder;

import uk.nhs.nhsbsa.lis.rules.v1.model.Name;

public class NameBuilder extends AbstractBuilder<Name>{

	public NameBuilder() {
		super();
	}

	public NameBuilder(AbstractBuilder<?> parent, String name, Name instance) {
		super(parent, name, instance);
	}

	public NameBuilder withForenames(String forenames) {
		getInstance().setForenames(forenames);
		return this;
	}

	public NameBuilder withSurname(String surname) {
		getInstance().setSurname(surname);
		return this;
	}

	public NameBuilder withTitle(String title) {
		getInstance().setTitle(title);
		return this;
	}
}
