package uk.nhs.nhsbsa.lis.rules.v1.droolsengine.model;

import org.slf4j.helpers.MessageFormatter;

import uk.nhs.nhsbsa.lis.rules.v1.model.application.IntervalValue;

public class ExcessContribution extends AbstractIntervalValued {

	public ExcessContribution(IntervalValue value) {
		super(value);
	}

	@Override
	public String toString() {
		return MessageFormatter.arrayFormat("{} excess contribution", 
				new Object[]{getValue()}).getMessage();
	}}
