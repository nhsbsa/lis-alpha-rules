package uk.nhs.nhsbsa.lis.rules.v1.builder;

import uk.nhs.nhsbsa.lis.rules.v1.model.Address;

public class AddressBuilder extends ModelBuilder<Address>{

	public AddressBuilder() {
		super();
	}

	public AddressBuilder(ModelBuilder<?> parent, Address instance) {
		super(parent, instance);
	}

	public AddressBuilder withPostcode(String postcode) {
		getInstance().setPostcode(postcode);
		return this;
	}
}
