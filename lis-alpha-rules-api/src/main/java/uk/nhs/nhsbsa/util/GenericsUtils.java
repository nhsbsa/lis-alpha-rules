package uk.nhs.nhsbsa.util;

import org.springframework.core.GenericTypeResolver;

public class GenericsUtils {

	@SuppressWarnings("rawtypes")
	public static Class genericClass(Class genericClass, Class genericInterface, int index) {
		
		Class<?>[] types = GenericTypeResolver.resolveTypeArguments(genericClass, genericInterface);
		return types[index];
	}

}
