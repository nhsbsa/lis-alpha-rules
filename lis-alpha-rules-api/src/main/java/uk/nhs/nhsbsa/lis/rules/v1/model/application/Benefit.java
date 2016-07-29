package uk.nhs.nhsbsa.lis.rules.v1.model.application;

import com.fasterxml.jackson.annotation.JsonBackReference;

/**
 * Benefit class to hold benefit information
 * @author lorob
 *
 */
public class Benefit implements IMoneySource {
	
	@JsonBackReference
	private Person owner;
	
	private BenefitType type;
	
	private ValueState state;
	
	private Boolean receiving;
	
	private IntervalValue value;

	public Benefit(){
		type=BenefitType.UNDEFINED;
		state=ValueState.UNDEFINED;
	}
	
	@Override
	public BenefitType getType() {
		return type;
	}

	public void setType(BenefitType type) {
		this.type = type;
	}

	public ValueState getState() {
		return state;
	}

	public void setState(ValueState state) {
		this.state = state;
	}

	@Override
	public IntervalValue getValue() {
		return value;
	}

	public void setValue(IntervalValue value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return "Benefit [type=" + type + ", state=" + state + ", value="
				+ value + "]";
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
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
			return false;
		}
		Benefit other = (Benefit) obj;
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
	public Boolean getReceiving() {
		return receiving;
	}

	public void setReceiving(Boolean receiving) {
		this.receiving = receiving;
	}

}
