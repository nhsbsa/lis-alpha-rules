package uk.nhs.nhsbsa.util;

public class FieldUtils {

	public static boolean isPrimitive(Class<?> clazz) {
		return clazz.isPrimitive()
				|| String.class.isAssignableFrom(clazz);
	}

}
