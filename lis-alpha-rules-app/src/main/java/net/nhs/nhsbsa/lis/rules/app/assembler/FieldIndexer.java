package net.nhs.nhsbsa.lis.rules.app.assembler;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import uk.nhs.nhsbsa.rules.types.Field;

public class FieldIndexer {

	@SuppressWarnings("unchecked")
	public Map<String, Field<Object>> index(List<Field<?>> fields) {
		
		Map<String, Field<Object>> result = new HashMap<>();
		if (fields != null) {
			for (Field<?> field : fields) {
				result.put(field.getName(), (Field<Object>)field);
			}
		}
		return result;
	}
}
