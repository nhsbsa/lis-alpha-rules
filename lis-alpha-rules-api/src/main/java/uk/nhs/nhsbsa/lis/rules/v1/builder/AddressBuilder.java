package uk.nhs.nhsbsa.lis.rules.v1.builder;

import java.util.Arrays;

import uk.nhs.nhsbsa.lis.rules.v1.model.Address;

public class AddressBuilder extends ModelBuilder<Address>{

	public AddressBuilder() {
		super();
	}

	public AddressBuilder(ModelBuilder<?> parent, String name, Address instance) {
		super(parent, name, instance);
	}

	public AddressBuilder withPostcode(String postcode) {
        getInstance().setPostcode(postcode);
        return this;
	}
	
	public AddressBuilder withHouseNameNumber(String houseNameNumber) {
        getInstance().setHouseNameNumber(houseNameNumber);
        return this;
	}
	
	public AddressBuilder withAddressLines(String... addressLines) {
        getInstance().setAddressLines(Arrays.asList(addressLines));
        return this;
	}
}
