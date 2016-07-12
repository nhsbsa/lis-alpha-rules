package uk.nhs.nhsbsa.lis.rules.v1.droolsengine.model;

import org.slf4j.helpers.MessageFormatter;

import uk.nhs.nhsbsa.lis.rules.v1.model.application.Person;
import uk.nhs.nhsbsa.lis.rules.v1.model.application.PersonType;

public class ApplicantOrPartner {

    Person person;
    PersonType type;
    
    public ApplicantOrPartner(Person person, PersonType type) {
        super();
        this.person = person;
        this.type = type;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public PersonType getType() {
        return type;
    }

    public void setType(PersonType type) {
        this.type = type;
    }
    
    @Override
    public String toString() {
        return MessageFormatter.arrayFormat("{} is applicant or partner ({})", new Object[]{
                person, type
        }).getMessage();
    }
}
