package net.nhs.nhsbsa.lis.rules.app.assembler;

import java.util.HashMap;
import java.util.Map;

import org.springframework.util.Assert;

import net.nhs.nhsbsa.lis.rules.app.model.AssessmentModel;
import uk.nhs.nhsbsa.rules.types.Field;

public class AssessmentModelIndexer {

	public Map<String, Field<?>> index(AssessmentModel model) {
		
		Assert.notNull(model);
		Map<String, Field<?>> result = new HashMap<>();
		for (Field<?> field : model.getFields()) {
			result.put(field.getName(), field);
		}
		return result;
	}
}
