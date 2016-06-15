package net.nhs.nhsbsa.lis.rules.app.assembler;

import java.util.HashMap;
import java.util.Map;

import org.springframework.util.Assert;

import net.nhs.nhsbsa.lis.rules.app.model.AssessmentModel;
import uk.nhs.nhsbsa.rules.types.Field;

public class AssessmentModelIndexer {

	@SuppressWarnings("unchecked")
	public Map<String, Field<Object>> index(AssessmentModel model) {
		
		Assert.notNull(model);
		Map<String, Field<Object>> result = new HashMap<>();
		if (model.getFields() != null) {
			for (Field<?> field : model.getFields()) {
				result.put(field.getName(), (Field<Object>)field);
			}
		}
		return result;
	}
}
