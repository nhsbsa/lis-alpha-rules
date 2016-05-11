package net.nhs.nhsbsa.devops.helloworld;

import static org.junit.Assert.*;

import org.junit.Test;

public class SimpleTest {

	Simple simple;
	
	@Test
	public void test() {
		
		String actual = execute("hello");
		assertEquals("hello", actual);
	}

	private String execute(String string) {

		simple = new Simple();
		return simple.execute(string);
	}

}
