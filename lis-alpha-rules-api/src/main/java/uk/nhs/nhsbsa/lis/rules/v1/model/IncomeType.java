package uk.nhs.nhsbsa.lis.rules.v1.model;

// TODO - These names are taken from the spreadsheet which means
// something to staff, but not to people
public enum IncomeType{
	UNDEFINED, // Default when not set
	ACCESS, // FUND	Access Fund
	ANNUITY,	// Annuity
	ASYLUM_SEEKER_INC,//	Asylum Seeker Income
	BOARDER, //	Income from Boarders
	BURSARY, //	Bursary Allowance
	CAREER_DEV_LOAN, //	Career Development Loan
	COAL, //	Cash in Lieu of Coal
	EARNS, //	Earnings
	EARNS_SE, //	Self Employed Earnings
	IS, // Income Support
	JSA_IB, //(IB)	Job Seekers Allowance
	LOAN, //	Student Loan for Maintenance
	LOAN_GRANT, //	Student Loan / Grant for Maintenance
	MAINTENANCE, //	Maintenance
	MORTGAGE_PROT, //	Mortgage Protection
	OCC_PENSION, //	Occupational Pension
	OP_BURSARY, //	Opportunity Bursary
	PC, //	Parental Contribution
	PC_20_Disregard, // £20	Parental Voluntary Payment
	PC_Full_Disregard, //	Parental Voluntary Payment - fully disregarded
	PERSONAL_P, // P	Personal Pension
	SMP, //	Statutory Maternity Pay
	SSP, //	Statutory Sick Pay
	STUDENT_INC,//	Student Income
	SUBLET, //	Income from Subletting
	TEACHER_TRAINING, // Teacher Training Allowance
	UC, //	Universal Credit
	VP, // Voluntary Payment
	VP_20_Disregard, //(£20 Disregard)	Voluntary Payment
	VP_Full_Disregard, //	Voluntary Payment - fully disregarded
	WDP; //	War Disablement Pension
}
