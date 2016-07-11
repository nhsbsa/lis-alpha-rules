package uk.nhs.nhsbsa.lis.rules.v1.droolsengine.model;

import org.slf4j.helpers.MessageFormatter;

import uk.nhs.nhsbsa.lis.rules.v1.model.application.IntervalValue;

public class AgePremium extends AbstractIntervalValued {

	public AgePremium(IntervalValue value) {
		super(value);
	}

	@Override
	public String toString() {
		return MessageFormatter.arrayFormat("{} age premium", 
				new Object[]{getValue()}).getMessage();
	}
}
