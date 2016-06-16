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

	public Benefit(){
		benefitType=BenefitType.UNDEFINED;
		benefitState=ValueState.UNDEFINED;
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
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString(){
		StringBuffer returnStr=new StringBuffer()
				.append(" benefitType:").append(benefitType)
				.append(" benefitState:").append(benefitState)
				.append(" benefitValue:").append(benefitValue);
		return returnStr.toString(); 
	}
}
