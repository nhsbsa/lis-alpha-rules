package uk.nhs.nhsbsa.lis.rules.v1.model;

/**
 * class to represent an income
 * An income has a type and whether a value has been set or not.
 * Helps with flow
 * @author lorob
 *
 */
public class Income implements IIncome{
	private IncomeType type;
	private ValueState state;
	private String value; // TODO this may change to an object. at present can hold income info
	private MoneyPeriod moneyPeriod;

	/**
	 * Constructor
	 */
	public Income(){
		type=IncomeType.UNDEFINED;
		state=ValueState.UNDEFINED;
		moneyPeriod=MoneyPeriod.UNDEFINED;
	}
	
	public String getValue() {
		return value;
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
	
	public MoneyPeriod getMoneyPeriod() {
		return moneyPeriod;
	}

	public void setMoneyPeriod(MoneyPeriod moneyPeriod) {
		this.moneyPeriod = moneyPeriod;
	}

	@Override
	public String toString() {
		return "Income [incomeType=" + type + ", incomeState=" + state + ", incomeValue=" + value
				+ ", moneyPeriod=" + moneyPeriod + "]";
	}


	
}
