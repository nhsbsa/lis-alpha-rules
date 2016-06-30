package uk.nhs.nhsbsa.rules.model.rules;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class RequirementTest {

	private Requirement requirement;
	
	@Before
	public void setup() {
		requirement = new Requirement();
	}
	
	@Test
	public void testEmpty() {

		assertFalse(requirement.isRequired("a"));
	}

	@Test
	public void testSimple() {

		requirement.include("a");
		assertTrue(requirement.isRequired("a"));
	}

	@Test
	public void testParent_true() {

		requirement.include("a");
		assertTrue(requirement.isRequired("a.b"));
	}

	@Test
	public void testChild_false() {

		requirement.include("a.b");
		assertFalse(requirement.isRequired("a"));
	}

	@Test
	public void testChildExcluded() {

		requirement.include("a");
		requirement.exclude("a");
		assertFalse(requirement.isRequired("a"));
	}

	@Test
	public void testBrackets() {
	
		requirement.include("a");
		requirement.exclude("a.b");
		
		assertFalse(requirement.isRequired("a.b[index]"));
	}
	
}
