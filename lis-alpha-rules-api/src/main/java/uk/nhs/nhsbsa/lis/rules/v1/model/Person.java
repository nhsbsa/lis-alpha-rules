package uk.nhs.nhsbsa.lis.rules.v1.model;

import java.util.List;
import java.util.Date;

public class Person {

	private PersonType type;
	
	private Name name;
	
	private Date dob;
	
	private NationalInsuranceNo nino;
	
	private List<Benefit>benefits;
	private List<Income>incomes;
	private List<Outgoing>outgoings;

	//REVIEW PT consider using interface for all Incomes?
	
	public List<Outgoing> getOutgoings() {
		return outgoings;
	}

	public void setOutgoings(List<Outgoing> outgoings) {
		this.outgoings = outgoings;
	}

	public List<Benefit> getBenefits() {
		return benefits;
	}

	public void setBenefits(List<Benefit> benefits) {
		this.benefits = benefits;
	}

	public List<Income> getIncomes() {
		return incomes;
	}

	public void setIncomes(List<Income> incomes) {
		this.incomes = incomes;
	}

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

	@Override
	public String toString() {
		return "Person [type=" + type + ", name=" + name + ", dob=" + dob + ", nino=" + nino + ", benefits=" + benefits
				+ ", incomes=" + incomes + ", outgoings=" + outgoings + "]";
	}


	
	
}
