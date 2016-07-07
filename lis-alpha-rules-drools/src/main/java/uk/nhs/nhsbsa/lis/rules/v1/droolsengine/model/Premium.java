package uk.nhs.nhsbsa.lis.rules.v1.droolsengine.model;

import java.math.BigDecimal;

import org.slf4j.helpers.MessageFormatter;

public class Premium {

	private BigDecimal value;

	public Premium(Double value) {
		super();
		this.value = new BigDecimal(value);
	}

	public Premium(BigDecimal value) {
		super();
		this.value = value;
	}

	public BigDecimal getValue() {
		return value;
	}

	public void setValue(BigDecimal value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return MessageFormatter.arrayFormat("Premium {}", new Object[]{
				value
		}).getMessage();
	}
}
