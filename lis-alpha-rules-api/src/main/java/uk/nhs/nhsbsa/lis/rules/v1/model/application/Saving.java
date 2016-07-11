package uk.nhs.nhsbsa.lis.rules.v1.model.application;

import uk.nhs.nhsbsa.lis.rules.v1.model.ValueState;

/**
 * Savings. Generally from PART 4 is a name and value. There are no
 * period related to the share. The question asks for number of shares rather than
 * a value, so value for shares would be the number.
 * @author lorob
 *
 */
public class Saving {
	private SavingType type;
	private ValueState state;
	private String value; // TODO this may change to an object. at present can hold income info
	public SavingType getType() {
		return type;
	}
	public void setType(SavingType type) {
		this.type = type;
	}
	public ValueState getState() {
		return state;
	}
	public void setState(ValueState state) {
		this.state = state;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	@Override
	public String toString() {
		return "Saving [type=" + type + ", state=" + state + ", value=" + value + "]";
	}
	
	
}
