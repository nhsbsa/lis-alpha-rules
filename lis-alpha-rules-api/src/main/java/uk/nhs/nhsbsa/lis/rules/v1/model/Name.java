package uk.nhs.nhsbsa.lis.rules.v1.model;

import uk.nhs.nhsbsa.rules.types.Field;

public class Name {

	private Field<String> title;
	
	private Field<String> forenames;
	
	private Field<String> surname;

    public Field<String> getTitle() {
        return title;
    }

    public void setTitle(Field<String> title) {
        this.title = title;
    }

    public Field<String> getForenames() {
        return forenames;
    }

    public void setForenames(Field<String> forenames) {
        this.forenames = forenames;
    }

    public Field<String> getSurname() {
        return surname;
    }

    public void setSurname(Field<String> surname) {
        this.surname = surname;
    }

}
