package uk.nhs.nhsbsa.lis.rules.v1.model;

/**
 * Updated list from Jeff White 17/6/2016
 * @author lorob
 *
 */
//REVIEW PT enums should be all uppercase & underscore separated
//REVIEW PT discuss whether enums should be abbreviations or full names
public enum BenefitType {
	UNDEFINED, // Default when not set
	ArmedForcesIndependencePayment,
	AttendanceAllowanceLowRate,
	AttendanceAllowanceHighRate,
	BereavementAllowance,
	CarersAllowance,
	ChildBenefit,
	ChildTaxCredit,
	DisabilityLivingAllowanceLowCareRate,
	DisabilityLivingAllowanceMiddleCareRate,
	DisabilityLivingAllowanceHighCareRate,
	DisabilityLivingAllowanceLowMobilityRate,
	EmploymentandSupportAllowance_C_AssessmentPhase,
	EmploymentandSupportAllowance_C_includingSupportComponent,
	EmploymentandSupportAllowance_C_includingWorkRelatedActivityComponent,
	EmploymentandSupportAllowance_IR_,
	IncapacityBenefitHigher,
	IncapacityBenefitLower,
	IncomeSupport,
	IndustrialDeathBenefit,
	IndustrialInjuriesDisablementBenefit,
	JobSeekersAllowance_C_,
	JobSeekersAllowance_IB_,
	MaternityAllowance,
	PensionCreditGuaranteeCredit,
	PensionCreditSavingsCredit,
	PersonalIndependenceAllowance,
	RetirementPension,
	ReducedEarningsAllowance,
	SevereDisablementAllowance,
	StatutoryMaternityPay,
	StatutorySickPay,
	UniversalCredit,
	WarDisablementPension,
	WarWidowsPension,
	WidowsBenefit,
	WidowsPension,
	WidowedParentsAllowance,
	WorkingTaxCredit,
	WorkingTaxCreditwithDisabilityElement,
	WorkingTaxCreditwithSevereDisabilityElement;

}
