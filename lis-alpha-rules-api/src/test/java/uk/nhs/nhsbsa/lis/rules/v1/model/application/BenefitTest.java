package uk.nhs.nhsbsa.lis.rules.v1.model.application;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.IOException;
import java.util.Arrays;

import org.junit.Test;

import com.fasterxml.jackson.databind.ObjectMapper;

import uk.nhs.nhsbsa.lis.rules.v1.model.application.Benefit;
import uk.nhs.nhsbsa.lis.rules.v1.model.application.Person;

public class BenefitTest {

	ObjectMapper mapper = new ObjectMapper();
	
	/**
	 * Drools needs each benefit to have its owning Person to join in rules patterns.
	 * Check that we can serialise/deserialise to/from json using @JsonBackReference
	 * and @JsonManagedReference.
	 * @throws IOException
	 */
	@Test
	public void testBackReference() throws IOException {

		String nino = "1234";
		Person p = new Person();
		p.setNino(nino);
		Benefit b = new Benefit();
		p.setBenefits(Arrays.asList(b));
		
		String json = mapper.writeValueAsString(p);
		
		System.out.println(json);
		
		Person actualP = mapper.readValue(json, Person.class);
		Benefit actualB = actualP.getBenefits().get(0);
		
		System.out.println(actualP);
		System.out.println(actualB);
		
		assertNotNull(actualB.getOwner());
		assertEquals(nino, actualB.getOwner().getNino());
	}

}
