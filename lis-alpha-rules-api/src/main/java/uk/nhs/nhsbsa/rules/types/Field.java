package uk.nhs.nhsbsa.rules.types;

import java.util.List;

/**
 * Wrapper for a data model field.
 * Allows Rules API to communicate metadata to the client.
 */
public class Field <T> {
	
	private String name;
	
	/**
	 * The underlying model field value as presented by applicant.
	 */
	private T value;
	
	/**
	 * Whether this field is required, given the current model state.
	 */
	private RuleRequirement requirement;
	
	/**
	 * Whether changes to this field should trigger a re-application of rules.
	 */
	private RuleTrigger trigger;

	/**
	 * Business rules that have been applied using this field.
	 */
	private List<RuleTraceabilityMeta> appliedRules;
	
	/**
	 * Validation rules that apply to this field.
	 * TODO consider exposing the rule logic here so front end can enforce.
	 */
	private List<RuleValidationMeta> validationRules;

	/**
	 * Default constructor.
	 */
	public Field() {
	}
	
	/**
	 * Convenience constructor.
	 * @param value
	 */
	public Field(String name, T value) {
		super();
		this.name = name;
		this.value = value;
	}

	public T getValue() {
		return value;
	}

	public void setValue(T value) {
		this.value = value;
	}

	public RuleRequirement getRequirement() {
		return requirement;
	}

	public void setRequirement(RuleRequirement requirement) {
		this.requirement = requirement;
	}

	public RuleTrigger getTrigger() {
		return trigger;
	}

	public void setTrigger(RuleTrigger trigger) {
		this.trigger = trigger;
	}

	public List<RuleValidationMeta> getValidationRules() {
		return validationRules;
	}

	public void setValidationRules(List<RuleValidationMeta> validationRules) {
		this.validationRules = validationRules;
	}

	public List<RuleTraceabilityMeta> getAppliedRules() {
		return appliedRules;
	}

	public void setAppliedRules(List<RuleTraceabilityMeta> appliedRules) {
		this.appliedRules = appliedRules;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return name + "=" + value;
	}
	
	
}
