package uk.nhs.nhsbsa.lis.rules.v1.model;

import java.util.Date;

import uk.nhs.nhsbsa.rules.types.Field;

/**
 * The root class for a rules based LIS assessment.
 */
public class Assessment {

	/**
	 * ID for this assessment.
	 * No need for Field meta on this.
	 */
	private String id;
	
	/**
	 * Assessment is based on claim date.
	 */
	private Field<Date> claimDate;
	
	/**
	 * Address.
	 */
	private Field<Address> address;
	
	/**
	 * Main applicant.
	 */
	private Field<Person> applicant;
	
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

	public Field<Date> getClaimDate() {
		return claimDate;
	}

	public void setClaimDate(Field<Date> claimDate) {
		this.claimDate = claimDate;
	}
	
	public Field<Address> getAddress() {
		return address;
	}

	public void setAddress(Field<Address> address) {
		this.address = address;
	}

	public Field<Person> getApplicant() {
		return applicant;
	}

	public void setApplicant(Field<Person> applicant) {
		this.applicant = applicant;
	}
}
