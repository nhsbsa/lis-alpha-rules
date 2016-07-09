package uk.nhs.nhsbsa.lis.rules.v1.model;

import org.springframework.data.annotation.Transient;

import com.fasterxml.jackson.annotation.JsonBackReference;

/**
 * Benefit class to hold benefit information
 * @author lorob
 *
 */
public class Benefit implements IMoneySource {
	
	@JsonBackReference
	@Transient
	transient private Person owner;
	
	private BenefitType type;
	
	private ValueState state;
	
	private Boolean receiving;
	
	private IntervalValue value;

	public Benefit(){
		type=BenefitType.UNDEFINED;
		state=ValueState.UNDEFINED;
	}
	
	@Override
	public IMoneySource.Type moneySourceType() {
		return IMoneySource.Type.RESOURCE;
	}
	
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
			//TODO handle SpringBoot devtools classloader defect:
			//https://github.com/spring-projects/spring-boot/issues/3316
			System.err.println(getClass().getClassLoader() + " != " + obj.getClass().getClassLoader());
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

	public Boolean getReceiving() {
		return receiving;
	}

	public void setReceiving(Boolean receiving) {
		this.receiving = receiving;
	}

}
