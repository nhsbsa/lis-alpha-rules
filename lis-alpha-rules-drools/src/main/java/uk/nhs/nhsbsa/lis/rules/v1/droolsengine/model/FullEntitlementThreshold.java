package uk.nhs.nhsbsa.lis.rules.v1.droolsengine.model;

import org.slf4j.helpers.MessageFormatter;

import uk.nhs.nhsbsa.lis.rules.v1.model.application.IntervalValue;

public class FullEntitlementThreshold extends AbstractIntervalValued {

	public FullEntitlementThreshold(IntervalValue value) {
		super(value);
	}

	@Override
	public String toString() {
		return MessageFormatter.arrayFormat("Full entitlement when excess contribution is below {}", 
				new Object[]{getValue()}).getMessage();
	}
}
