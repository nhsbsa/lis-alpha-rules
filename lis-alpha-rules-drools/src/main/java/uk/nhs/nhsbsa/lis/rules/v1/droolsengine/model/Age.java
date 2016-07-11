package uk.nhs.nhsbsa.lis.rules.v1.droolsengine.model;

import java.time.temporal.ChronoUnit;

import org.slf4j.helpers.MessageFormatter;

import uk.nhs.nhsbsa.lis.rules.v1.model.application.Application;
import uk.nhs.nhsbsa.lis.rules.v1.model.application.Person;

public class Age {

	private Person person;
	
	private Long value;
	
	public Age(Application application, Person person) {
		super();
		this.person = person;
		value = getAge(application, person);
	}

	private Long getAge(Application application, Person p) {
		Long result = null;
		if (p.getDob() != null) {
			result = ChronoUnit.YEARS.between(
					person.getDob(),
					application.getClaimDate());
		}
		return result;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public Long getValue() {
		return value;
	}

	public void setValue(Long value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return MessageFormatter.arrayFormat("[{}] age = {}", new Object[]{
				person, value
		}).getMessage();
	}
}
