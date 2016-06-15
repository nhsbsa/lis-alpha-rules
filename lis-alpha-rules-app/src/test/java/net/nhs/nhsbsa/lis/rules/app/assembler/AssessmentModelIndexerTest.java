package net.nhs.nhsbsa.lis.rules.app.assembler;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import net.nhs.nhsbsa.lis.rules.app.model.AssessmentModel;
import uk.nhs.nhsbsa.rules.builder.FieldBuilder;
import uk.nhs.nhsbsa.rules.types.Field;

public class AssessmentModelIndexerTest {

	AssessmentModelIndexer indexer = new AssessmentModelIndexer();
	
	AssessmentModel fixture;
	Field<Object> f1;
	Field<Object> f2;
	
	@Before
	public void setup() {
		
		f1 = new FieldBuilder<>().withName("f1").withValue("v1").getInstance();
		f2 = new FieldBuilder<>().withName("f2").withValue("v2").getInstance();
		fixture = new AssessmentModel();
		fixture.setFields(Arrays.asList(f1, f2));
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testNull() {

		indexer.index(null);
	}

	@Test
	public void testEmpty() {

		fixture.setFields(new ArrayList<>());
		Map<String, Field<Object>> index = indexer.index(fixture);
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
