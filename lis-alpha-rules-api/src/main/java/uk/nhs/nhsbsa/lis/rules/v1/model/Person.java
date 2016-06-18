package uk.nhs.nhsbsa.lis.rules.v1.model;

import java.util.ArrayList;
import java.util.Date;

public class Person {

	private PersonType type;
	
	private Name name;
	
	private Date dob;
	
	private NationalInsuranceNo nino;
	
	//REVIEW PT Use interfaces not concrete types. i.e. List<>
	//REVIEW PT consider using interface for all Incomes?
	private ArrayList<Benefit>benefits;
	private ArrayList<Income>incomes;
	private ArrayList<Outgoing>outgoings;
	
	public ArrayList<Outgoing> getOutgoings() {
		return outgoings;
	}

	public void setOutgoings(ArrayList<Outgoing> outgoings) {
		this.outgoings = outgoings;
	}

	public ArrayList<Benefit> getBenefits() {
		return benefits;
	}

	public void setBenefits(ArrayList<Benefit> benefits) {
		this.benefits = benefits;
	}

	public ArrayList<Income> getIncomes() {
		return incomes;
	}

	public void setIncomes(ArrayList<Income> incomes) {
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

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString(){
		StringBuffer returnStr=new StringBuffer("type:").append(type)
				.append(" name:").append(name)
				.append(" dob:").append(dob)
				.append(" nino:").append(nino);
		if(benefits!=null){
			benefits.forEach((benefit)->{returnStr.append(" benefit:").append(benefit);});
		}else{returnStr.append(" benefit:NONE");}
		if(incomes!=null){
			incomes.forEach((income)->{returnStr.append(" income:").append(income);});
		}else{returnStr.append(" income:NONE");}
		if(outgoings!=null){
			outgoings.forEach((outgoing)->{returnStr.append(" outgoing:").append(outgoing);});
		}else{returnStr.append(" outgoing:NONE");}
		return returnStr.toString();
	}
	
	
}
