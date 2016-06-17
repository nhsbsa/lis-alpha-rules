package uk.nhs.nhsbsa.lis.rules.v1.model;

import java.util.ArrayList;

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
	private ArrayList<String> addressLines;

	public ArrayList<String> getAddressLines() {
		return addressLines;
	}

	public void setAddressLines(ArrayList<String> addressLines) {
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
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString(){
		StringBuffer returnStr=new StringBuffer(" houseNameNumber:").append(houseNameNumber);
		if(addressLines!=null){
			addressLines.forEach((addressLine)->{returnStr.append(" addressLine:").append(addressLine);});
		}else{returnStr.append(" addressLine:NONE");}
		returnStr.append(" postcode").append(postcode);
		return returnStr.toString();
	}



}
