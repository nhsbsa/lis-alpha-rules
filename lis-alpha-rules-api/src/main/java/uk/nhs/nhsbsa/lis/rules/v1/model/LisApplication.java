package uk.nhs.nhsbsa.lis.rules.v1.model;

import java.util.List;
import java.util.Date;

import org.springframework.data.annotation.Id;


/**
 * The root class for a rules based LIS assessment.
 */
public class LisApplication {
	
	/**
	 * Assessment is based on claim date. This is the date the claim
	 * arrived in the post or the initial date the claim is created.
	 * If claim is save \ restored do we use the initial date or the save date?
	 */
	private Date claimDate;
	
	/**
	 * Processing date. The date the claim is processed by the operative or the rules engine
	 */
	private Date processingDate;
	
	/**
	 * Address.
	 */
	private Address address;
	
	/** Contact Details
	 * 
	 */
	private ContactDetails contactDetails;
	
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
	private List<Person>dependants;
	
	/**
	 * Non-Dependants
	 */
	private List<Person>nonDependants;
	
	/**
	 * Part 4 Savings
	 */
	private List<Saving>Savings;

	public List<Saving> getSavings() {
		return Savings;
	}

	public void setSavings(List<Saving> savings) {
		Savings = savings;
	}

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

	public List<Person> getDependants() {
		return dependants;
	}

	public void setDependants(List<Person> dependants) {
		this.dependants = dependants;
	}

	public List<Person> getNonDependants() {
		return nonDependants;
	}

	public void setNonDependants(List<Person> nonDependants) {
		this.nonDependants = nonDependants;
	}

	public ContactDetails getContactDetails() {
		return contactDetails;
	}

	public void setContactDetails(ContactDetails contactDetails) {
		this.contactDetails = contactDetails;
	}
	
	@Override
	public String toString() {
		return "Assessment [claimDate=" + claimDate + ", processingDate=" + processingDate + ", address="
				+ address + ", contactDetails=" + contactDetails + ", applicant=" + applicant + ", partner=" + partner
				+ ", dependants=" + dependants + ", nonDependants=" + nonDependants + ", Savings=" + Savings + "]";
	}

}
