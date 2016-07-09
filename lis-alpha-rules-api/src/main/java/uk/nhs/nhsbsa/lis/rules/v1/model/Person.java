package uk.nhs.nhsbsa.lis.rules.v1.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;

public class Person {

	private PersonType type;
	
	private Name name;
	
	@JsonDeserialize(using = LocalDateDeserializer.class)
	@JsonSerialize(using = LocalDateSerializer.class)
	private LocalDate dob;
	
	private String nino;
	
	@JsonManagedReference
	private List<Benefit>benefits;
	
	@JsonManagedReference
	private List<Income>incomes;
	
	@JsonManagedReference
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

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public String getNino() {
		return nino;
	}

	public void setNino(String nino) {
		this.nino = nino;
	}
	
	public void addBenefit(Benefit benefit) {
		if (benefits == null) {
			benefits = new ArrayList<>();
		}
		benefit.setOwner(this);
		benefits.add(benefit);
	}
	
	public void addIncome(Income income) {
		if (incomes == null) {
			incomes = new ArrayList<>();
		}
		income.setOwner(this);
		incomes.add(income);
	}
	
	public void addOutgoing(Outgoing outgoing) {
		if (outgoings == null) {
			outgoings = new ArrayList<>();
		}
		outgoing.setOwner(this);
		outgoings.add(outgoing);
	}

	@Override
	public String toString() {
		StringBuilder result = new StringBuilder();
		if (name != null && !StringUtils.isEmpty(name.toString())) {
			result.append(name.toString())
				.append(" ");
		} 
		if (type != null) {
			result.append(type.toString());
		}
		return result.toString();
	}

}
