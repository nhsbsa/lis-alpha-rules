package uk.nhs.nhsbsa.lis.rules.v1.model;

import java.util.Date;

import uk.nhs.nhsbsa.rules.types.Field;

public class Person {

	Field<PersonType> type;
	
	Field<Name> name;
	
	Field<Date> dob;
	
	

	public Field<PersonType> getType() {
		return type;
	}

	public void setType(Field<PersonType> type) {
		this.type = type;
	}

	public Field<Name> getName() {
		return name;
	}

	public void setName(Field<Name> name) {
		this.name = name;
	}

	public Field<Date> getDob() {
		return dob;
	}

	public void setDob(Field<Date> dob) {
		this.dob = dob;
	}
	
}
