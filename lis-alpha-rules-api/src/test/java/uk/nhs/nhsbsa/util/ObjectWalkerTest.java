package uk.nhs.nhsbsa.util;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import uk.nhs.nhsbsa.util.ObjectWalker.CallbackItem;
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
		
		verifyCallback(fixture, "parent", null,    "/parent");
		verifyCallback(fixture, "child",  null,    "/child");
		verifyCallback(fixture, "id",     "id",    "/id");
		verifyCallback(fixture, "field",  "value", "/field");
	}

	@Test
	public void testNestedFields_depthFirst() {
		
		Model parent = fixture("parent", "pval");
		Model child = fixture("child", "cval");
		parent.child = child;
		child.parent = parent;
		
		walker = new ObjectWalker(parent, callback, Traversal.DEPTH_FIRST);
		walker.walk();

		verifyCallback(parent, "parent", null,     "/parent");
		verifyCallback(parent, "child",  child,    "/child");
		verifyCallback(parent, "id",     "parent", "/id");
		verifyCallback(parent, "field",  "pval",   "/field");
		
		verifyCallback(child, "parent", parent,  "/child/parent");
		verifyCallback(child, "child",  null,    "/child/child");
		verifyCallback(child, "id",     "child", "/child/id");
		verifyCallback(child, "field",  "cval",  "/child/field");
	}

	@Test
	public void testArrays() {

		ArrayModel fixture = new ArrayModel("1", "2", "3");
		
		walker = new ObjectWalker(fixture, callback);
		walker.walk();
		
		verifyCallback(fixture, "values", "1",    "/values[0]");
		verifyCallback(fixture, "values", "2",    "/values[1]");
		verifyCallback(fixture, "values", "3",    "/values[2]");
	}

	@Test
	public void testLists() {

		ListModel fixture = new ListModel("1", "2", "3");
		
		walker = new ObjectWalker(fixture, callback);
		walker.walk();
		
		verifyCallback(fixture, "values", "1",    "/values[0]");
		verifyCallback(fixture, "values", "2",    "/values[1]");
		verifyCallback(fixture, "values", "3",    "/values[2]");
	}

	@Test
	public void testMaps() {

		MapModel fixture = new MapModel();
		fixture.values.put("A", "1");
		fixture.values.put("B", "2");
		fixture.values.put("C", "3");
		
		walker = new ObjectWalker(fixture, callback);
		walker.walk();
		
		verifyCallback(fixture, "values", "1",    "/values[A]");
		verifyCallback(fixture, "values", "2",    "/values[B]");
		verifyCallback(fixture, "values", "3",    "/values[C]");
	}

//	@Test
//	public void testNestedFields_breadthFirst() {
//		
//		Model parent = fixture("p1", "p2");
//		Model child = fixture("c1", "c2");
//		parent.child = child;
//		child.parent = parent;
//		
//		walker = new ObjectWalker(parent, callback, Traversal.BREADTH_FIRST);
//		walker.walk();
//
//		verifyCallback(parent, "parent", null, "/parent");
//		verifyCallback(parent, "child",  child, "/child");
//		verifyCallback(parent, "f1",     "v1", "/f1");
//		verifyCallback(parent, "f2",     "v2", "/f2");
//	}

	private Model fixture(String v1, String v2) {
		Model result = new Model();
		result.id = v1;
		result.field = v2;
		return result;
	}

	private void verifyCallback(final Object o, final String fieldName, final Object value, final String path) {
		verify(callback).handle(Matchers.argThat(new Matcher<CallbackItem>() {
			@Override
			public void describeTo(Description description) {
			}

			@Override
			public boolean matches(Object item) {
				CallbackItem cbi = (CallbackItem)item;
				boolean result = Objects.equals(o, cbi.getObject())
						&& Objects.equals(fieldName, cbi.getField().getName())
						&& Objects.equals(value, cbi.getValue())
						&& Objects.equals(path, cbi.getPath());
				return result;
			}

			@Override
			public void describeMismatch(Object item, Description mismatchDescription) {
			}

			@Override
			public void _dont_implement_Matcher___instead_extend_BaseMatcher_() {
			}
		}));
	}

}
