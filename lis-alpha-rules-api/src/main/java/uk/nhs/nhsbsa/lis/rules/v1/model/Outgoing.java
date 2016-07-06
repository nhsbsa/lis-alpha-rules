package uk.nhs.nhsbsa.lis.rules.v1.model;

import org.springframework.data.annotation.Transient;

import com.fasterxml.jackson.annotation.JsonBackReference;

/**
 * Expenses and outgoings i.e. rent \ community charge \ accommodation costs
 * @author lorob
 *
 */
public class Outgoing {
	@JsonBackReference
	@Transient
	transient private Person owner;
	
	private OutgoingType type;
	private ValueState state;
	private String value; // TODO this may change to an object. at present can hold income info
	private Interval moneyPeriod;
	
	public Outgoing(){
		type=OutgoingType.UNDEFINED;
		state=ValueState.UNDEFINED;
		moneyPeriod=Interval.UNDEFINED;
	}

	public OutgoingType getType() {
		return type;
	}


	
	public Interval getMoneyPeriod() {
		return moneyPeriod;
	}

	public void setMoneyPeriod(Interval moneyPeriod) {
		this.moneyPeriod = moneyPeriod;
	}

	public ValueState getState() {
		return state;
	}

	public void setState(ValueState state) {
		this.state = state;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public void setType(OutgoingType type) {
		this.type = type;
	}
	
	@Override
	public int hashCode() {
		final int prime = 41;
		int result = 1;
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass()) {
			//TODO handle SpringBoot devtools classloader defect:
			//https://github.com/spring-projects/spring-boot/issues/3316
			System.err.println(getClass().getClassLoader() + " != " + obj.getClass().getClassLoader());
			return false;
		}
		Outgoing other = (Outgoing) obj;
		if (type != other.type)
			return false;
		return true;
	}

	public Person getOwner() {
		return owner;
	}

	public void setOwner(Person owner) {
		this.owner = owner;
	}

	@Override
	public String toString() {
		return "Outgoing [owner=" + owner + ", type=" + type + ", state=" + state + ", value=" + value
				+ ", moneyPeriod=" + moneyPeriod + "]";
	}
	
}
