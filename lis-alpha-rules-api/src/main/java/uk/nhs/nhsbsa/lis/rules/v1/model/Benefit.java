package uk.nhs.nhsbsa.lis.rules.v1.model;

/**
 * Benefit class to hold benefit information
 * @author lorob
 *
 */
public class Benefit {
	private BenefitType benefitType;
	private ValueState benefitState;
	private String benefitValue; // TODO this may change to an object. at present can hold benefit info
	private MoneyPeriod moneyPeriod;

	public Benefit(){
		benefitType=BenefitType.UNDEFINED;
		benefitState=ValueState.UNDEFINED;
		moneyPeriod=MoneyPeriod.UNDEFINED;
	}
	
	public BenefitType getBenefitType() {
		return benefitType;
	}

	public void setBenefitType(BenefitType benefitType) {
		this.benefitType = benefitType;
	}

	public ValueState getBenefitState() {
		return benefitState;
	}

	public void setBenefitState(ValueState benefitState) {
		this.benefitState = benefitState;
	}

	public String getBenefitValue() {
		return benefitValue;
	}

	public void setBenefitValue(String benefitValue) {
		this.benefitValue = benefitValue;
	}
	
	public MoneyPeriod getMoneyPeriod() {
		return moneyPeriod;
	}

	public void setMoneyPeriod(MoneyPeriod moneyPeriod) {
		this.moneyPeriod = moneyPeriod;
	}

	@Override
	public String toString() {
		return "Benefit [benefitType=" + benefitType + ", benefitState=" + benefitState + ", benefitValue="
				+ benefitValue + ", moneyPeriod=" + moneyPeriod + "]";
	}
	
	
}
