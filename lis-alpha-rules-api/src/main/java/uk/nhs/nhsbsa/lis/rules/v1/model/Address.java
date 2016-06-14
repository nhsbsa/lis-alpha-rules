package uk.nhs.nhsbsa.lis.rules.v1.model;

/**
 * Represents the address for which the assessment is being made.
 */
public class Address {

	/**
	 * Post code for address lookup
	 */
	private String postcode;
	
	/**
	 * House name or number.
	 */
	private String houseNameNumber;

	public String getPostcode() {
		return postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	public String getHouseNameNumber() {
		return houseNameNumber;
	}

	public void setHouseNameNumber(String houseNameNumber) {
		this.houseNameNumber = houseNameNumber;
	}
}
