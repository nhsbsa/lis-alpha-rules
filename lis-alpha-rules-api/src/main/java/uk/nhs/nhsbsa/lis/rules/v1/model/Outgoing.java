package uk.nhs.nhsbsa.lis.rules.v1.model;

/**
 * Expenses and outgoings i.e. rent \ community charge \ accommodation costs
 * @author lorob
 *
 */
public class Outgoing {
	private OutgoingType type;
	private ValueState state;
	private String value; // TODO this may change to an object. at present can hold income info
	private MoneyPeriod moneyPeriod;
	
	public Outgoing(){
		type=OutgoingType.UNDEFINED;
		state=ValueState.UNDEFINED;
		moneyPeriod=MoneyPeriod.UNDEFINED;
	}

	public OutgoingType getType() {
		return type;
	}


	
	public MoneyPeriod getMoneyPeriod() {
		return moneyPeriod;
	}

	public void setMoneyPeriod(MoneyPeriod moneyPeriod) {
		this.moneyPeriod = moneyPeriod;
	}

	@Override
	public String toString() {
		return "Outgoing [outgoingType=" + type + ", outgoingState=" + state + ", outgoingValue="
				+ value + ", moneyPeriod=" + moneyPeriod + "]";
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

	public void setType(OutgoingType type) {
		this.type = type;
	}
	
	

}
