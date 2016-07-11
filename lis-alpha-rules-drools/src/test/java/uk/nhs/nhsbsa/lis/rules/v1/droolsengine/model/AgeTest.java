package uk.nhs.nhsbsa.lis.rules.v1.droolsengine.model;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;

import org.junit.Before;
import org.junit.Test;

import uk.nhs.nhsbsa.lis.rules.v1.model.application.Application;
import uk.nhs.nhsbsa.lis.rules.v1.model.application.Person;

public class AgeTest {

	Application app;
	Person person;
	
	@Before
	public void setup() {
		app = new Application();
		app.setClaimDate(LocalDate.parse("2016-01-10"));
		person = new Person();
	}
	
	@Test
	public void test_10() {
		person.setDob(LocalDate.parse("2006-01-10"));
		Age actual = new Age(app, person);
		assertEquals((Long)10L, actual.getValue());
	}

	@Test
	public void test_1day_short_of_10() {
		person.setDob(LocalDate.parse("2006-01-11"));
		Age actual = new Age(app, person);
		assertEquals((Long)9L, actual.getValue());
	}

}
