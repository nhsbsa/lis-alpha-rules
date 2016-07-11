package uk.nhs.nhsbsa.lis.rules.v1.model.application;

import org.springframework.data.annotation.Transient;

import com.fasterxml.jackson.annotation.JsonBackReference;

import uk.nhs.nhsbsa.lis.rules.v1.model.ValueState;

/**
 * Expenses and outgoings i.e. rent \ community charge \ accommodation costs
 * @author lorob
 *
 */
public class Outgoing implements IMoneySource {
	
	@JsonBackReference
	@Transient
	transient private Person owner;
	
	private OutgoingType type;
	
	private ValueState state;

	private Boolean receiving;
	
	private IntervalValue value;
	
	public Outgoing(){
		type=OutgoingType.UNDEFINED;
		state=ValueState.UNDEFINED;
	}

	@Override
	public IMoneySource.Type moneySourceType() {
		return IMoneySource.Type.REQUIREMENT;
	}

	public OutgoingType getType() {
		return type;
	}

	public ValueState getState() {
		return state;
	}

	public void setState(ValueState state) {
		this.state = state;
	}

	public IntervalValue getValue() {
		return value;
	}

	public void setValue(IntervalValue value) {
		this.value = value;
	}

	public void setType(OutgoingType type) {
		this.type = type;
	}
	
	public Person getOwner() {
		return owner;
	}

	public void setOwner(Person owner) {
		this.owner = owner;
	}

	public Boolean getReceiving() {
		return receiving;
	}

	public void setReceiving(Boolean receiving) {
		this.receiving = receiving;
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

	@Override
	public String toString() {
		return "Outgoing [owner=" + owner + ", type=" + type + ", state=" + state + ", value=" + value
				+ "]";
	}

}
