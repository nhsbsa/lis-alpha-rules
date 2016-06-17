package uk.nhs.nhsbsa.lis.rules.v1.model;

import java.util.ArrayList;
import java.util.Date;

/**
 * The root class for a rules based LIS assessment.
 */
public class Assessment {
	
	/**
	 * ID for this assessment.
	 */
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

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString(){
		StringBuffer returnStr=new StringBuffer("id:").append(id)
				.append(" claimDate:").append(claimDate)
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
	
	public String toJSONString(){
		StringBuffer returnStr=new StringBuffer("{\"assessment\":{")
				.append(" \"id\":\"").append(id).append("\",")
				.append(" \"claimDate\":\"").append(claimDate).append("\",")
				.append(" \"processingDate\":\"").append(processingDate).append("\",")
				.append(" \"address\":").append(address.toJSONString()).append(",")
				.append(" \"mainApplicant\":").append(applicant.toJSONString());
		returnStr.append("}, \"partner\":");
		if(partner!=null){
			returnStr.append(partner.toJSONString()).append("}");
		}else{returnStr.append("{}");}
		// TODO Test this
		returnStr.append(",").append("\"dependants\":[");
		if(dependants!=null){
			boolean firstIteration=true;
			for(Person dependent : dependants){
				if(firstIteration==true){firstIteration=false;}
				else{returnStr.append(",");}
				returnStr.append(dependent.toJSONString());
			}
		}
		returnStr.append("],\"nonDependants\":[");
		if(dependants!=null){
			boolean firstIteration=true;
			for(Person nonDependent : nonDependants){
				if(firstIteration==true){firstIteration=false;}
				else{returnStr.append(",");}
				returnStr.append(nonDependent.toJSONString());
			}
		}
		returnStr.append("]}}");
		return returnStr.toString();
	}
	
}
