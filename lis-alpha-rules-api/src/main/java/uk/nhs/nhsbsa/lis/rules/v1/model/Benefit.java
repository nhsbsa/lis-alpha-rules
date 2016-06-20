package uk.nhs.nhsbsa.lis.rules.v1.model;

/**
 * Benefit class to hold benefit information
 * @author lorob
 *
 */
public class Benefit implements IIncome{
	
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
	
	
}
