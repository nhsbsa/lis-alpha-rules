package uk.nhs.nhsbsa.lis.rules.v1.model;

public enum BenefitType {
	UNDEFINED, // Default when not set
	BAllce, //	Bereavement Allowance
	CARERS_ALLOW, // (CA)	Carers Allowance
	ESA_Assess, // (Assess. Phase)	Employment and Support Allowance
	ESA_Support, // (incl Support)	Employment and Support Allowance including Support Component
	ESA_WRAC, // (incl WRAC)	Employment and Support Allowance including Work Related Activity Component
	IB_Higher, //	Incapacity Benefit
	IB_Lower, //	Incapacity Benefit
	IDB, //	Industrial Death Benefit
	IIDB, //	Industrial Injuries Disablement Benefit
	JSA_C, //(C)	Job Seekers Allowance
	MATERNITY_ALL, //	Maternity Allowance
	RP, //	Retirement Pension
	REA, //	Reduced Earnings Allowance
	SDA, //	Severe Disablement Allowance
	WB, //	Widows Benefit
	WP, //	Widows Pension
	WPA, //	Widowed Parents Allowance
	WTC, //	Working Tax Credit
	WWP; //	War Widows Pension
}
