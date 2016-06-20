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

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString(){
		StringBuffer returnStr=new StringBuffer()
				.append(" incomeType:").append(incomeType)
				.append(" incomeState:").append(incomeState)
				.append(" incomeValue:").append(incomeValue)
				.append(" moneyPeriod:").append(moneyPeriod);
		return returnStr.toString();
				
	}
	
	/**
	 * @return
	 */
	public String toJSONString(){
		StringBuffer returnStr=new StringBuffer()
				.append("{ \"type\":\"").append(incomeType).append("\",")
				.append(" \"state\":\"").append(incomeState).append("\",")
				.append(" \"value\":\"").append(incomeValue).append("\",")
				.append(" \"moneyPeriod\":\"").append(moneyPeriod).append("\" }");
		return returnStr.toString(); 
	}
	
}
