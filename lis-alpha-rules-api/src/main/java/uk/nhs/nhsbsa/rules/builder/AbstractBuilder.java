package uk.nhs.nhsbsa.rules.builder;

import com.fasterxml.jackson.databind.util.ClassUtil;

import uk.nhs.nhsbsa.util.GenericsUtils;

public class AbstractBuilder<T> {

	protected AbstractBuilder<?> parent;
	
	protected T instance;

	public AbstractBuilder() {
		this(null, null);
	}

	public AbstractBuilder(AbstractBuilder<?> parent, T instance) {
		if (instance == null) {
			instantiate();
		} else {
			this.instance = instance;
		}
		this.parent = parent;
	}

	/**
	 * Create instance using generics
	 */
	@SuppressWarnings("unchecked")
	private void instantiate() {
		
		Class<T> clazz = GenericsUtils.genericClass(getClass(), 0);
		instance = ClassUtil.createInstance(clazz, true);
	}

	public T getInstance() {
		return instance;
	}

	public AbstractBuilder<?> getParent() {
		return parent;
	}

}
