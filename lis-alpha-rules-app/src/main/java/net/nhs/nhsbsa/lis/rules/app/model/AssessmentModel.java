package net.nhs.nhsbsa.lis.rules.app.form;

import java.util.List;

import uk.nhs.nhsbsa.rules.types.Field;

public class FormModel {

	private List<Field<?>> fields;

	public List<Field<?>> getFields() {
		return fields;
	}

	public void setFields(List<Field<?>> fields) {
		this.fields = fields;
	}
	
}
