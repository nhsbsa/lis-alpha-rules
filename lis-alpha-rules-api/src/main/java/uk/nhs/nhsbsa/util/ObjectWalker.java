package uk.nhs.nhsbsa.util;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang3.reflect.FieldUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Assert;

/**
 * Class to walk an object model and callback for every Field discovered. 
 */
public class ObjectWalker {

	private static final Logger LOGGER = LoggerFactory.getLogger(ObjectWalker.class);
	
	/**
	 * Interface for callback from object walk.
	 */
	public static interface Callback {
		void handle(CallbackItem callbackItem);
	}
	
	/**
	 * Class to hold callback data.
	 */
	public static class CallbackItem {
		private Object object;
		private Field field;
		private Object value;
		private String path;
		public CallbackItem(Object object, Field field, Object value, String path) {
			super();
			this.object = object;
			this.field = field;
			this.value = value;
			this.path = path;
		}
		@Override
		public String toString() {
			return object + "(" + field.getName() + ") = " + field + " [" + path + "]";
		}
		public Object getObject() {
			return object;
		}
		public Field getField() {
			return field;
		}
		public Object getValue() {
			return value;
		}
		public String getPath() {
			return path;
		}
		
	}
	
	/**
	 * Whether to traverse breadth or depth first.
	 */
	public static enum Traversal {
		
		BREADTH_FIRST,
		
		DEPTH_FIRST
	}

	/**
	 * Cache of objects already traversed.
	 */
	private Set<Object> cache = new HashSet<>();
	
	/**
	 * Traversal pattern.
	 */
	private Traversal traversal;
	
	private Object root;
	
	private Callback callback;
	
	/**
	 * Convenience constructor.
	 */
	public ObjectWalker(Object root, Callback callback) {
		this(root, callback, Traversal.DEPTH_FIRST);
	}

	/**
	 * Convenience constructor.
	 */
	public ObjectWalker(Object root, Callback callback, Traversal traversal) {
		Assert.notNull(callback);
		this.root = root;
		this.callback = callback;
		this.traversal = traversal;
	}

	/**
	 * Walk an object tree, calling back for every Field found.
	 * @param o
	 * @param callback
	 */
	public void walk() {
		walk("", root);
	}

	private void walk(String path, Object o) {
		if (traverse(o)) {
			cache.add(o);
			List<CallbackItem> fields = getFields(path, o);
			if (traversal == Traversal.DEPTH_FIRST) {
				recurse(fields);
			}
			callback(fields);
			if (traversal == Traversal.BREADTH_FIRST) {
				recurse(fields);
			}
		}
	}

	private boolean traverse(Object o) {
		boolean result = false;
		if (o != null) {
			Class<?> clazz = o.getClass();
			if (!clazz.isPrimitive()) {
				result = !(o instanceof String);
			}
		}
		return result;
	}

	/**
	 * Notify callbacks.
	 * @param items
	 * @param callback
	 */
	private void callback(List<CallbackItem> items) {
		for (CallbackItem item : items) {
			callback(item);
		}
	}

	private void callback(CallbackItem item) {
		LOGGER.info("Callback for : {} > {}: {} {}", new Object[]{
				item.object,
				item.field.getName(),
				item.value,
				item.path
		});
		callback.handle(item);
	}

	/**
	 * Recurse through tree.
	 * @param items
	 * @param callback
	 */
	private void recurse(List<CallbackItem> items) {
		for (CallbackItem item : items) {
			Object v = item.value;
			if (!cache.contains(v)) {
				walk(item.path, item.value);
			}
		}
	}

	/**
	 * Traverse object's java.reflect.Fields and collect all of type uk.nhs.nhsbsa.rules.types.Field.
	 * @param o
	 * @return
	 */
	private List<CallbackItem> getFields(String path, Object o) {
		List<CallbackItem> result = new ArrayList<>();
		List<Field> fields = FieldUtils.getAllFieldsList(o.getClass());
		for (java.lang.reflect.Field field : fields) {
			try {
				String fieldName = field.getName();
				String fieldPath = path + "/" + fieldName;
				Object value = FieldUtils.readField(field, o, true);
				addCallbackItems(result, o, field, value, fieldPath);

			} catch (IllegalAccessException e) {
				throw new IllegalArgumentException(e);
			}
		}
		return result;
	}

	private void addCallbackItems(List<CallbackItem> items, Object o, Field field, Object value, String fieldPath) {

		if (value == null) {
			items.add(new CallbackItem(o, field, value, fieldPath));
			
		} else if (value instanceof Collection) {
			Collection<?> collection = (Collection<?>)value;
			addCollection(items, o, field, fieldPath, collection);
			
		} else if (value.getClass().isArray()) {
			Collection<?> collection = Arrays.asList((Object[])value);
			addCollection(items, o, field, fieldPath, collection);
			
		} else if (value instanceof Map) {
			Map<?, ?> map = (Map<?, ?>)value;
			addMap(items, o, field, fieldPath, map);
			
		} else {
			items.add(new CallbackItem(o, field, value, fieldPath));
		}
	}

	private void addMap(List<CallbackItem> items, Object o, Field field, String fieldPath, Map<?, ?> map) {
		
		String itemPath;
		for (Map.Entry<?, ?> entry : map.entrySet()) {
			itemPath = fieldPath + "[" + entry.getKey() + "]";
			items.add(new CallbackItem(o, field, entry.getValue(), itemPath));
		}
	}

	private void addCollection(List<CallbackItem> items, Object o, Field field, String fieldPath,
			Collection<?> collection) {

		int i = 0;
		String itemPath;
		for (Object item : collection) {
			itemPath = fieldPath + "[" + i++ + "]";
			items.add(new CallbackItem(o, field, item, itemPath));
		}
	}
}
