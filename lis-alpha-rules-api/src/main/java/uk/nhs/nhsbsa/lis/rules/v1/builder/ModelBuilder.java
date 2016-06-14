package uk.nhs.nhsbsa.lis.rules.v1.builder;

import uk.nhs.nhsbsa.rules.builder.AbstractBuilder;
import uk.nhs.nhsbsa.rules.builder.FieldBuilder;
import uk.nhs.nhsbsa.rules.types.Field;

public class ModelBuilder<T> extends AbstractBuilder<T> {

	private ModelBuilder<?> modelParent;
	
	public ModelBuilder() {
		super();
	}

	public ModelBuilder(ModelBuilder<?> parent, T instance) {
		super(null, instance);
		Field<T> field = new Field<>(this.instance);
		FieldBuilder<T> fieldParent = new FieldBuilder<T>(parent, field); 
		this.parent = fieldParent;
		modelParent = parent;
	}

	@Override
	public AbstractBuilder<?> getParent() {
		return modelParent;
	}
	
	public Field<T> getField() {
		return getFieldBuilder().getInstance();
	}

	@SuppressWarnings("unchecked")
	public FieldBuilder<T> getFieldBuilder() {
		return (FieldBuilder<T>) super.getParent();
	}
}
