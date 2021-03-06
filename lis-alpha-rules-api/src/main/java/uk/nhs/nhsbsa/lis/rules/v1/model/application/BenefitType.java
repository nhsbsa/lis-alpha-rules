package uk.nhs.nhsbsa.lis.rules.v1.model.application;

/**
 * Updated list from Jeff White 17/6/2016
 * @author lorob
 *
 */
//REVIEW PT discuss whether enums should be abbreviations or full names
public enum BenefitType {
	UNDEFINED, // Default when not set
	ARMED_FORCES_INDEPENDENCE_PAYMENT,
	ATTENDANCE_ALLOWANCE_LOW_RATE,
	ATTENDANCE_ALLOWANCE_HIGH_RATE,
	BEREAVEMENT_ALLOWANCE,
	CARERS_ALLOWANCE,
	CHILD_BENEFIT,
	CHILD_TAX_CREDIT,
	DISABILITY_LIVING_ALLOWANCE_LOW_CARE_RATE,
	DISABILITY_LIVING_ALLOWANCE_MIDDLE_CARE_RATE,
	DISABILITY_LIVING_ALLOWANCE_HIGH_CARE_RATE,
	DISABILITY_LIVING_ALLOWANCE_LOW_MOBILITY_RATE,
	DISABILITY_LIVING_ALLOWANCE_HIGH_MOBILITY_RATE,
	EMPLOYMENT_AND_SUPPORT_ALLOWANCE_C_ASSESSMENT_PHASE,
	EMPLOYMENT_AND_SUPPORT_ALLOWANCE_C_INCLUDING_SUPPORT_COMPONENT,
	EMPLOYMENT_AND_SUPPORT_ALLOWANCE_C_INCLUDING_WORK_RELATED_ACTIVITY_COMPONENT,
	EMPLOYMENT_AND_SUPPORT_ALLOWANCE_IR_,
	INCAPACITY_BENEFIT_HIGHER,
	INCAPACITY_BENEFIT_LOWER,
	INCOME_SUPPORT,
	INDUSTRIAL_DEATH_BENEFIT,
	INDUSTRIAL_INJURIES_DISABLEMENT_BENEFIT,
	JOB_SEEKERS_ALLOWANCE_C_,
	JOB_SEEKERS_ALLOWANCE_IB_,
	MATERNITY_ALLOWANCE,
	PENSION_CREDIT_GUARANTEE_CREDIT,
	PENSION_CREDIT_SAVINGS_CREDIT,
	PERSONAL_INDEPENDENCE_ALLOWANCE,
	RETIREMENT_PENSION,
	REDUCEDEARNINGS_ALLOWANCE,
	SEVERE_DISABLEMENT_ALLOWANCE,
	STATUTORY_MATERNITY_PAY,
	STATUTORY_SICK_PAY,
	UNIVERSAL_CREDIT,
	WAR_DISABLEMENT_PENSION,
	WAR_WIDOWS_PENSION,
	WIDOWS_BENEFIT,
	WIDOWS_PENSION,
	WIDOWED_PARENTS_ALLOWANCE,
	WORKING_TAX_CREDIT,
	WORKING_TAX_CREDIT_WITH_DISABILITY_ELEMENT,
	WORKING_TAX_CREDIT_WITH_SEVERE_DISABILITY_ELEMENT;

}
