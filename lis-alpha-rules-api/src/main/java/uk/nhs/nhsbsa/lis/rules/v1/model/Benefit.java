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
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString(){
		StringBuffer returnStr=new StringBuffer()
				.append(" benefitType:").append(benefitType)
				.append(" benefitState:").append(benefitState)
				.append(" benefitValue:").append(benefitValue)
				.append(" moneyPeriod:").append(moneyPeriod);
		return returnStr.toString(); 
	}
	
	public String toJSONString(){
		StringBuffer returnStr=new StringBuffer()
				.append("{ \"type\":\"").append(benefitType).append("\",")
				.append(" \"state\":\"").append(benefitState).append("\",")
				.append(" \"value\":\"").append(benefitValue).append("\",")
				.append(" \"moneyPeriod\":\"").append(moneyPeriod).append("\" }");
		return returnStr.toString(); 
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((benefitType == null) ? 0 : benefitType.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass()) {
			System.out.println(getClass().getClassLoader() + " != " + obj.getClass().getClassLoader());
			return false;
		}
		Benefit other = (Benefit) obj;
		if (benefitType != other.benefitType)
			return false;
		return true;
	}
}
