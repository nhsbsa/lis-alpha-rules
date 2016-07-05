package uk.nhs.nhsbsa.util;

import java.util.Map;

import uk.nhs.nhsbsa.util.ObjectWalker.CallbackItem;

public class ObjectIndex {

	private Map<String, Object> pathIndex;
	private Map<Object, String> objectIndex;
	
	public ObjectIndex(Object root) {
		index(root);
	}
	
	private void index(Object root) {
		ObjectWalker walker = new ObjectWalker(root, new ObjectWalker.Callback() {
			@Override
			public void handle(CallbackItem callbackItem) {
				pathIndex.put(callbackItem.getPath(), callbackItem.getValue());
				objectIndex.put(callbackItem.getValue(), callbackItem.getPath());
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
