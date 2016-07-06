package uk.nhs.nhsbsa.lis.rules.v1.model;

import org.springframework.data.annotation.Transient;

import com.fasterxml.jackson.annotation.JsonBackReference;

/**
 * class to represent an income
 * An income has a type and whether a value has been set or not.
 * Helps with flow
 * @author lorob
 *
 */
public class Income implements IIncome{
	@JsonBackReference
	@Transient
	transient private Person owner;
	
	private IncomeType type;
	private ValueState state;
	private String value; // TODO this may change to an object. at present can hold income info
	private Interval moneyPeriod;

	/**
	 * Constructor
	 */
	public Income(){
		type=IncomeType.UNDEFINED;
		state=ValueState.UNDEFINED;
//		moneyPeriod=Interval.UNDEFINED;
	}
	
	public String getValue() {
		return value;
	}
	
	public void setValue(String value){
		this.value=value;
	}

	public void setIncomeValue(String value) {
		this.value = value;
	}

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
	
	public Interval getMoneyPeriod() {
		return moneyPeriod;
	}

	public void setMoneyPeriod(Interval moneyPeriod) {
		this.moneyPeriod = moneyPeriod;
	}

	@Override
	public String toString() {
		return "Income [incomeType=" + type + ", incomeState=" + state + ", incomeValue=" + value
				+ ", moneyPeriod=" + moneyPeriod + "]";
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

	
}
