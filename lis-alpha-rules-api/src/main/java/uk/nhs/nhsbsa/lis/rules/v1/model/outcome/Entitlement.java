package uk.nhs.nhsbsa.lis.rules.v1.model.outcome;

import org.slf4j.helpers.MessageFormatter;

import uk.nhs.nhsbsa.lis.rules.v1.model.application.IntervalValue;

public class Entitlement {

	private EntitlementLevel level;
	
	private IntervalValue excessContribution;

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
		return MessageFormatter.arrayFormat("Application entitled to {} help with help costs",
		        new Object[]{level}).getMessage();
	}

}
