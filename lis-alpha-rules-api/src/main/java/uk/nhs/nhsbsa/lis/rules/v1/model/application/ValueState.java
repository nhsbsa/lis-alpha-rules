package uk.nhs.nhsbsa.lis.rules.v1.model.application;

public enum ValueState {
	UNDEFINED, // initial state - nothing been decied yet
	SET, // the value has been set i.e. YES or TRUE
	NOT_SET; // the value has not been set i.e. NO or FALSE
}
