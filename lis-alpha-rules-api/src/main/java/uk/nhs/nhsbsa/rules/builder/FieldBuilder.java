package uk.nhs.nhsbsa.rules.builder;

import uk.nhs.nhsbsa.rules.types.Field;

/**
 * Build Field objects using fluent API.
 */
public class FieldBuilder<T> extends AbstractBuilder<Field<T>> {

	public FieldBuilder() {
		super();
	}

	public FieldBuilder(AbstractBuilder<?> parent, Field<T> instance) {
		super(parent, instance);
	}

	public FieldBuilder<T> withName(String name) {
		instance.setName(name);
		return this;
	}

	public FieldBuilder<T> withValue(T value) {
		instance.setValue(value);
		return this;
	}
}
