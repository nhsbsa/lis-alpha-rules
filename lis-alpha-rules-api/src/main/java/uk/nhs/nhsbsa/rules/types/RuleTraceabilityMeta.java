package uk.nhs.nhsbsa.rules.types;

/**
 * Meta class to describe the origin for a business rule.
 * Used for rule traceability.
 */
public class RuleTraceabilityMeta {

	private String source;
	
	private String reference;

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getReference() {
		return reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}
}
