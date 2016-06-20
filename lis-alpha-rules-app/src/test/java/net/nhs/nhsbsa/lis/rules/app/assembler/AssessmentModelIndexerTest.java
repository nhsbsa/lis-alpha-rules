package net.nhs.nhsbsa.lis.rules.app.assembler;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import uk.nhs.nhsbsa.rules.builder.FieldBuilder;
import uk.nhs.nhsbsa.rules.types.Field;

public class AssessmentModelIndexerTest {

	FieldIndexer indexer = new FieldIndexer();
	
	List<Field<?>> fixture;
	Field<Object> f1;
	Field<Object> f2;
	
	@Before
	public void setup() {
		
		f1 = new FieldBuilder<>().withName("f1").withValue("v1").getInstance();
		f2 = new FieldBuilder<>().withName("f2").withValue("v2").getInstance();
		fixture = Arrays.asList(f1, f2);
	}
	
	@Test
	public void testNull() {

		Map<String, Field<Object>> index = indexer.index(null);
		assertNotNull(index);
		assertTrue(index.isEmpty());
	}

	@Test
	public void testEmpty() {

		Map<String, Field<Object>> index = indexer.index(new ArrayList<>());
		assertNotNull(index);
		assertTrue(index.isEmpty());
	}

	@Test
	public void testIndex() {

		Map<String, Field<Object>> index = indexer.index(fixture);
		assertNotNull(index);
		assertNotNull(index.get("f1"));
		assertSame(f1, index.get("f1"));
	}

}
