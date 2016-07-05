package uk.nhs.nhsbsa.lis.rules.v1.model;

import org.springframework.data.annotation.Transient;

import com.fasterxml.jackson.annotation.JsonBackReference;

/**
 * Benefit class to hold benefit information
 * @author lorob
 *
 */
public class Benefit implements IIncome{
	
	@JsonBackReference
	@Transient
	transient private Person owner;
	
	private BenefitType type;
	
	private ValueState state;
	
	private String value; // TODO this may change to an object. at present can hold benefit info
	
	private MoneyPeriod moneyPeriod;

	public Benefit(){
		type=BenefitType.UNDEFINED;
		state=ValueState.UNDEFINED;
		moneyPeriod=MoneyPeriod.UNDEFINED;
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

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	
	public MoneyPeriod getMoneyPeriod() {
		return moneyPeriod;
	}

	public void setMoneyPeriod(MoneyPeriod moneyPeriod) {
		this.moneyPeriod = moneyPeriod;
	}

	@Override
	public String toString() {
		return "Benefit [benefitType=" + type + ", benefitState=" + state + ", benefitValue="
				+ value + ", moneyPeriod=" + moneyPeriod + "]";
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
}
