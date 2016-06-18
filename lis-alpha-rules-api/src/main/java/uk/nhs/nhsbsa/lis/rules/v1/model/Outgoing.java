package uk.nhs.nhsbsa.lis.rules.v1.model;

/**
 * Expenses and outgoings i.e. rent \ community charge \ accommodation costs
 * @author lorob
 *
 */
public class Outgoing {
	private OutgoingType outgoingType;
	private ValueState outgoingState;
	private String outgoingValue; // TODO this may change to an object. at present can hold income info
	private MoneyPeriod moneyPeriod;
	
	public Outgoing(){
		outgoingType=OutgoingType.UNDEFINED;
		outgoingState=ValueState.UNDEFINED;
		moneyPeriod=MoneyPeriod.UNDEFINED;
	}

	public OutgoingType getOutgoingType() {
		return outgoingType;
	}

	public void setOutgoingType(OutgoingType outgoingType) {
		this.outgoingType = outgoingType;
	}

	public ValueState getOutgoingState() {
		return outgoingState;
	}

	public void setOutgoingState(ValueState outgoingState) {
		this.outgoingState = outgoingState;
	}

	public String getOutgoingValue() {
		return outgoingValue;
	}

	public void setOutgoingValue(String outgoingValue) {
		this.outgoingValue = outgoingValue;
	}
	
	public MoneyPeriod getMoneyPeriod() {
		return moneyPeriod;
	}

	public void setMoneyPeriod(MoneyPeriod moneyPeriod) {
		this.moneyPeriod = moneyPeriod;
	}
	
	public String toString(){
		StringBuffer returnStr=new StringBuffer()
				.append(" outgoingType:").append(outgoingType)
				.append(" outgoingState:").append(outgoingState)
				.append(" outgoingValue:").append(outgoingValue)
				.append(" moneyPeriod:").append(moneyPeriod);
		return returnStr.toString(); 
	}
	
	/**
	 * @return
	 */
	public String toJSONString(){
		StringBuffer returnStr=new StringBuffer()
				.append("{ \"type\":\"").append(outgoingType).append("\",")
				.append(" \"state\":\"").append(outgoingState).append("\",")
				.append(" \"value\":\"").append(outgoingValue).append("\",")
				.append(" \"moneyPeriod\":\"").append(moneyPeriod).append("\" }");
		return returnStr.toString(); 
	}

}
