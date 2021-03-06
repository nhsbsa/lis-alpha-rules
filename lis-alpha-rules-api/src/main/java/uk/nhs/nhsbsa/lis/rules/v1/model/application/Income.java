package uk.nhs.nhsbsa.lis.rules.v1.model.application;

import com.fasterxml.jackson.annotation.JsonBackReference;

/**
 * class to represent an income
 * An income has a type and whether a value has been set or not.
 * Helps with flow
 * @author lorob
 *
 */
public class Income implements IMoneySource {
	
	@JsonBackReference
	private Person owner;
	
	private IncomeType type;
	private ValueState state;

	private Boolean receiving;
	
	private IntervalValue value;

	/**
	 * Constructor
	 */
	public Income(){
		type=IncomeType.UNDEFINED;
		state=ValueState.UNDEFINED;
	}
	
	@Override
	public IntervalValue getValue() {
		return value;
	}
	
	public void setValue(IntervalValue value){
		this.value=value;
	}

    @Override
	public IncomeType getType() {
		return type;
	}

	public void setType(IncomeType type) {
		this.type = type;
	}

	public ValueState getState() {
		return state;
	}

	public void setState(ValueState state) {
		this.state = state;
	}
	
	@Override
	public String toString() {
		return "Income [incomeType=" + type + ", incomeState=" + state + ", value=" + value
				+ "]";
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
			return false;
		}
		Income other = (Income) obj;
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
