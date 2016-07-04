package uk.nhs.nhsbsa.lis.rules.v1.builder;

import com.fasterxml.jackson.databind.util.ClassUtil;

import uk.nhs.nhsbsa.util.GenericsUtils;

public class AbstractBuilder<T> {

	protected AbstractBuilder<?> parent;
	
	protected T instance;
	
	private String name;

	public AbstractBuilder() {
		this(null, null, null);
	}

	public AbstractBuilder(AbstractBuilder<?> parent, String name, T instance) {
		if (instance == null) {
			instantiate();
		} else {
			this.instance = instance;
		}
		this.name = name;
		this.parent = parent;
	}

	/**
	 * Create instance using generics
	 */
	@SuppressWarnings("unchecked")
	private void instantiate() {
		
		Class<T> clazz = GenericsUtils.genericClass(getClass(), AbstractBuilder.class, 0);
		instance = ClassUtil.createInstance(clazz, true);
	}

	public T getInstance() {
		return instance;
	}

	public AbstractBuilder<?> getParent() {
		return parent;
	}

	public String getName() {
		return name;
	}

}
