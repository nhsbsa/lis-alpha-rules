package net.nhs.nhsbsa.lis.rules.app;

import org.slf4j.helpers.MessageFormatter;

public class MvcUtils {

	public static final String redirect(String path, Object... argArray) {
		
		return "redirect:" + MessageFormatter.arrayFormat(path, argArray).getMessage();
	}
}
