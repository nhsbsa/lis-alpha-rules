package uk.nhs.nhsbsa.lis.rules.v1.model;

import java.util.Date;
import java.util.List;
import java.util.List;

public class Person {

	private PersonType type;
	
	private Name name;
	
	private Date dob;
	
	private NationalInsuranceNo nino;
	
	//REVIEW PT Use interfaces not concrete types. i.e. List<>
	//REVIEW PT consider using interface for all Incomes?
	private List<Benefit>benefits;
	private List<Income>incomes;
	private List<Outgoing>outgoings;
	
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

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString_(){
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
	
	@Override
	public String toString() {
		return "Person [type=" + type + ", name=" + name + ", dob=" + dob + ", nino=" + nino + ", benefits=" + benefits
				+ ", incomes=" + incomes + ", outgoings=" + outgoings + "]";
	}

	/**
	 * @return
	 */
	public String toJSONString_(){
		StringBuffer returnStr=new StringBuffer("{\"person\":{");
		returnStr.append("\"name\":").append(name.toJSONString()).append(",");
		returnStr.append("\"dob\":\"").append(dob).append("\",");
		returnStr.append(nino.toJSONString()).append(",");
		returnStr.append("\"benefits\":[");
		if(benefits!=null){
			boolean firstIteration=true;
			for(Benefit benefit : benefits){
				if(firstIteration==true){firstIteration=false;}
				else{returnStr.append(",");}
				returnStr.append(benefit.toJSONString());
			}
		}
		returnStr.append("],\"incomes\":[");
		if(benefits!=null){
			boolean firstIteration=true;
			for(Income income : incomes){
				if(firstIteration==true){firstIteration=false;}
				else{returnStr.append(",");}
				returnStr.append(income.toJSONString());
			}
		}
		returnStr.append("],\"outgoings\":[");
		if(outgoings!=null){
			boolean firstIteration=true;
			for(Outgoing outgoing : outgoings){
				if(firstIteration==true){firstIteration=false;}
				else{returnStr.append(",");}
				returnStr.append(outgoing.toJSONString());
			}
		}
		returnStr.append("]}");
		return returnStr.toString();
	}

	
}
