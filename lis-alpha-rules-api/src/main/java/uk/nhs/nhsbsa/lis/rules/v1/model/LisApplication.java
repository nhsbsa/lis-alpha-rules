package uk.nhs.nhsbsa.lis.rules.v1.model;

import java.util.ArrayList;
import java.util.Date;

/**
 * The root class for a rules based LIS assessment.
 */
public class LisApplication {
	
	/**
	 * Assessment is based on claim date.
	 */
	private Date claimDate;
	
	/**
	 * Processing date
	 */
	private Date processingDate;
	
	/**
	 * Address.
	 */
	private Address address;
	
	/**
	 * Main applicant.
	 */
	private Person applicant;
	
	/**
	 * Partner
	 */
	private Person partner;
	
	/**
	 * Dependants
	 */
	private ArrayList<Person>dependants;
	
	/**
	 * Non-Dependants
	 */
	private ArrayList<Person>nonDependants;

	public Date getClaimDate() {
		return claimDate;
	}

	public void setClaimDate(Date claimDate) {
		this.claimDate = claimDate;
	}

	public Date getProcessingDate() {
		return processingDate;
	}

	public void setProcessingDate(Date processingDate) {
		this.processingDate = processingDate;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Person getApplicant() {
		return applicant;
	}

	public void setApplicant(Person applicant) {
		this.applicant = applicant;
	}

	public Person getPartner() {
		return partner;
	}

	public void setPartner(Person partner) {
		this.partner = partner;
	}

	public ArrayList<Person> getDependants() {
		return dependants;
	}

	public void setDependants(ArrayList<Person> dependants) {
		this.dependants = dependants;
	}

	public ArrayList<Person> getNonDependants() {
		return nonDependants;
	}

	public void setNonDependants(ArrayList<Person> nonDependants) {
		this.nonDependants = nonDependants;
	}

	
	
	
	/**
	 * Default constructor.
	 */
	public LisApplication() {
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString(){
		StringBuffer returnStr=new StringBuffer("claimDate:").append(claimDate)
				.append(" processingDate:").append(processingDate)
				.append(" address:").append(address)
				.append(" applicant:").append(applicant)
				.append(" partner:").append(partner);
		if(dependants!=null){
			dependants.forEach((dependant)->{returnStr.append(" dependant:").append(dependant);});
		}else{returnStr.append(" dependant:NONE");}
		if(nonDependants!=null){
			nonDependants.forEach((nonDependant)->{returnStr.append(" nonDependant:").append(nonDependant);});
		}else{returnStr.append(" nonDependant:NONE");}
		return returnStr.toString();
	}
	
}
