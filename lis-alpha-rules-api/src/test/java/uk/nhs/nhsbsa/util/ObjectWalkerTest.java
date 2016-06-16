package uk.nhs.nhsbsa.util;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import uk.nhs.nhsbsa.util.ObjectWalker.Traversal;

@RunWith(MockitoJUnitRunner.class)
public class ObjectWalkerTest {

	public static class Model {
		private Model parent;
		private Model child;
		private String id;
		private String field;
		@Override
		public String toString() {
			return id;
		}
	}
	public static class ArrayModel {
		private String[] values;
		public ArrayModel(String... values) {
			this.values = values;
		}
	}
	public static class ListModel {
		private List<String> values;
		public ListModel(String... values) {
			this.values = Arrays.asList(values);
		}
	}
	public static class MapModel {
		private Map<String, String> values = new HashMap<>();
	}
	
	@Mock
	private ObjectWalker.Callback callback;
	
	private ObjectWalker walker;

	@After
	public void teardown() {
		verifyNoMoreInteractions(callback);
	}

	@Test
	public void testNullValue() {
		walker = new ObjectWalker(null, callback);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testNullCallback() {
		walker = new ObjectWalker("", null);
	}
	
	@Test
	public void testNoFields() {

		walker = new ObjectWalker("hello", callback);
		walker.walk();
		//rely on mockito to verify no interactions
	}
	
	@Test
	public void testSimpleFields() {

		Model fixture = fixture("id", "value");
		
		walker = new ObjectWalker(fixture, callback);
		walker.walk();
		
		verify(callback).handle(fixture, "parent", null,    "/parent");
		verify(callback).handle(fixture, "child",  null,    "/child");
		verify(callback).handle(fixture, "id",     "id",    "/id");
		verify(callback).handle(fixture, "field",  "value", "/field");
	}

	@Test
	public void testNestedFields_depthFirst() {
		
		Model parent = fixture("parent", "pval");
		Model child = fixture("child", "cval");
		parent.child = child;
		child.parent = parent;
		
		walker = new ObjectWalker(parent, callback, Traversal.DEPTH_FIRST);
		walker.walk();

		verify(callback).handle(parent, "parent", null,     "/parent");
		verify(callback).handle(parent, "child",  child,    "/child");
		verify(callback).handle(parent, "id",     "parent", "/id");
		verify(callback).handle(parent, "field",  "pval",   "/field");
		
		verify(callback).handle(child, "parent", parent,  "/child/parent");
		verify(callback).handle(child, "child",  null,    "/child/child");
		verify(callback).handle(child, "id",     "child", "/child/id");
		verify(callback).handle(child, "field",  "cval",  "/child/field");
	}

	@Test
	public void testArrays() {

		ArrayModel fixture = new ArrayModel("1", "2", "3");
		
		walker = new ObjectWalker(fixture, callback);
		walker.walk();
		
		verify(callback).handle(fixture, "values", "1",    "/values[0]");
		verify(callback).handle(fixture, "values", "2",    "/values[1]");
		verify(callback).handle(fixture, "values", "3",    "/values[2]");
	}

	@Test
	public void testLists() {

		ListModel fixture = new ListModel("1", "2", "3");
		
		walker = new ObjectWalker(fixture, callback);
		walker.walk();
		
		verify(callback).handle(fixture, "values", "1",    "/values[0]");
		verify(callback).handle(fixture, "values", "2",    "/values[1]");
		verify(callback).handle(fixture, "values", "3",    "/values[2]");
	}

	@Test
	public void testMaps() {

		MapModel fixture = new MapModel();
		fixture.values.put("A", "1");
		fixture.values.put("B", "2");
		fixture.values.put("C", "3");
		
		walker = new ObjectWalker(fixture, callback);
		walker.walk();
		
		verify(callback).handle(fixture, "values", "1",    "/values[A]");
		verify(callback).handle(fixture, "values", "2",    "/values[B]");
		verify(callback).handle(fixture, "values", "3",    "/values[C]");
	}

	@Test
	public void testNestedFields_breadthFirst() {
		
		Model parent = fixture("p1", "p2");
		Model child = fixture("c1", "c2");
		parent.child = child;
		child.parent = parent;
		
		walker = new ObjectWalker(parent, callback, Traversal.BREADTH_FIRST);
		walker.walk();

		verify(callback).handle(parent, "parent", null, "/parent");
		verify(callback).handle(parent, "child",  child, "/child");
		verify(callback).handle(parent, "f1",     "v1", "/f1");
		verify(callback).handle(parent, "f2",     "v2", "/f2");
	}

	private Model fixture(String v1, String v2) {
		Model result = new Model();
		result.id = v1;
		result.field = v2;
		return result;
	}

}
