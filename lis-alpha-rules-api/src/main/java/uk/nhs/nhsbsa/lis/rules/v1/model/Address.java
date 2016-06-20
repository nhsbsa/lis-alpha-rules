package uk.nhs.nhsbsa.lis.rules.v1.model;

import java.util.List;

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
	
	/**
	 * Address lines
	 * @return
	 */
	private List<String> addressLines;

	public List<String> getAddressLines() {
		return addressLines;
	}

	public void setAddressLines(List<String> addressLines) {
		this.addressLines = addressLines;
	}

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

	@Override
	public String toString() {
		return "Address [postcode=" + postcode + ", houseNameNumber=" + houseNameNumber + ", addressLines="
				+ addressLines + "]";
	}
	

}
