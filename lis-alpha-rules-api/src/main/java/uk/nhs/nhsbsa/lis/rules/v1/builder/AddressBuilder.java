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
        getInstance().setAddressLine1(getLine(addressLines, 0));
        getInstance().setAddressLine2(getLine(addressLines, 1));
        getInstance().setAddressLine3(getLine(addressLines, 2));
        return this;
	}

	private String getLine(String[] addressLines, int index) {
		if (addressLines.length > index) {
			return addressLines[index];
		}
		return null;
	}
}
