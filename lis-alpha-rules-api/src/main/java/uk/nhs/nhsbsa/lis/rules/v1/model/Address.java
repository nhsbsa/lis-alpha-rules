package uk.nhs.nhsbsa.lis.rules.v1.model;

import uk.nhs.nhsbsa.rules.types.Field;

/**
 * Represents the address for which the assessment is being made.
 */
public class Address {

	/**
	 * Post code for address lookup
	 */
	private Field<String> postcode;
	
    /**
	 * House name or number.
	 */
	private Field<String> houseNameNumber;

    public Field<String> getPostcode() {
        return postcode;
    }

    public void setPostcode(Field<String> postcode) {
        this.postcode = postcode;
    }

    public Field<String> getHouseNameNumber() {
        return houseNameNumber;
    }

    public void setHouseNameNumber(Field<String> houseNameNumber) {
        this.houseNameNumber = houseNameNumber;
    }

}
