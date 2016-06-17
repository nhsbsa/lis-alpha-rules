package uk.nhs.nhsbsa.rules.builder;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import uk.nhs.nhsbsa.rules.builder.FieldWalker.Traversal;
import uk.nhs.nhsbsa.rules.types.Field;

@RunWith(MockitoJUnitRunner.class)
public class FieldWalkerTest {

	public static class Model {
		private Field<Model> parent;
		private Field<Model> child;
		private Field<String> f1;
		private Field<String> f2;
	}
	
	@Mock
	FieldWalker.Callback callback;
	
	FieldWalker walker;

	@Before
	public void setup() {
		walker = new FieldWalker();
	}
	
	@After
	public void teardown() {
		verifyNoMoreInteractions(callback);
	}

	@Test
	public void testNullValue() {
		walker.walk(null, callback);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testNullCallback() {
		walker.walk("", null);
	}
	
	@Test
	public void testNoFields() {

		walker.walk("hello", callback);
		//rely on mockito to verify no interactions
	}
	
	@Test
	public void testSimpleFields() {

		Model fixture = fixture("v1", "v2");
		
		walker.walk(fixture, callback);
		
		verify(callback).field(fixture.f1);
		verify(callback).field(fixture.f2);
	}

	@Test
	public void testNestedFields_depthFirst() {
		
		walker = new FieldWalker(Traversal.DEPTH_FIRST);
		nestedFields();
	}

	@Test
	public void testNestedFields_breadthFirst() {
		
		walker = new FieldWalker(Traversal.BREADTH_FIRST);
		nestedFields();
	}
	
	public void nestedFields() {
		
		Model parent = fixture("p1", "p2");
		Model child = fixture("c1", "c2");
		parent.child = new Field<FieldWalkerTest.Model>("child", child);
		child.parent = new Field<FieldWalkerTest.Model>("parent", parent);
		
		walker.walk(parent, callback);

		verify(callback).field(parent.f1);
		verify(callback).field(parent.f2);
		verify(callback).field(parent.child);
		verify(callback).field(child.f1);
		verify(callback).field(child.f2);
		verify(callback).field(child.parent);
	}

	private Model fixture(String v1, String v2) {
		Model result = new Model();
		result.f1 = new Field<String>("f1", v1);
		result.f2 = new Field<String>("f2", v2);
		return result;
	}

}
