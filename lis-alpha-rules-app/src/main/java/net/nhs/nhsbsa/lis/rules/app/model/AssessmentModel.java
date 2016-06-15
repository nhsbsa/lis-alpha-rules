package net.nhs.nhsbsa.lis.rules.app.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;

import uk.nhs.nhsbsa.rules.types.Field;

public class AssessmentModel {

	@Id
	private String id;
	
	private List<Field<?>> fields = new ArrayList<>();

	public List<Field<?>> getFields() {
		return fields;
	}

	public void setFields(List<Field<?>> fields) {
		this.fields = fields;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
}
