package uk.nhs.nhsbsa.lis.rules.v1.model.outcome;

import uk.nhs.nhsbsa.lis.rules.v1.model.application.IntervalValue;

public class Entitlement {

	EntitlementLevel level;
	
	IntervalValue excessContribution;

	public Entitlement() {
	}
	
	public Entitlement(EntitlementLevel level, IntervalValue excessContribution) {
		super();
		this.level = level;
		this.excessContribution = excessContribution;
	}

	public IntervalValue getExcessContribution() {
		return excessContribution;
	}

	public void setExcessContribution(IntervalValue excessContribution) {
		this.excessContribution = excessContribution;
	}

	public EntitlementLevel getLevel() {
		return level;
	}

	public void setLevel(EntitlementLevel level) {
		this.level = level;
	}

	@Override
	public String toString() {
		return "Application entitled to FULL help with help costs";
	}

}
