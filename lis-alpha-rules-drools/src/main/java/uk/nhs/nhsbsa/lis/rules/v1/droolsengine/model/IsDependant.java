package uk.nhs.nhsbsa.lis.rules.v1.droolsengine.model;

import org.slf4j.helpers.MessageFormatter;

import uk.nhs.nhsbsa.lis.rules.v1.model.Person;

public class IsDependant {

	private Person person;
	
	public IsDependant(Person person) {
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
		return MessageFormatter.arrayFormat("[{}] is a Dependant", new Object[]{
				person
		}).getMessage();
	}
}
