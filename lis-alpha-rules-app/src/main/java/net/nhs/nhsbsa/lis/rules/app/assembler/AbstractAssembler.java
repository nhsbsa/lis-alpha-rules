package net.nhs.nhsbsa.lis.rules.app.assembler;

import java.lang.reflect.ParameterizedType;

import org.springframework.util.TypeUtils;

public abstract class AbstractAssembler<S, D> implements IAssembler<S, D> {

	private Class<S> sourceClass;
	private Class<D> destinationClass;
	
	@SuppressWarnings( "unchecked" )
	public AbstractAssembler() {
		this.sourceClass = (Class<S>) ((ParameterizedType) getClass()
                .getGenericSuperclass()).getActualTypeArguments()[0];
		this.destinationClass = (Class<D>) ((ParameterizedType) getClass()
                .getGenericSuperclass()).getActualTypeArguments()[1];
	}
	
	@Override
	public boolean accept(Class<?> source, Class<?> destination) {
		return TypeUtils.isAssignable(sourceClass, source)
				&& TypeUtils.isAssignable(destinationClass, destination);
	}

}
