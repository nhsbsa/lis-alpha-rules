package net.nhs.nhsbsa.lis.rules.app.exception;

import org.slf4j.helpers.MessageFormatter;

public class ExceptionUtils {

	public static IllegalArgumentException illegalArgument(String message, Object... args) {
		throw new IllegalArgumentException(formatMessage(message, args));
	}
	
	private static String formatMessage(String message, Object... args) {
		return MessageFormatter.arrayFormat(message, args).getMessage();
	}
}
