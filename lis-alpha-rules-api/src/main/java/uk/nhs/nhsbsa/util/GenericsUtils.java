package uk.nhs.nhsbsa.util;

import java.lang.reflect.ParameterizedType;

public class GenericsUtils {

	@SuppressWarnings("rawtypes")
	public static Class genericClass(Class genericClass, int index) {
		ParameterizedType parameterizedType = (ParameterizedType) genericClass.getGenericSuperclass();
		return (Class) parameterizedType.getActualTypeArguments()[0];
	}

}
