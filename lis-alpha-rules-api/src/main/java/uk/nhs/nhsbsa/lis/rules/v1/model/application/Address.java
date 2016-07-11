package uk.nhs.nhsbsa.lis.rules.v1.model.application;

/**
 * Represents the address for which the assessment is being made.
 */
public class Address {

	/**
	 * House name or number.
	 */
	private String houseNameNumber;
	
	/**
	 * Address line 1.
	 * @return
	 */
	private String addressLine1;
	
	/**
	 * Address line 1.
	 * @return
	 */
	private String addressLine2;
	
	/**
	 * Address line 1.
	 * @return
	 */
	private String addressLine3;
	
	/**
	 * Post code for address lookup
	 */
	private String postcode;

	public String getPostcode() {
		return postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	public String getHouseNameNumber() {
		return houseNameNumber;
	}

	/**
	 * @param houseNameNumber
	 */
	public void setHouseNameNumber(String houseNameNumber) {
		this.houseNameNumber = houseNameNumber;
	}

	public String getAddressLine1() {
		return addressLine1;
	}

	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	public String getAddressLine2() {
		return addressLine2;
	}

	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}

	public String getAddressLine3() {
		return addressLine3;
	}

	public void setAddressLine3(String addressLine3) {
		this.addressLine3 = addressLine3;
	}

	@Override
	public String toString() {
		return "Address [houseNameNumber=" + houseNameNumber + ", addressLine1=" + addressLine1 + ", addressLine2="
				+ addressLine2 + ", addressLine3=" + addressLine3 + ", postcode=" + postcode + "]";
	}
	

}
