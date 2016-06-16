package uk.nhs.nhsbsa.lis.rules.v1.builder;

import java.util.ArrayList;

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
	
	public AddressBuilder withAddressLines(ArrayList<String> addressLines) {
        getInstance().setAddressLines(addressLines);
        return this;
	}
}
