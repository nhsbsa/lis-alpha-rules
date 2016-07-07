package uk.nhs.nhsbsa.lis.rules.v1.droolsengine.model;

import org.slf4j.helpers.MessageFormatter;

import uk.nhs.nhsbsa.lis.rules.v1.model.Person;

public class IsNonDependant {

	private Person person;
	
	public IsNonDependant(Person person) {
		super();
		this.person = person;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	@Override
	public String toString() {
		return MessageFormatter.arrayFormat("[{}] is a Non-dependant", new Object[]{
				person
		}).getMessage();
	}
}
