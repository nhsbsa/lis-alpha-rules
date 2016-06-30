package net.nhs.nhsbsa.lis.rules.app.propertyeditors;

import java.beans.PropertyEditorSupport;
import java.time.LocalDate;

import org.springframework.util.StringUtils;

public class LocalDatePropertyEditor extends PropertyEditorSupport {

	/**
	 * Parse the Date from the given text, using the specified DateFormat.
	 */
	@Override
	public void setAsText(String text) throws IllegalArgumentException {

		// Treat empty String as null value.
		if (!StringUtils.hasText(text)) {
			setValue(null);
		}
		else {
			setValue(LocalDate.parse(text));
		}
	}

	/**
	 * Format the Date as String, using the specified DateFormat.
	 */
	@Override
	public String getAsText() {
		LocalDate value = (LocalDate) getValue();
		return (value != null ? value.toString() : "");
	}
}
