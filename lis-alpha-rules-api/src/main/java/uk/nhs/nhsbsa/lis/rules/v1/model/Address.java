package uk.nhs.nhsbsa.lis.rules.v1.model;

import java.util.ArrayList;
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
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString(){
		StringBuffer returnStr=new StringBuffer(" houseNameNumber:").append(houseNameNumber);
		if(addressLines!=null){
			addressLines.forEach((addressLine)->{returnStr.append(" addressLine:").append(addressLine);});
		}else{returnStr.append(" addressLine:NONE");}
		returnStr.append(" postcode:").append(postcode);
		return returnStr.toString();
	}
	
	/**
	 * Return a JSON string representation of an address
	 * @return
	 */
	public String toJSONString(){
		StringBuffer returnStr=new StringBuffer("{ \"houseNameNumber\":\"").append(houseNameNumber);
		returnStr.append("\", \"addressLines\":[");
		if(addressLines!=null){
			boolean firstIteration=true;
			for(String addressLine : addressLines){
				if(firstIteration==true){firstIteration=false;}
				else{returnStr.append(",");}
				returnStr.append("{ \"addressLine\":\"").append(addressLine).append("\"}");
			}
		}
		//else{returnStr.append(" addressLine:NONE");}
		returnStr.append("],");
		returnStr.append(" \"postcode\":\"").append(postcode).append("\" }");
		return returnStr.toString();
	}



}
