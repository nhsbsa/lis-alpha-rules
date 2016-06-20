package uk.nhs.nhsbsa.lis.rules.v1.model;

/**
 * class to represent an income
 * An income has a type and whether a value has been set or not.
 * Helps with flow
 * @author lorob
 *
 */
public class Income {
	private IncomeType incomeType;
	private ValueState incomeState;
	private String incomeValue; // TODO this may change to an object. at present can hold income info
	private MoneyPeriod moneyPeriod;
	
	

	/**
	 * Constructor
	 */
	public Income(){
		incomeType=IncomeType.UNDEFINED;
		incomeState=ValueState.UNDEFINED;
		moneyPeriod=MoneyPeriod.UNDEFINED;
	}
	
	public String getIncomeValue() {
		return incomeValue;
	}

	public void setIncomeValue(String incomeValue) {
		this.incomeValue = incomeValue;
	}

	public IncomeType getIncomeType() {
		return incomeType;
	}

	public void setIncomeType(IncomeType incomeType) {
		this.incomeType = incomeType;
	}

	public ValueState getIncomeState() {
		return incomeState;
	}

	public void setIncomeState(ValueState incomeState) {
		this.incomeState = incomeState;
	}
	
	public MoneyPeriod getMoneyPeriod() {
		return moneyPeriod;
	}

	public void setMoneyPeriod(MoneyPeriod moneyPeriod) {
		this.moneyPeriod = moneyPeriod;
	}

	@Override
	public String toString() {
		return "Income [incomeType=" + incomeType + ", incomeState=" + incomeState + ", incomeValue=" + incomeValue
				+ ", moneyPeriod=" + moneyPeriod + "]";
	}


	
}
