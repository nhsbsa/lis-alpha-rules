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
	
	public String getIncomeValue() {
		return incomeValue;
	}

	public void setIncomeValue(String incomeValue) {
		this.incomeValue = incomeValue;
	}

	/**
	 * Constructor
	 */
	public Income(){
		incomeType=IncomeType.UNDEFINED;
		incomeState=ValueState.UNDEFINED;
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
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString(){
		StringBuffer returnStr=new StringBuffer()
				.append(" incomeType:").append(incomeType)
				.append(" incomeState:").append(incomeState)
				.append(" incomeValue:").append(incomeValue);
		return returnStr.toString();
				
	}
	
}
