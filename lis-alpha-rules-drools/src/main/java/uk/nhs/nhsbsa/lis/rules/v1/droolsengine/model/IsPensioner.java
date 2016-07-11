package uk.nhs.nhsbsa.lis.rules.v1.droolsengine.model;

import org.slf4j.helpers.MessageFormatter;

import uk.nhs.nhsbsa.lis.rules.v1.model.application.Person;

public class IsPensioner {

	private Person person;
	
	public IsPensioner(Person person) {
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
		return MessageFormatter.arrayFormat("[{}] is a Pensioner", new Object[]{
				person
		}).getMessage();
	}
}
