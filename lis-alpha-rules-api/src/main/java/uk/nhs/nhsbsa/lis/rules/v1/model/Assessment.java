package uk.nhs.nhsbsa.lis.rules.v1.model;

import java.util.ArrayList;
import java.util.Date;

import org.springframework.data.annotation.Id;

/**
 * The root class for a rules based LIS assessment.
 */
public class Assessment {
	
	/**
	 * ID for this assessment.
	 */
	@Id
	private String id;
	
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
	public Assessment() {
	}
	
	/**
	 * Convenience constructor.
	 * @param id
	 */
	public Assessment(String id) {
		super();
		this.id = id;
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	
}
