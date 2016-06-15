package net.nhs.nhsbsa.lis.rules.app.assembler;

import org.springframework.core.GenericTypeResolver;
import org.springframework.util.TypeUtils;

public abstract class AbstractAssembler<S, D> implements IAssembler<S, D> {

	private Class<S> sourceClass;
	private Class<D> destinationClass;
	
	@SuppressWarnings( "unchecked" )
	public AbstractAssembler() {
		Class<?>[] types = GenericTypeResolver.resolveTypeArguments(getClass(), IAssembler.class);
		this.sourceClass = (Class<S>) types[0];
		this.destinationClass = (Class<D>) types[1]; 
	}
	
	@Override
	public boolean accept(Class<?> source, Class<?> destination) {
		boolean result =  TypeUtils.isAssignable(sourceClass, source)
				&& TypeUtils.isAssignable(destinationClass, destination);
		return result;
	}

}
