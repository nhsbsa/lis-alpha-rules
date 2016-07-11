package uk.nhs.nhsbsa.lis.rules.v1.droolsengine.model;

import org.slf4j.helpers.MessageFormatter;

import uk.nhs.nhsbsa.lis.rules.v1.model.application.IntervalValue;

public class NoEntitlementThreshold extends AbstractIntervalValued {

	public NoEntitlementThreshold(IntervalValue value) {
		super(value);
	}

	
	@Override
	public String toString() {
		return MessageFormatter.arrayFormat("No entitlement when excess contribution exceeds {}", 
				new Object[]{getValue()}).getMessage();
	}
}
