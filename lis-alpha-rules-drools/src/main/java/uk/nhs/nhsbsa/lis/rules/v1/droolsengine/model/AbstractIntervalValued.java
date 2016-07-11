package uk.nhs.nhsbsa.lis.rules.v1.droolsengine.model;

import uk.nhs.nhsbsa.lis.rules.v1.model.application.IntervalValue;

/**
 * Abstract superclass for working data with IntervalValue field.
 */
public abstract class AbstractIntervalValued {

	protected IntervalValue value;

	public AbstractIntervalValued(IntervalValue value) {
		super();
		this.value = value;
	}

	public IntervalValue getValue() {
		return value;
	}

	
}
