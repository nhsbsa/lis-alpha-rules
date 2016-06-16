package uk.nhs.nhsbsa.lis.rules.v1.model;

import java.util.Date;

public class Person {

	private PersonType type;
	
	private Name name;
	
	private Date dob;
	
	private NationalInsuranceNo nino;
	
	public PersonType getType() {
		return type;
	}

	public void setType(PersonType type) {
		this.type = type;
	}

	public Name getName() {
		return name;
	}

	public void setName(Name name) {
		this.name = name;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public NationalInsuranceNo getNino() {
		return nino;
	}

	public void setNino(NationalInsuranceNo nino) {
		this.nino = nino;
	}

	public String toString(){
		StringBuffer returnStr=new StringBuffer("type:").append(type)
				.append(" name:").append(name)
				.append(" dob:").append(dob)
				.append(" nino:").append(nino);
		return returnStr.toString();
	}
	
	
}
