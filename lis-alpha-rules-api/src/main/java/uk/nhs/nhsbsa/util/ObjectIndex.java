package uk.nhs.nhsbsa.util;

import java.util.HashMap;
import java.util.Map;

import uk.nhs.nhsbsa.util.ObjectWalker.CallbackItem;

public class ObjectIndex {

	private Map<String, Object> pathIndex = new HashMap<>();
	private Map<Object, String> objectIndex = new HashMap<>();
	
	public ObjectIndex(Object root) {
		index(null, root);
	}
	
	public void reindex(Object o) {
		String path = path(o);
		index(path + "/", o);
	}
	
	private void index(final String path, Object root) {
		ObjectWalker walker = new ObjectWalker(root, new ObjectWalker.Callback() {
			@Override
			public void handle(CallbackItem callbackItem) {
				String fullpath = path == null ? callbackItem.getPath() : path + callbackItem.getPath();
				pathIndex.put(fullpath, callbackItem.getValue());
				objectIndex.put(callbackItem.getValue(), fullpath);
			}
		});
		walker.walk();
	}

	public String path(Object o) {
		
		return objectIndex.get(o);
	}
	
	public Object get(String path) {
		
		return pathIndex.get(path);
	}
}
