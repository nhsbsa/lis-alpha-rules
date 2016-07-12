package uk.nhs.nhsbsa.lis.rules.v1.droolsengine.model;

import org.slf4j.helpers.MessageFormatter;

import uk.nhs.nhsbsa.lis.rules.v1.model.application.Person;

public class OldestApplicant {

	private Person person;
	
	private Age age;
	
	public OldestApplicant(Person person, Age age) {
		super();
		this.person = person;
		this.age = age;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

    public Age getAge() {
        return age;
    }

    public void setAge(Age age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return MessageFormatter.arrayFormat("Oldest applicant {}", new Object[]{
                age
        }).getMessage();
    }

}
