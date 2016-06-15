package uk.nhs.nhsbsa.rules.builder;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang3.reflect.FieldUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Assert;

import uk.nhs.nhsbsa.rules.types.Field;

/**
 * Class to walk an object model and callback for every Field discovered. 
 */
public class FieldWalker {

	private static final Logger LOGGER = LoggerFactory.getLogger(FieldWalker.class);
	
	public static interface Callback {
		void field(Field<?> field);
	}
	
	public static enum Traversal {
		
		BREADTH_FIRST,
		
		DEPTH_FIRST
	}
	
	private Set<Object> cache = new HashSet<>();
	
	private Traversal traversal;
	
	public FieldWalker(Traversal traversal) {
		super();
		this.traversal = traversal;
	}

	public FieldWalker() {
		traversal = Traversal.DEPTH_FIRST;
	}

	public void walk(Object o, Callback callback) {
		
		Assert.notNull(callback);
		if (o != null) {
			cache.add(o);
			List<Field<?>> fields = getFields(o);
			if (traversal == Traversal.DEPTH_FIRST) {
				recurse(fields, callback);
			}
			callback(fields, callback);
			if (traversal == Traversal.BREADTH_FIRST) {
				recurse(fields, callback);
			}
		}
	}

	private void callback(List<Field<?>> fields, Callback callback) {
		for (Field<?> field : fields) {
			LOGGER.info("Callback for : {}", field);
			callback.field(field);
		}
	}

	private void recurse(List<Field<?>> fields, Callback callback) {
		for (Field<?> field : fields) {
			Object v = field.getValue();
			if (!cache.contains(v)) {
				walk(v, callback);
			}
		}
	}

	/**
	 * Traverse Objects fields and collect all of type uk.nhs.nhsbsa.rules.types.Field.
	 * @param o
	 * @return
	 */
	private List<Field<?>> getFields(Object o) {
		List<Field<?>> result = new ArrayList<>();
		List<java.lang.reflect.Field> fields = FieldUtils.getAllFieldsList(o.getClass());
		for (java.lang.reflect.Field field : fields) {
			if (Field.class.isAssignableFrom(field.getType())) {
				try {
					Field<?> f = (Field<?>)FieldUtils.readField(field, o, true);
					if (f != null) {
						result.add(f);
					}

				} catch (IllegalAccessException e) {
					throw new IllegalArgumentException(e);
				}
			}
		}
		return result;
	}

	private void callback(Callback callback, Field<?> f, Object v) {
		if (v != null) {
			LOGGER.info("Callback for field: {}", f);
			callback.field(f);
		}
	}
}
